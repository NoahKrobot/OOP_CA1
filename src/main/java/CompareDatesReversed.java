import java.util.Comparator;

public class CompareDatesReversed  implements Comparator<Activity> {

    @Override
    public int compare(Activity activity1, Activity activity2) {
        return activity2.getDate().compareTo(activity1.getDate());
    }
}
