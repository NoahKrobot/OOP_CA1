import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActivityTrackerUI {
    private JFrame frame;
    private ArrayList<Activity> listOfActivities;

    public ActivityTrackerUI(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        createUIComponents();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton displayDataButton = new JButton("Display Activity Data");
        displayDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayActivityData(textArea);
            }
        });

        JButton avgDistanceButton = new JButton("Calculate Average Distance");
        avgDistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double averageDistance = calculateAverageDistance();
                textArea.append("\nAverage distance in activities is: " + averageDistance + " km");
            }
        });

        JButton avgCaloriesButton = new JButton("Calculate Average Calories Burnt");
        avgCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double averageCalories = calculateAverageCalories();
                textArea.append("\nAverage amount of burnt calories is " + averageCalories + " cal");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(displayDataButton);
        buttonPanel.add(avgDistanceButton);
        buttonPanel.add(avgCaloriesButton);

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

    private double calculateAverageDistance() {
        double totalDistance = 0;
        int activityCount = listOfActivities.size();

        for (Activity activity : listOfActivities) {
            totalDistance += activity.getDistance_km();
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

    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActivityTrackerUI(activities);
            }
        });
    }
}
