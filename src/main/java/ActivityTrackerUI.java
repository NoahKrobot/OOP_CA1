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
        frame.setSize(600, 400);
        createUIComponents();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton avgDistanceButton = new JButton("Calculate Average Distance");
        avgDistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageDistance();
            }
        });
        panel.add(avgDistanceButton, BorderLayout.SOUTH);

        JButton avgCaloriesButton = new JButton("Calculate Average Calories Burnt");
        avgCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageCalories(textArea);
            }
        });
        panel.add(avgCaloriesButton, BorderLayout.SOUTH);

        frame.add(panel);
    }

    private void averageDistance() {
        // Implement the logic for calculating and displaying average distance here.
        // You can use the listOfActivities provided to access the data.
        // Update the text area with the results.
    }

    private void averageCalories(JTextArea textArea) {
        double caloriesGet = 0;
        int caloriesCounter = 0;

        for (Activity act : listOfActivities) {
            caloriesGet += act.getCaloriesBurnt();
            caloriesCounter++;
        }

        double caloriesAvgTotal = (caloriesCounter > 0) ? caloriesGet / caloriesCounter : 0;

        textArea.append("\nAverage amount of burnt calories is " + caloriesAvgTotal + ".");
    }
}
