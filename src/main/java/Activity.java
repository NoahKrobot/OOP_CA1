public class Activity {

    private String type_of_activity;
    private double duration;
    private String date;
    private double avg_heart_rate;
    private double energy_spent;
    private double calories_burnt;

    public Activity(String type_of_activity, double duration, String date, double avg_heart_rate, double energy_spent, double calories_burnt) {
        this.type_of_activity = type_of_activity;
        this.duration = duration;
        this.date = date;
        this.avg_heart_rate = avg_heart_rate;
        this.energy_spent = energy_spent;
        this.calories_burnt = calories_burnt;
    }


    public Activity() {
        this.type_of_activity = "";
        this.duration = 0;
        this.date = "";
        this.avg_heart_rate = 0;
        this.energy_spent = 0;
        this.calories_burnt = 0;
    }


}
