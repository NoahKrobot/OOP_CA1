import java.util.*;

public class ActivityTracker{
    public static void naturalOrder(ArrayList<Activity> listOfActivities) {

//        date is MM/DD/YYYY
        String correctActivity= "";
        String correctDate = "";


        Collections.sort(listOfActivities);

        System.out.println(" *** Search an activity based on a date *** ");

        //activity
        correctActivity= validateType();

        //date
        correctDate = validDate();

        // Only date is relevant for comparison
        Activity searchActivity = new Activity(correctActivity, correctDate, 0, 0, 0);


        int elementIndex = Collections.binarySearch(listOfActivities, searchActivity);
        if (elementIndex >= 0) {
            System.out.println("Activity found: " + listOfActivities.get(elementIndex));
        } else {
            System.out.println("Activity not found");
        }
    }


    public static String validateType(){
        Scanner validKey = new Scanner(System.in);

        String correctType ="";
        boolean runWhile = true;

        while(runWhile){
            correctType ="";

            System.out.println("enter an activity: ");
            correctType = validKey.nextLine();
            System.out.println(correctType);

            if(Objects.equals(correctType, "Swimming")||
               Objects.equals(correctType, "Running")||
               Objects.equals(correctType, "Cycling"))
            {
                runWhile=false;
            }else{
                System.out.println("Invalid type of activity");
            }
        }
        return correctType;
    }


    public static String validDate (){
        Scanner keyValid = new Scanner(System.in);
        // MM/DD/YYYY
        String fullCorrectDate ="";
        boolean runWhile = true;
        boolean testBoolean = true;

        while(runWhile){
            System.out.println("enter a date: ");
            fullCorrectDate = keyValid.nextLine();

//            runWhile= checkDateType(fullCorrectDate);
            testBoolean = checkDateType(fullCorrectDate);
            if(!testBoolean){
                System.out.println("nice");
                runWhile=false;
            }

        }
        return fullCorrectDate;
    }

    public static boolean checkDateType(String date){
        String slash = "/";
        boolean checkIfWrong = true;
        int firstSlash = date.indexOf('/');
        int secondSlash = date.lastIndexOf('/');

    // MM/DD/YYYY

        while(checkIfWrong){
            if(date.length()==10){  //chech that it's 10 characters
                if(firstSlash==2 && secondSlash==5){  //check for two slash characters
                    checkIfWrong = false;
                }
            }
        }
        return checkIfWrong;
    }
}
