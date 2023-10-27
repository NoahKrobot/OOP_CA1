public class Activity {

    private String type_of_activity;
    private double duration;
    private String date;
    private double avg_heart_rate;
    private double energy_spent;
    private double calories_burnt;
    public static enum INTENSITY{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS}
    private INTENSITY Intensity;

    public Activity(String type_of_activity, double duration, String date, double avg_heart_rate, double energy_spent, double calories_burnt) {
        this.type_of_activity = type_of_activity;
        this.duration = duration;
        this.date = date;
        this.avg_heart_rate = avg_heart_rate;
        this.energy_spent = energy_spent;
        this.calories_burnt = calories_burnt;
    }


    public String getType_of_activity() {return type_of_activity;}

    public void setType_of_activity(String type_of_activity) {this.type_of_activity = type_of_activity;}

    public double getDuration() {return duration;}

    public void setDuration(double duration) {this.duration = duration;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public double getAvg_heart_rate() {return avg_heart_rate;}

    public void setAvg_heart_rate(double avg_heart_rate) {this.avg_heart_rate = avg_heart_rate;}

    public double getEnergy_spent() {return energy_spent;}

    public void setEnergy_spent(double energy_spent) {this.energy_spent = energy_spent;}

    public double getCalories_burnt() {return calories_burnt;}

    public void setCalories_burnt(double calories_burnt) {this.calories_burnt = calories_burnt;}


    @Override
    public String toString() {
        return "Activity{" +
                "type_of_activity='" + type_of_activity + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", avg_heart_rate=" + avg_heart_rate +
                ", energy_spent=" + energy_spent +
                ", calories_burnt=" + calories_burnt +
                '}';
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
