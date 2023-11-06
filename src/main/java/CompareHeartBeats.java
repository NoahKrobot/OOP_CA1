import java.util.Comparator;

public class CompareHeartBeats  implements Comparator<Activity> {

    @Override
    public int compare(Activity activity1, Activity activity2) {
        if (activity1.getAvg_heart_rate() < activity2.getAvg_heart_rate()) {
            return -1;	// a negative value
        } else if (activity1.getAvg_heart_rate() == activity2.getAvg_heart_rate()) {
            return 0;
        } else {
            return 1;
        }
    }
}
