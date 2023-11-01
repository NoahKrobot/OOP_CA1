import java.util.Objects;

public class Activity {
    //test Noah
    private String type_of_activity;
    private double duration_min;
    private String date;
    private double distance_km;
    private double avg_heart_rate;



    public static enum INTENSITY{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS}
    private INTENSITY Intensity;

    public Activity(String type_of_activity, String date, double duration_min, double distance_km, double avg_heart_rate) {
        this.type_of_activity = type_of_activity;
        this.duration_min = duration_min;
        this.date = date;
        this.distance_km = distance_km;
        this.avg_heart_rate = avg_heart_rate;
        setIntensity();
    }


    //INTENSITY ********************************************************************************************************
    public void setIntensity()
    {
        double kmPerHour= (duration_min/60)*distance_km;
        if(Objects.equals(type_of_activity, "Swimming")){
             if(kmPerHour<=0.5){
                Intensity = INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=1.25){
                Intensity = INTENSITY.LIGHT;
            }else if(kmPerHour<=2){
                Intensity = INTENSITY.MODERATE;
            }else if(kmPerHour<=2.75){
                Intensity = INTENSITY.VIGOROUS;
            }else{
                Intensity = INTENSITY.VERY_VIGOROUS;
            }
        }else if(Objects.equals(type_of_activity, "Running")){
            if(kmPerHour<=4){
                Intensity = INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=8){
                Intensity = INTENSITY.LIGHT;
            }else if(kmPerHour<=12){
                Intensity = INTENSITY.MODERATE;
            }else if(kmPerHour<=16){
                Intensity = INTENSITY.VIGOROUS;
            }else{
                Intensity = INTENSITY.VERY_VIGOROUS;
            }
        }else  if(Objects.equals(type_of_activity, "Cycling")){
            if(kmPerHour<=8){
                Intensity = INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=16){
                Intensity = INTENSITY.LIGHT;
            }else if(kmPerHour<=25){
                Intensity = INTENSITY.MODERATE;
            }else if(kmPerHour<=33){
                Intensity = INTENSITY.VIGOROUS;
            }else{
                Intensity = INTENSITY.VERY_VIGOROUS;
            }
        }
    }


    //CALORIES BURNT ***************************************************************************************************

    public double calculateCalories(double intensityValue, double durationInMinutes){
        double caloriesCalculated = intensityValue * durationInMinutes;
        return caloriesCalculated;
    }
    public double getCaloriesBurnt(){
        //calories burnt = Intensity Value * duration in minutes
          double finalCaloriesBurnt = 0;

          //swimming
          if(Objects.equals(type_of_activity, "Swimming")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(5, duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(6.3 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(7.6 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(8.9 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(10.2 , duration_min);
              }
          }else if(Objects.equals(type_of_activity, "Running")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(4.1, duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(7.2 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(10 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(15.4 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(20.8 , duration_min);
              }
          }else if(Objects.equals(type_of_activity, "Cycling")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(2, duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(5 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(7 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(13 , duration_min);
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(15 , duration_min);
              }
          }



          return 1;
      }






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
