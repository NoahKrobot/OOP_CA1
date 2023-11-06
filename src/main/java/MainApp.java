import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainApp {
    public static void main(String[] args) throws IOException {


        ArrayList<Activity> listOfActivities = new ArrayList<Activity>();
        String fileSource = "src/main/java/CSV/activity_data_10.csv";

        CSV_reader.fileReader(fileSource, listOfActivities);


        CompareActivities.naturalOrder(listOfActivities);


//        CompareActivities.naturalOrder(listOfActivities);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActivityTrackerUI(listOfActivities);
            }
        });
    }


    public static void averageDistance(ArrayList<Activity> listOfActivities) {

        double swimmmingDistance = 0;
        int swimmingCounter = 0;
        double swimmingTotal = 0;

        double runningDistance = 0;
        int runningCounter = 0;
        double runningTotal = 0;

        double cyclingDistance = 0;
        int cyclingCounter = 0;
        double cyclingTotal = 0;


        for (Activity act : listOfActivities) {

            if (Objects.equals(act.getType_of_activity(), "Swimming")) {
                swimmmingDistance = swimmmingDistance + (act.getDistance_km());
                swimmingCounter++;
            } else if (Objects.equals(act.getType_of_activity(), "Running")) {
                runningDistance = runningDistance + (act.getDistance_km());
                runningCounter++;
            } else if (Objects.equals(act.getType_of_activity(), "Cycling")) {
                cyclingDistance = cyclingDistance + (act.getDistance_km());
                cyclingCounter++;
            }
        }

        swimmingTotal = swimmmingDistance / (double) swimmingCounter;
        System.out.println("Average distance in swimming activities is: " + swimmingTotal + " km");

        runningTotal = runningDistance / (double) runningCounter;
        System.out.println("Average distance in running activities is: " + runningTotal + " km");

        cyclingTotal = cyclingDistance / (double) cyclingCounter;
        System.out.println("Average distance in cycling activities is: " + cyclingTotal + " km");
    }

    public static void averageCalories(ArrayList<Activity> listOfActivities) {

        double caloriesGet = 0;
        int caloriesCounter = 0;
        double caloriesAvgTotal = 0;

        for (Activity act : listOfActivities) {
            caloriesGet = caloriesGet + act.getCaloriesBurnt();
            caloriesCounter++;
        }
        caloriesAvgTotal = caloriesGet + (double) caloriesCounter;
        System.out.println("Average amount of burnt calories is " + caloriesAvgTotal + ".");

    }
}




