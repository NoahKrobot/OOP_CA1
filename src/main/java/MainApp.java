import java.io.IOException;
import java.lang.reflect.AccessFlag;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ArrayList<Activity> listOfActivities = new ArrayList<Activity>();

        Activity act1 = new Activity("Cycling", 60,"13",1,13);
        act1.setIntensity();
        System.out.println(act1.getIntensity());
        act1.getCaloriesBurnt();

        Activity act2 = new Activity("Swimming", 60,"13",4,13);
        Activity act3 = new Activity("Swimming", 60,"13",2,13);
        Activity act4 = new Activity("Running", 60,"13",1,13);

        listOfActivities.add(act1);
        listOfActivities.add(act2);
        listOfActivities.add(act3);
        listOfActivities.add(act4);

        averageDistance(listOfActivities);
    }


    public static void averageDistance(ArrayList<Activity> listOfActivities){

        double swimmmingDistance =0;
        int swimmingCounter=0;
        double swimmingTotal=0;

        double runningDistance =0;
        int runningCounter=0;
        double runningTotal=0;

        double cyclingDistance =0;
        int cyclingCounter=0;
        double cyclingTotal=0;


        for(Activity act: listOfActivities){

            if(Objects.equals(act.getType_of_activity(), "Swimming")){
                swimmmingDistance=swimmmingDistance+(act.getDistance_km());
                swimmingCounter++;
            }
            else if(Objects.equals(act.getType_of_activity(), "Running")){
                runningDistance=runningDistance+(act.getDistance_km());
                runningCounter++;
            }
            else if(Objects.equals(act.getType_of_activity(), "Cycling")){
                cyclingDistance=cyclingDistance+(act.getDistance_km());
                cyclingCounter++;
            }
        }

        swimmingTotal= swimmmingDistance/(double)swimmingCounter;
        System.out.println("Average distance in swimming activities is: "+ swimmingTotal +" km");

        runningTotal= runningDistance/(double)runningCounter;
        System.out.println("Average distance in running activities is: "+ runningTotal +" km");

        cyclingTotal= cyclingDistance/(double)cyclingCounter;
        System.out.println("Average distance in cycling activities is: "+ cyclingTotal +" km");

    }





}