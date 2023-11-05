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
        frame.setLayout(new BorderLayout()); // Use BorderLayout for the main frame
        createUIComponents();
        frame.pack();
        frame.setVisible(true);
    }
    private JButton createStyledButton(String text, String bgColorRGB) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        String[] rgb = bgColorRGB.split(",");
        int r = Integer.parseInt(rgb[0]);
        int g = Integer.parseInt(rgb[1]);
        int b = Integer.parseInt(rgb[2]);


        button.setBackground(Color.ORANGE);


        button.setForeground(Color.BLACK);


        button.setPreferredSize(new Dimension(250, 60));

        return button;
    }

    private void createUIComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());


        JLabel headerLabel = new JLabel("Activity Tracker");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE); // Change the text color to white
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.BLACK); // Change the background color to black
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.BLACK); // Change the background color of the center panel to black

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(Color.BLACK); // Change the background color of the text area to black
        textArea.setForeground(Color.WHITE); // Change the text color to white
        JScrollPane scrollPane = new JScrollPane(textArea);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JComboBox<String> activityTypeComboBox = new JComboBox<>();
        for (Activity activity : listOfActivities) {
            String type = activity.getType_of_activity();
            if (!containsItem(activityTypeComboBox, type)) {
                activityTypeComboBox.addItem(type);
            }
        }

        // Create styled buttons
        JButton avgDistanceButton = createStyledButton("Calculate Average Distance", "50,150,50");
        avgDistanceButton.setForeground(Color.BLACK);
        avgDistanceButton.setBackground(Color.ORANGE);

        JButton avgCaloriesButton = createStyledButton("Calculate Average Calories Burnt", "50,150,50");
        avgCaloriesButton.setForeground(Color.BLACK);
        avgCaloriesButton.setBackground(Color.ORANGE);

        JButton viewActivityButton = createStyledButton("View Activity Details", "255,0,0");
        viewActivityButton.setForeground(Color.BLACK);
        viewActivityButton.setBackground(Color.ORANGE);

        JButton getActivityDetailsButton = createStyledButton("Get Intensity and Calories Burnt", "255,0,0");
        getActivityDetailsButton.setForeground(Color.BLACK);
        getActivityDetailsButton.setBackground(Color.ORANGE); // Change the button's background color to orange

        buttonPanel.add(activityTypeComboBox);
        buttonPanel.add(avgDistanceButton);
        buttonPanel.add(avgCaloriesButton);
        buttonPanel.add(viewActivityButton);
        buttonPanel.add(getActivityDetailsButton);

        centerPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

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



        avgCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
                if (selectedActivityType != null) {
                    double averageCalories = calculateAverageCalories(selectedActivityType);
                    textArea.append("\nAverage amount of burnt calories for " + selectedActivityType + " activities is " + averageCalories + " cal");
                }
            }
        });




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



        getActivityDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
                if (selectedActivityType != null) {
                    String selectedDate = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY):");
                    Activity selectedActivity = findActivityByDate(selectedDate, selectedActivityType);
                    if (selectedActivity != null) {
                        String details = "Intensity: " + selectedActivity.getIntensity() + ", Calories Burnt: " + selectedActivity.getCaloriesBurnt() + " cal";
                        textArea.append("\n" + details);
                    } else {
                        textArea.append("\nActivity not found for the given date and type.");
                    }
                }
            }
        });
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

    private double calculateAverageCalories(String activityType) {
        double totalCalories = 0;
        int activityCount = 0;

        for (Activity activity : listOfActivities) {
            if (Objects.equals(activity.getType_of_activity(), activityType)) {
                totalCalories += activity.getCaloriesBurnt();
                activityCount++;
            }
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

        // Example data for testing
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
