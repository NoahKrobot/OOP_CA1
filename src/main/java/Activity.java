import java.util.Objects;

public class Activity extends AbstractActivity implements Comparable<Activity>{


    public static enum INTENSITY{VERY_LIGHT, LIGHT, MODERATE, VIGOROUS, VERY_VIGOROUS}
    private INTENSITY Intensity;

    public Activity(String type_of_activity, String date, double duration_min, double distance_km, double avg_heart_rate) {
        super(type_of_activity, date, duration_min, distance_km, avg_heart_rate);
        setIntensity();
    }


    //CALORIES BURNT ***************************************************************************************************

    public double calculateCalories(double intensityValue, double durationInMinutes){
        double caloriesCalculated =0;
        caloriesCalculated = intensityValue * durationInMinutes;
        return caloriesCalculated;
    }

    public double getCaloriesBurnt(){
        //calories burnt = Intensity Value * duration in minutes
          double finalCaloriesBurnt = 0;

          //swimming
          if(Objects.equals(getType_of_activity(), "Swimming")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(5, getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(6.3 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(7.6 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(8.9 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(10.2 , getDuration_min());
              }
          }else if(Objects.equals(getType_of_activity(), "Running")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(4.1, getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(7.2 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(10 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(15.4 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(20.8 , getDuration_min());
              }
          }else if(Objects.equals(getType_of_activity(), "Cycling")){
              if(Objects.equals(Intensity,INTENSITY.VERY_LIGHT)){
                  finalCaloriesBurnt = calculateCalories(2, getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.LIGHT)){
                  finalCaloriesBurnt = calculateCalories(5 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.MODERATE)){
                  finalCaloriesBurnt = calculateCalories(7 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(13 , getDuration_min());
              }else if(Objects.equals(Intensity,INTENSITY.VERY_VIGOROUS)){
                  finalCaloriesBurnt = calculateCalories(15 , getDuration_min());
              }
          }
          return finalCaloriesBurnt;
      }



    public void setIntensity()
    {
        double kmPerHour= (getDuration_min()/60)*getDistance_km();
        if(Objects.equals(getType_of_activity(), "Swimming")){
            if(kmPerHour<=0.5){
                Intensity = Activity.INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=1.25){
                Intensity = Activity.INTENSITY.LIGHT;
            }else if(kmPerHour<=2){
                Intensity = Activity.INTENSITY.MODERATE;
            }else if(kmPerHour<=2.75){
                Intensity = Activity.INTENSITY.VIGOROUS;
            }else{
                Intensity = Activity.INTENSITY.VERY_VIGOROUS;
            }
        }else if(Objects.equals(getType_of_activity(), "Running")){
            if(kmPerHour<=4){
                Intensity = Activity.INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=8){
                Intensity = Activity.INTENSITY.LIGHT;
            }else if(kmPerHour<=12){
                Intensity = Activity.INTENSITY.MODERATE;
            }else if(kmPerHour<=16){
                Intensity = Activity.INTENSITY.VIGOROUS;
            }else{
                Intensity = Activity.INTENSITY.VERY_VIGOROUS;
            }
        }else  if(Objects.equals(getType_of_activity(), "Cycling")){
            if(kmPerHour<=8){
                Intensity = Activity.INTENSITY.VERY_LIGHT;
            }else if(kmPerHour<=16){
                Intensity = Activity.INTENSITY.LIGHT;
            }else if(kmPerHour<=25){
                Intensity = Activity.INTENSITY.MODERATE;
            }else if(kmPerHour<=33){
                Intensity = Activity.INTENSITY.VIGOROUS;
            }else{
                Intensity = Activity.INTENSITY.VERY_VIGOROUS;
            }
        }
    }


    public Activity.INTENSITY getIntensity() {return Intensity;}




    @Override
    public int compareTo(Activity other) {

        //type > Date > duration > distance > BPM > Intensity > Calories

        int typeComparison = this.getType_of_activity().compareTo(other.getType_of_activity());
        if(typeComparison !=0){
            return typeComparison;
        }
        int durationComparison = Double.compare(this.getDuration_min(), other.getDuration_min());
        if (durationComparison != 0) {
            return durationComparison;
        }

        int dateComparison = this.getDate().compareTo(other.getDate());
        if (dateComparison != 0) {
            return dateComparison;
        }



        int distanceComparison = Double.compare(this.getDistance_km(), other.getDistance_km());
        if (distanceComparison != 0) {
            return distanceComparison;
        }

        int heartComparison = Double.compare(this.getAvg_heart_rate(), other.getAvg_heart_rate());
        if (heartComparison != 0) {
            return heartComparison;
        }

        int intensityComparison = this.getIntensity().compareTo(other.getIntensity());
        if (intensityComparison != 0) {
            return intensityComparison;
        }

        int caloriesComparison = Double.compare(this.getCaloriesBurnt(), other.getCaloriesBurnt());

        return heartComparison;
    }

}





