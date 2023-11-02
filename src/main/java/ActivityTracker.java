import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActivityTracker{
    public static void naturalOrder(ArrayList<Activity> listOfActivities) {

//        date is DD-MM-YYYY
        listOfActivities.add(new Activity("Running", "10-10-2023", 30, 5, 120));
        listOfActivities.add(new Activity("Swimming", "12-10-2023", 45, 2, 110));

        Collections.sort(listOfActivities);



        String correctActivity= "";
        correctActivity= validateType();

        String correctDate = "";


        Activity searchActivity = new Activity(correctActivity, "2023-10-10", 0, 0, 0); // Only date is relevant for comparison



        int index = Collections.binarySearch(listOfActivities, searchActivity);
        if (index >= 0) {
            System.out.println("Activity found: " + listOfActivities.get(index));
        } else {
            System.out.println("Activity not found");
        }
    }


    public static String validateType(){
        Scanner validKey = new Scanner(System.in);

        String correctType ="";
        boolean runWhile = true;

        while(runWhile){

            correctType = validKey.nextLine();

            if(correctType.compareTo("Cycling") !=0  ||
               correctType.compareTo("Running") !=0  ||
               correctType.compareTo("Swimming") !=0
            ){
                System.out.println("Invalid type of activity");
            }else{
                runWhile=false;
            }
        }
        return correctType;
    }


    public static String validDate (){
        String fullCorrectDate ="";


        return fullCorrectDate;
    }
}
