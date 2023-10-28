public class MainApp {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Activity act1 = new Activity("Swimming", 60,"13",1,13);
        act1.setIntensity();
        System.out.println(act1.getIntensity());
        act1.getCaloriesBurnt();
    }
}