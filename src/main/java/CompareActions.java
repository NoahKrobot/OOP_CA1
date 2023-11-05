public class CompareActions {
    public int compareDates(Activity activity1, Activity activity2)
    {
        return activity1.getDate().compareTo(activity2.getDate());
    }

    public int compareDistances(Activity activity1, Activity activity2)
    {
        return ((int)(activity2.getDistance_km() - activity1.getDistance_km()) *1000);
    }


    public int compareActivities(Activity activity1, Activity activity2)
    {
        return activity1.getType_of_activity().compareTo(activity2.getType_of_activity());
    }


}
