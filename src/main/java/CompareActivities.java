import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;


/*
1. - search two activities based on a date
2. - allow user to compare each attribute of both activties
     (output: Name is the same, date is not the same, etc...)

 */

public class CompareActivities{

    public static void naturalOrder(ArrayList<Activity> listOfActivities) {

        System.out.println("\n\n\n");

//        Collections.sort(listOfActivities);
//        displayList(listOfActivities);

//        displayCompareTypes(listOfActivities);
//        displayCompareDates(listOfActivities);
//        displayCompareDistance(listOfActivities);
//        displayCompareDuration(listOfActivities);
//        displayCompareHeart(listOfActivities);
        displayCompareCalories(listOfActivities);



    }

    public static void displayList(ArrayList<Activity> listOfActivities){
        for(Activity a: listOfActivities){
            System.out.println(a.toString());
        }
    }


    public static void displayCompareCalories(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println("\n\n\n *** Sorted by calories burnt *** ");
        Collections.sort(listOfActivities, new CompareCalories());
        displayList(listOfActivities);
    }

    public static void displayCompareHeart(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println("\n\n\n *** Sorted by heart beats *** ");
        Collections.sort(listOfActivities, new CompareHeartBeats());
        displayList(listOfActivities);
    }

    public static void displayCompareDuration(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println("\n\n\n *** Sorted by durations *** ");
        Collections.sort(listOfActivities, new CompareDuration());
        displayList(listOfActivities);
    }


    public static void displayCompareDistance(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println("\n\n\n *** Sorted by distances *** ");
        Collections.sort(listOfActivities, new CompareDistances());
        displayList(listOfActivities);
    }

    public static void displayCompareTypes(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println(" \n\n\n*** Sorted by types *** ");
        Collections.sort(listOfActivities, new CompareTypes());
        displayList(listOfActivities);

    }

    public static void displayCompareDates(ArrayList<Activity> listOfActivities){
        Collections.sort(listOfActivities);
        System.out.println("\n\n\n *** Sorted by dates *** ");
        Collections.sort(listOfActivities, new CompareDates());
        displayList(listOfActivities);
    }



//
//    public static Activity checkIfActivityExists(ArrayList<Activity>listOfActivities){
//        String correctActivity= "";
//        String correctDate= "";
//        int elementIndex = 0;
//        boolean runWhile=true;
//
//        while (runWhile){
//
//            correctActivity= validateType();
//            correctDate = validDate();
//            Activity searchedActivity = new Activity(correctActivity, correctDate, 0, 0, 0);
//            elementIndex= Collections.binarySearch(listOfActivities, searchedActivity);
//
//            if (elementIndex >= 0) {
//                System.out.println("Activity found: " + listOfActivities.get(elementIndex));
//
//                runWhile=false;
//            } else {
//                System.out.println("Activity not found. Please do all the steps again.");
//            }
//        }
//
//        return listOfActivities.get(elementIndex);
//    }
//
//
//
//    public static String validateType(){
//        Scanner validKey = new Scanner(System.in);
//
//        String correctType ="";
//        boolean runWhile = true;
//
//        while(runWhile){
//            correctType ="";
//
//            System.out.println("Enter the type of activity: ");
//            correctType = validKey.nextLine();
//            System.out.println(correctType);
//
//            if(Objects.equals(correctType, "Swimming")||
//                    Objects.equals(correctType, "Running")||
//                    Objects.equals(correctType, "Cycling"))
//            {
//                runWhile=false;
//            }else{
//                System.out.println("Invalid type of activity. Activities can be:\n-Swimming\n-Running\n-Cycling");
//            }
//        }
//        return correctType;
//    }
//
//
//    public static String validDate (){
//        Scanner keyValid = new Scanner(System.in);
//        // MM/DD/YYYY
//        String fullCorrectDate ="";
//        boolean runWhile = true;
//        boolean testBoolean = true;
//
//        while(runWhile){
//            System.out.println("Enter a date (MM/DD/YYYY): ");
//            fullCorrectDate = keyValid.nextLine();
////            runWhile= checkDateType(fullCorrectDate);
//            testBoolean = checkDateType(fullCorrectDate);
//            if(!testBoolean){
////                System.out.println("nice");
//                runWhile=false;
//            }else{
//                System.out.println("Wrong input. Enter a date again. ");
//            }
//        }
//        return fullCorrectDate;
//    }
//
//    public static boolean checkDateType(String date){
//        String slash = "/";
//        boolean checkIfWrong = true;
//        int firstSlash = date.indexOf('/');
//        int secondSlash = date.lastIndexOf('/');
//
//        // MM/DD/YYYY
//
//            if(date.length()==10){  //chech that it's 10 characters
//                if(firstSlash==2 && secondSlash==5){  //check for two slash characters
//                    checkIfWrong = false;
//                }
//            }
//        return checkIfWrong;
//    }

}
