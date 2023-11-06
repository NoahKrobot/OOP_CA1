import java.util.Comparator;

public class CompareCalories implements Comparator<Activity> {
    @Override
    public int compare(Activity activity1, Activity activity2) {

        if (activity1.getCaloriesBurnt() < activity2.getCaloriesBurnt()) {
            return -1;
        } else if (activity1.getCaloriesBurnt() == activity2.getCaloriesBurnt()) {
            return 0;
        } else {
            return 1;
        }
    }
}
