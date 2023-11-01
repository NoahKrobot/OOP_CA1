import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
//Java String trim() Method reference: https://www.scaler.com/topics/trim-in-java/

public class CSV_reader {

    public static ArrayList<Activity> fileReader(String filename, ArrayList<Activity> listOfActivities) throws IOException
    {
        File fileSource = new File(filename);
        Scanner writer = new Scanner(fileSource);
        String fileLine;
        String emptyString ="";
        boolean headersRead = false;
        int lineCounter = 0;

        while(writer.hasNextLine()){
            fileLine = writer.nextLine();
            if(lineCounter>0){
//                System.out.println(fileLine);
                if(fileLine.compareTo(emptyString)!=0){
                    Activity singleActivity = splitLine(fileLine, fileLine);
                    listOfActivities.add(singleActivity);
                }
//                System.out.println(fileLine);
            }
            lineCounter++;
        }

        return listOfActivities;
    }








    private static Activity splitLine(String singleLine, String lineTesting) {
        String typeofActivity;
        String date;
        double durationMin;
        double distanceKilo;
        int averageBpm;

        //type ******************************
        int comma1 = singleLine.indexOf(',');
        typeofActivity = singleLine.substring(0, comma1).trim();
//        System.out.println(typeofActivity);

        singleLine = singleLine.substring(comma1 + 1);

        //date ******************************

        int comma2 = singleLine.indexOf(',');
        date = singleLine.substring(0, comma2).trim();
//        System.out.println(date);

        singleLine = singleLine.substring(comma2 + 1);

        //duration ******************************

        int comma3 = singleLine.indexOf(',');
        durationMin = Integer.parseInt(singleLine.substring(0, comma3).trim());
//        System.out.println(durationMin);

        singleLine = singleLine.substring(comma3 + 1);

        //distance ******************************

        int comma4 = singleLine.indexOf(',');
        distanceKilo = Double.parseDouble(singleLine.substring(0, comma4).trim());
//        System.out.println(distanceKilo);
        singleLine = singleLine.substring(comma4 + 1);

        //avg ******************************
//        int lastComma = lineTesting.lastIndexOf(',');
//        System.out.println(lineTesting.substring(lastComma+1).trim());
//        System.out.println(singleLine);
        //singleLine example here at the end: " 91" => trim will just remove space
        averageBpm = Integer.parseInt(singleLine.trim());

        return new Activity(typeofActivity, date, durationMin, distanceKilo, averageBpm);

    }


}