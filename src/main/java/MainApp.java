import java.io.IOException;
import java.lang.reflect.AccessFlag;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ArrayList<Activity> listOfActivities = new ArrayList<Activity>();

        Activity act1 = new Activity("Swimming", 60,"13",1,13);
        act1.setIntensity();
        System.out.println(act1.getIntensity());
        act1.getCaloriesBurnt();

        listOfActivities.add(act1);

        averageDistance(listOfActivities);
    }


    public static void averageDistance(ArrayList<Activity> listOfActivities){
        double distance =0;
        double total=0;
        int counter=0;
        for(Activity act: listOfActivities){
            distance=distance+(act.getDistance_km());
            counter++;
        }
        total= distance/(double)counter;
        System.out.println(total);
    }





}