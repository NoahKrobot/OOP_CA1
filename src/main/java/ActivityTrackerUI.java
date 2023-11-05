import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class ActivityTrackerUI {
    private JFrame frame;
    private ArrayList<Activity> listOfActivities;

    public ActivityTrackerUI(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1)); // Vertical GridLayout
        createUIComponents();
        frame.pack(); // Adjust the frame size to fit the components
        frame.setVisible(true);
    }

    private void createUIComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1)); // Vertical GridLayout

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JComboBox<String> activityTypeComboBox = new JComboBox<>();
        for (Activity activity : listOfActivities) {
            String type = activity.getType_of_activity();
            if (!containsItem(activityTypeComboBox, type)) {
                activityTypeComboBox.addItem(type);
            }
        }

        JButton avgDistanceButton = new JButton("Calculate Average Distance");
        avgDistanceButton.setFont(new Font("Arial", Font.BOLD, 16));
        avgDistanceButton.setBackground(new Color(50, 150, 50));
        avgDistanceButton.setForeground(Color.BLACK);
        avgDistanceButton.setPreferredSize(new Dimension(250, 60));
        avgDistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
                if (selectedActivityType != null) {
                    double averageDistance = calculateAverageDistance(selectedActivityType);
                    textArea.append("\nAverage distance in " + selectedActivityType + " activities is: " + averageDistance + " km");
                }
            }
        });

        JButton avgCaloriesButton = new JButton("Calculate Average Calories Burnt");
        avgCaloriesButton.setFont(new Font("Arial", Font.BOLD, 16));
        avgCaloriesButton.setBackground(new Color(50, 150, 50));
        avgCaloriesButton.setForeground(Color.BLACK);
        avgCaloriesButton.setPreferredSize(new Dimension(250, 60));
        avgCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double averageCalories = calculateAverageCalories();
                textArea.append("\nAverage amount of burnt calories is " + averageCalories + " cal");
            }
        });

        JButton viewActivityButton = new JButton("View Activity Details");
        viewActivityButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewActivityButton.setBackground(Color.RED);;
        viewActivityButton.setForeground(Color.BLACK);
        viewActivityButton.setPreferredSize(new Dimension(250, 60));
        viewActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
                if (selectedActivityType != null) {
                    String selectedDate = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY):");
                    System.out.println("Entered Date: " + selectedDate);

                    Activity selectedActivity = findActivityByDate(selectedDate, selectedActivityType);
                    System.out.println("Selected Activity: " + selectedActivity);

                    if (selectedActivity != null) {
                        textArea.append("\nActivity Type: " + selectedActivity.getType_of_activity());
                        textArea.append("\nDate: " + selectedActivity.getDate());
                        textArea.append("\nDistance: " + selectedActivity.getDistance_km() + " km");
                        textArea.append("\nIntensity: " + selectedActivity.getIntensity());
                        textArea.append("\nCalories Burnt: " + selectedActivity.getCaloriesBurnt() + " cal");
                    } else {
                        textArea.append("\nActivity not found for the given date and type.");
                    }
                }
            }
        });
        JButton getActivityDetailsButton = new JButton("Get Intensity and Calories Burnt");
        getActivityDetailsButton.setFont(new Font("Arial", Font.BOLD, 16));
        getActivityDetailsButton.setBackground(Color.RED);
        getActivityDetailsButton.setForeground(Color.BLACK);
        getActivityDetailsButton.setPreferredSize(new Dimension(250, 60));

        JTextField activityDetailsField = new JTextField(25);
        activityDetailsField.setEditable(false);
        activityDetailsField.setFont(new Font("Arial", Font.PLAIN, 16));

        getActivityDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
                if (selectedActivityType != null) {
                    String selectedDate = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY):");
                    Activity selectedActivity = findActivityByDate(selectedDate, selectedActivityType);
                    if (selectedActivity != null) {
                        String details = "Intensity: " + selectedActivity.getIntensity() + ", Calories Burnt: " + selectedActivity.getCaloriesBurnt() + " cal";
                        activityDetailsField.setText(details);
                    } else {
                        activityDetailsField.setText("Activity not found for the given date and type.");
                    }
                }
            }
        });


        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(activityTypeComboBox);
        buttonPanel.add(avgDistanceButton);
        buttonPanel.add(avgCaloriesButton);
        buttonPanel.add(viewActivityButton);
        buttonPanel.add(activityDetailsField);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
    }


    private void displayActivityData(JTextArea textArea) {
        textArea.setText(""); // Clear the text area
        for (Activity activity : listOfActivities) {
            textArea.append(activity.toString() + "\n");
        }
    }
    private boolean containsItem(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }
    private double calculateAverageDistance(String activityType) {
        double totalDistance = 0;
        int activityCount = 0;

        for (Activity activity : listOfActivities) {
            if (Objects.equals(activity.getType_of_activity(), activityType)) {
                totalDistance += activity.getDistance_km();
                activityCount++;
            }
        }

        return activityCount > 0 ? totalDistance / activityCount : 0;
    }

    private double calculateAverageCalories() {
        double totalCalories = 0;
        int activityCount = listOfActivities.size();

        for (Activity activity : listOfActivities) {
            totalCalories += activity.getCaloriesBurnt();
        }

        return activityCount > 0 ? totalCalories / activityCount : 0;
    }
    private Activity findActivityByDate(String date, String activityType) {
        for (Activity activity : listOfActivities) {
            if (activity.getDate().equals(date) && activity.getType_of_activity().equals(activityType)) {
                return activity;
            }
        }
        return null; // Activity not found
    }

    public static void main(String[] args) {

        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Running", "04/01/2020", 67, 8.80, 152));
        activities.add(new Activity("Swimming", "05/01/2020", 92, 4.01, 145));
        activities.add(new Activity("Cycling", "10/01/2020", 107, 27.45, 106));
        activities.add(new Activity("Swimming", "06/01/2020", 57, 1.63, 104));
        activities.add(new Activity("Swimming", "07/01/2020", 120, 7.37, 148));
        activities.add(new Activity("Running", "03/01/2020", 101, 14.10, 151));
        activities.add(new Activity("Cycling", "02/01/2020", 33, 6.06, 107));
        activities.add(new Activity("Cycling", "11/01/2020", 71, 17.16, 143));
        activities.add(new Activity("Swimming", "08/01/2020", 103, 6.00, 95));
        activities.add(new Activity("Cycling", "07/01/2020", 98, 25.34, 112));


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActivityTrackerUI(activities);
            }
        });
    }
}
