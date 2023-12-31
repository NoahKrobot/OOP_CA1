import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;


public class ActivityTrackerUI {
    private final JFrame frame;
    private final ArrayList<Activity> listOfActivities;
    private final ArrayList<Activity> filteredActivities;
    private JComboBox<String> sortOptions;
    private MyTableModel model;
    private String fileSource;
    public ActivityTrackerUI(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
        this.filteredActivities = new ArrayList<>();
        this.fileSource = fileSource;
        frame = new JFrame("Activity Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        createUIComponents();
        frame.setSize(800, 600); // Set a fixed size for the frame
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(250, 60));
        button.setBackground(Color.WHITE); // Modern blue color
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }

    private void createUIComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel headerLabel = new JLabel("Activity Tracker");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBackground(Color.WHITE); // Dark background color
        headerLabel.setOpaque(true);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(108, 122, 137)); // Dark background color

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(44, 62, 80));
        textArea.setForeground(Color.WHITE);
        JPanel p2 = new JPanel();

        JTable table=new JTable();
        model = new MyTableModel(listOfActivities);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        p2.add(scrollPane, BorderLayout.NORTH);
       // JScrollPane scrollPane = new JScrollPane(textArea);
        JScrollPane scrollPane2 = new JScrollPane(textArea);
        p2.add(scrollPane2, BorderLayout.NORTH);
        centerPanel.add(p2, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // GridLayout with 2 columns

        sortOptions = new JComboBox<>(new String[] {
                "Calories Burned (Descending)",
                "Date (Ascending)",
                "Date (Descending)",
                "Activity Duration (Ascending)",
                "Activity Duration (Descending)",
                "Type of Activity",
                "Distance (Ascending)",
                "Distance (Descending)"
        });





        JComboBox<String> activityTypeComboBox = new JComboBox<>();
        for (Activity activity : listOfActivities) {
            String type = activity.getType_of_activity();
            if (!containsItem(activityTypeComboBox, type)) {
                activityTypeComboBox.addItem(type);
            }
        }

        JButton addNewFileButton = createStyledButton("Add New File");

        JButton avgDistanceButton = createStyledButton("Calculate Average Distance");
        JButton avgCaloriesButton = createStyledButton("Calculate Average Calories Burnt");
        JButton viewActivityButton = createStyledButton("View Activity Details by date");
//        JButton getActivityDetailsButton = createStyledButton("Search Activity By Date");



        JButton searchByIntensityButton = createStyledButton("Search by Intensity");
        JButton searchByHeartRateButton = createStyledButton("Search by Heart Rate");
        JButton filterByDistanceButton  = createStyledButton("Filter by Distance");
        JButton filterByDurationButton  = createStyledButton("Filter by Duration");








        JPanel sortByPanel = new JPanel(new BorderLayout());

        JPanel sortOptionsPanel = new JPanel();
        sortOptionsPanel.add(sortOptions);

        JButton sortByButton = createStyledButton("Sort By");

        sortByButton.setPreferredSize(new Dimension(100, 20));

        sortByPanel.add(sortOptionsPanel, BorderLayout.CENTER);
        sortByPanel.add(sortByButton, BorderLayout.EAST);

        buttonPanel.add(addNewFileButton);
        buttonPanel.add(activityTypeComboBox);
        buttonPanel.add(avgDistanceButton);
        buttonPanel.add(avgCaloriesButton);
        buttonPanel.add(filterByDistanceButton);
        buttonPanel.add(filterByDurationButton);

        buttonPanel.add(viewActivityButton);
//        buttonPanel.add(getActivityDetailsButton);
        buttonPanel.add(sortByPanel);
        buttonPanel.add(searchByIntensityButton);
        buttonPanel.add(searchByHeartRateButton);

        centerPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        frame.add(mainPanel);


        avgDistanceButton.addActionListener(e -> {
            String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
            if (selectedActivityType != null) {
                double averageDistance = calculateAverageDistance(selectedActivityType);
                textArea.append("\nAverage distance in " + selectedActivityType + " activities is: " + averageDistance + " km");
            }
        });



        avgCaloriesButton.addActionListener(e -> {
            String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
            if (selectedActivityType != null) {
                double averageCalories = calculateAverageCalories(selectedActivityType);
                textArea.append("\nAverage amount of burnt calories for " + selectedActivityType + " activities is " + averageCalories + " cal");
            }
        });


        filterByDistanceButton.addActionListener(e -> {
            double minDistance = getMinDistance(); // Display input dialog for minimum distance
            if (minDistance >= 0) {
                filterActivitiesByDistance(minDistance);
                model.setActivities(filteredActivities);
                table.invalidate();
                table.repaint();
            }
        });

        filterByDurationButton.addActionListener(e -> {
            int minDuration = getMinDuration(); // Display input dialog for minimum duration
            if (minDuration >= 0) {
                filterActivitiesByDuration(minDuration);
                model.setActivities(filteredActivities);
                table.invalidate();
                table.repaint();
            }
        });

        viewActivityButton.addActionListener(e -> {
            String selectedDate = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY)");

            if (selectedDate != null && !selectedDate.isEmpty()) {
                System.out.println("Entered Date: " + selectedDate);

                ArrayList<Activity> act = new ArrayList<>();
                for (Activity activity : listOfActivities) {
                    if (activity.getDate().equals(selectedDate)) {
                        act.add(activity);
                    }
                }

                if (!act.isEmpty()) {
                    model.setActivities(act);
                    table.invalidate();
                    table.repaint();
                } else {
                    // If no activities found, show a message in the table
                    model.setActivities(new ArrayList<>()); // Clear the table
                    table.invalidate();
                    table.repaint();
                    textArea.setText("No activities found for the given date.");
                }
            }
        });




        // Search by intensity button listener
        searchByIntensityButton.addActionListener(e -> {
            String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
            if (selectedActivityType != null) {
                JComboBox<String> intensityComboBox = new JComboBox<>();
                List<String> uniqueIntensities = getUniqueIntensities();

                for (String intensity : uniqueIntensities) {
                    intensityComboBox.addItem(intensity);
                }

                JPanel dialogPanel = new JPanel();
                dialogPanel.add(new JLabel("Select Intensity:"));
                dialogPanel.add(intensityComboBox);

                int result = JOptionPane.showConfirmDialog(null, dialogPanel, "Search by Intensity", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String selectedIntensity = (String) intensityComboBox.getSelectedItem();
                    if (selectedIntensity != null) {
                        ArrayList<Activity> act = new ArrayList<>();
                        for (Activity activity : listOfActivities) {
                            if (activity.getIntensity().toString().equals(selectedIntensity)) {
                                act.add(activity);
                            }
                        }
                        model.setActivities(act);
                        table.invalidate();
                        table.repaint();
                    }
                }
            }
        });





        // Search by heart rate button listener
        searchByHeartRateButton.addActionListener(e -> {
            String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
            if (selectedActivityType != null) {
                JComboBox<String> heartRateComboBox = new JComboBox<>();
                List<String> uniqueHeartRates = getUniqueHeartRates(listOfActivities);

                for (String heartRate : uniqueHeartRates) {
                    heartRateComboBox.addItem(heartRate);
                }

                JPanel dialogPanel = new JPanel();
                dialogPanel.add(new JLabel("Select Heart Rate:"));
                dialogPanel.add(heartRateComboBox);

                int result = JOptionPane.showConfirmDialog(null, dialogPanel, "Search by Heart Rate", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String selectedHeartRate = (String) heartRateComboBox.getSelectedItem();
                    if (selectedHeartRate != null) {
                        ArrayList<Activity> act = new ArrayList<>();
                        for (Activity activity : listOfActivities) {
                            if (String.valueOf(activity.getAvg_heart_rate()).equals(selectedHeartRate)) {
                                act.add(activity);
                            }
                        }
                        model.setActivities(act);
                        table.invalidate();
                        table.repaint();
                    }
                }
            }
        });


        addNewFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String newFileSource = selectedFile.getAbsolutePath();

                try {
                    ArrayList<Activity> newActivities = new ArrayList<>();
                    newActivities = CSV_reader.fileReader(newFileSource, newActivities);
                    listOfActivities.clear();
                    listOfActivities.addAll(newActivities);

                    // Update the table to display the new data
                    model.setActivities(listOfActivities);
                    table.invalidate();
                    table.repaint();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading the selected file: " + ex.getMessage());
                }
            }
        });

//        getActivityDetailsButton.addActionListener(e -> {
//            String selectedActivityType = (String) activityTypeComboBox.getSelectedItem();
//            if (selectedActivityType != null) {
//                String selectedDate = JOptionPane.showInputDialog("Enter the date (MM/DD/YYYY):");
//                Activity selectedActivity = findActivityByDate(selectedDate, selectedActivityType);
//                if (selectedActivity != null) {
//                    String details = "Intensity: " + selectedActivity.getIntensity() + ", Calories Burnt: " + selectedActivity.getCaloriesBurnt() + " cal";
//                    textArea.append("\n" + details);
//                } else {
//                    textArea.append("\nActivity not found for the given date and type.");
//                }
//            }
//        });


     sortByButton.addActionListener(e  -> {
         String selectedSortOption = (String) sortOptions.getSelectedItem();
         if (selectedSortOption != null) {
             switch (selectedSortOption) {
                 case "Calories Burned (Descending)" -> listOfActivities.sort(new CompareCalories());
                 case "Date (Ascending)" -> listOfActivities.sort(new CompareDates());
                 case "Date (Descending)" -> listOfActivities.sort(new CompareDatesReversed());
                 case "Activity Duration (Ascending)" -> listOfActivities.sort(new CompareDuration());
                 case "Activity Duration (Descending)" -> listOfActivities.sort(new CompareDurationReversed());
                 case "Type of Activity" -> listOfActivities.sort(new CompareTypes());
                 case "Distance (Ascending)" -> listOfActivities.sort(new CompareDistances());
                 case "Distance (Descending)" -> listOfActivities.sort(new CompareDistanceReversed());
             }
             model.setActivities(listOfActivities);
             table.invalidate();
             table.repaint();

         }
     });
}
    private double getMinDistance() {
        JTextField minDistanceField = new JTextField();

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridLayout(1, 2));
        dialogPanel.add(new JLabel("Minimum Distance (km):"));
        dialogPanel.add(minDistanceField);

        int result = JOptionPane.showConfirmDialog(
                null,
                dialogPanel,
                "Enter Minimum Distance",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                double minDistance = Double.parseDouble(minDistanceField.getText());
                return minDistance;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        return -1; // Return a negative value to indicate invalid input
    }

    private int getMinDuration() {
        JTextField minDurationField = new JTextField();

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridLayout(1, 2));
        dialogPanel.add(new JLabel("Minimum Duration (min):"));
        dialogPanel.add(minDurationField);

        int result = JOptionPane.showConfirmDialog(
                null,
                dialogPanel,
                "Enter Minimum Duration",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                int minDuration = Integer.parseInt(minDurationField.getText());
                return minDuration;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        return -1; // Return a negative value to indicate invalid input
    }



    private void filterActivitiesByDistance(double minDistance) {
        filteredActivities.clear();

        for (Activity activity : listOfActivities) {
            double distance = activity.getDistance_km();
            if (distance >= minDistance) {
                filteredActivities.add(activity);
            }
        }
    }

    private void filterActivitiesByDuration(int minDuration) {
        filteredActivities.clear();

        for (Activity activity : listOfActivities) {
            int duration = (int) activity.getDuration_min();
            if (duration >= minDuration) {
                filteredActivities.add(activity);
            }
        }
    }


    private void displayActivityDetails(Activity activity, JTextArea textArea) {
        textArea.append("Type: " + activity.getType_of_activity() + "\n");
        textArea.append("Date: " + activity.getDate() + "\n");
        textArea.append("Duration (min): " + activity.getDuration_min() + "\n");
        textArea.append("Distance (km): " + activity.getDistance_km() + "\n");
        textArea.append("Average BPM: " + activity.getAvg_heart_rate() + " bpm\n");
        textArea.append("Calories Burned: " + activity.getCaloriesBurnt() + " cal\n\n");
    }





//private void displayActivityData(JTextArea textArea) {
//        textArea.setText(""); // Clear the text area
//
//        // Create headers
//        String header = String.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s%n",
//                "Type", "Date", "Duration (min)", "Distance (km)", "Average BPM", "Calories Burned");
//        String separator = "-".repeat(header.length()) + "\n";
//
//        textArea.append(separator);
//        textArea.append(header);
//        textArea.append(separator);
//
//        // Display activities
//        for (Activity activity : listOfActivities) {
//            textArea.append(String.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s%n",
//                    activity.getType_of_activity(),
//                    activity.getDate(),
//                    activity.getDuration_min(),
//                    activity.getDistance_km(),
//                    activity.getAvg_heart_rate(),
//                    activity.getCaloriesBurnt()));
//        }
//
//        textArea.append(separator);
//    }

    private List<String> getUniqueIntensities() {
        List<String> intensities = new ArrayList<>();

        for (Activity.INTENSITY intensity : Activity.INTENSITY.values()) {
            intensities.add(intensity.toString());
        }

        return intensities;
    }


    private List<String> getUniqueHeartRates(ArrayList<Activity> activities) {
        List<String> uniqueHeartRates = new ArrayList<>();

        for (Activity activity : activities) {
            String avgHeartRate = String.valueOf(activity.getAvg_heart_rate());
            if (!uniqueHeartRates.contains(avgHeartRate)) {
                uniqueHeartRates.add(avgHeartRate);
            }
        }
        return uniqueHeartRates;
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




    private void searchActivityByIntensity(String selectedIntensity) {
        ArrayList<Activity> act = new ArrayList<>();
        for (Activity activity : listOfActivities) {
            if (activity.getIntensity().toString().equals(selectedIntensity)) {
                act.add(activity);
            }
        }

    }







    private void searchActivityByHeartRate(String heartRate) {
        ArrayList<Activity> act = new ArrayList<>();
        // Convert the user-selected heart rate to a double for numeric comparison
        double selectedHeartRate = Double.parseDouble(heartRate);

        for (Activity activity : listOfActivities) {
            if (activity.getAvg_heart_rate() == selectedHeartRate) {
                act.add(activity);
            }
        }
    }






        public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        String fileSource = "src/main/java/CSV/activity_data_10.csv";//

        try {
            activities = CSV_reader.fileReader(fileSource, activities);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());

        }

        ArrayList<Activity> finalActivities = activities;
        SwingUtilities.invokeLater(() -> new ActivityTrackerUI(finalActivities));
    }
}
