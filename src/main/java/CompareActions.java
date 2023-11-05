public class CompareActions {



    public int compareDates(Activity activity1, Activity activity2)
    {
        return activity1.getDate().compareTo(activity2.getDate());
    }

    public int compareDuration(Activity activity1, Activity activity2)
    {
        //this will be in seconds
        return ((int)(activity2.getDuration_min() - activity1.getDuration_min())*60);
    }

    public int compareDistances(Activity activity1, Activity activity2)
    {
        //this will be in meters
        return ((int)(activity2.getDistance_km() - activity1.getDistance_km()) *1000);
    }

    public int compareHeartRate(Activity activity1, Activity activity2)
    {
        return ((int)(activity2.getAvg_heart_rate() - activity1.getAvg_heart_rate()));
    }


}
