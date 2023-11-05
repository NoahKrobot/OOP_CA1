import java.util.Comparator;

public class CompareHeartBeats  implements Comparator<Activity> {

    @Override
    public int compare(Activity activity1, Activity activity2) {
        // Assuming getDuration_min returns a value that can be compared directly
        return Double.compare(activity1.getAvg_heart_rate(), activity2.getAvg_heart_rate());
    }
}
