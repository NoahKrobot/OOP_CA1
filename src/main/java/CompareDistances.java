import java.util.Comparator;

public class CompareDistances  implements Comparator<Activity> {
    @Override
    public int compare(Activity activity1, Activity activity2) {

        if (activity1.getDistance_km() < activity2.getDistance_km()) {
            return -1;	// a negative value
        } else if (activity1.getDistance_km() == activity2.getDistance_km()) {
            return 0;
        } else {
            return 1;
        }
    }
}
