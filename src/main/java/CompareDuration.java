import java.util.Comparator;

public class CompareDuration implements Comparator<Activity> {

    @Override
    public int compare(Activity activity1, Activity activity2) {

        if (activity1.getDuration_min() < activity2.getDuration_min()) {
            return -1;
        } else if (activity1.getDuration_min() == activity2.getDuration_min()) {
            return 0;
        } else {
            return 1;
        }
    }
}
