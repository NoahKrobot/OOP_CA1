public class Activity {

    private String type_of_activity;
    private double duration_min;
    private String date;
    private double distance_km;
    private double avg_heart_rate;
    public static enum INTENSITY{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS}
    private INTENSITY Intensity;

    public String getType_of_activity() {return type_of_activity;}

    public double getDuration_min() {return duration_min;}

    public String getDate() {return date;}

    public double getDistance_km() {return distance_km;}

    public double getAvg_heart_rate() {return avg_heart_rate;}

    public INTENSITY getIntensity() {return Intensity;}

    public void setType_of_activity(String type_of_activity) {this.type_of_activity = type_of_activity;}

    public void setDuration_min(double duration_min) {this.duration_min = duration_min;}

    public void setDate(String date) {this.date = date;}

    public void setDistance_km(double distance_km) {this.distance_km = distance_km;}

    public void setAvg_heart_rate(double avg_heart_rate) {this.avg_heart_rate = avg_heart_rate;}

    public double getCaloriesBurned()
    {
        return 0;
    }



    @Override
    public String toString() {
        return "Activity{" +
                "type_of_activity='" + type_of_activity + '\'' +
                ", duration_min=" + duration_min +
                ", date='" + date + '\'' +
                ", distance_km=" + distance_km +
                ", avg_heart_rate=" + avg_heart_rate +
                '}';
    }
}
