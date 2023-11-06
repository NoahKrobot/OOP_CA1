import java.util.Objects;

public abstract class AbstractActivity {

    private String type_of_activity;
    private String date; //MM/DD/YYYY
    private double duration_min;
    private double distance_km;
    private double avg_heart_rate;


    public static enum INTENSITY{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS}
    private Activity.INTENSITY Intensity;

    public AbstractActivity(String type_of_activity, String date, double duration_min, double distance_km, double avg_heart_rate) {
        this.type_of_activity = type_of_activity;
        this.duration_min = duration_min;
        this.date = date;
        this.distance_km = distance_km;
        this.avg_heart_rate = avg_heart_rate;
    }




    public String getType_of_activity() {return type_of_activity;}

    public double getDuration_min() {return duration_min;}

    public String getDate() {return date;}

    public double getDistance_km() {return distance_km;}

    public double getAvg_heart_rate() {return avg_heart_rate;}

    public void setType_of_activity(String type_of_activity) {this.type_of_activity = type_of_activity;}

    public void setDuration_min(double duration_min) {this.duration_min = duration_min;}

    public void setDate(String date) {this.date = date;}

    public void setDistance_km(double distance_km) {this.distance_km = distance_km;}

    public void setAvg_heart_rate(double avg_heart_rate) {this.avg_heart_rate = avg_heart_rate;}






    @Override
    public String toString() {
        return "Activity{" +
                "type_of_activity='" + type_of_activity + '\'' +
                ", date='" + date + '\'' +
                ", duration_min=" + duration_min +
                ", distance_km=" + distance_km +
                ", avg_heart_rate=" + avg_heart_rate +
                '}';
    }


}
