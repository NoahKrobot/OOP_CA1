import java.util.Scanner;

public class ExampleValidDate {
    public static void learnHowToTypeValidDate() {
        Activity runningExample = new Activity("Activity with the date", "", 12, 1.5, 90){
            @Override
            public void setDate(String date) {
                //1. comment:  display this messages to users
                System.out.println("To set a proper date, we have to input it in the 'MM/DD/YYYY' form.");
                System.out.println("Try it yourself.");

                //2. comment:  let users input the date with a textbox
                System.out.println(validDate());
            }
        };
    }



    public static String validDate (){
        Scanner keyValid = new Scanner(System.in);
        // MM/DD/YYYY
        String fullCorrectDate ="";
        boolean runWhile = true;
        boolean testBoolean = true;

        while(runWhile){
            System.out.println("Enter a date (MM/DD/YYYY): ");
            fullCorrectDate = keyValid.nextLine();
//            runWhile= checkDateType(fullCorrectDate);
            testBoolean = checkDateType(fullCorrectDate);
            if(!testBoolean){
//                System.out.println("nice");
                runWhile=false;
            }else{
                System.out.println("Wrong input. Enter a date again. ");
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

        if(date.length()==10){  //chech that it's 10 characters
            if(firstSlash==2 && secondSlash==5){  //check for two slash characters
                checkIfWrong = false;
            }
        }
        return checkIfWrong;
    }


}
