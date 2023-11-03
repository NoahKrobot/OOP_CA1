import java.util.Comparator;

public class DistanceComparator  implements Comparator<Activity> {
    public int compare(Activity activity1, Activity activity2)
    {
        return ((int)(activity2.getDistance_km() - activity1.getDistance_km()) *1000);
    }
}
