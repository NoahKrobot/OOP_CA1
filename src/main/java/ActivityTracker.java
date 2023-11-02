import java.util.*;

public class ActivityTracker{
    public static void naturalOrder(ArrayList<Activity> listOfActivities) {

//        date is MM/DD/YYYY

        Collections.sort(listOfActivities);
        String correctActivity= "";
        correctActivity= validateType();

        String correctDate = "";
        correctDate = validDate();

        Activity searchActivity = new Activity(correctActivity, correctDate, 0, 0, 0); // Only date is relevant for comparison



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
