import java.util.Comparator;

public class TypeOfActivitiesComparator implements Comparator<Activity>
{
    public int compare(Activity activity1, Activity activity2)
    {
        return activity1.getType_of_activity().compareTo(activity2.getType_of_activity());
    }
}