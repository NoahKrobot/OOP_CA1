// running description reference: https://en.wikipedia.org/wiki/Running
// cycling description reference: https://en.wikipedia.org/wiki/Cycling
// swimming description reference:


public class ExampleTypeActivity {

    public static void getRunningDescription() {
      Activity runningExample = new Activity("Running Activity", "01/01/2011", 12, 1.5, 90){
          @Override
          public String toString() {
              return "Running is a method of terrestrial locomotion allowing humans and other animals to move rapidly on foot.";
          }
      };
    }

    public static void getCyclingDescription() {
        Activity runningExample = new Activity("Cycling Activity", "01/01/2011", 12, 1.5, 90){
            @Override
            public String toString() {
                return "Cycling, also known as bicycling or biking, is the activity of riding a bicycle or other type of cycle.";
            }
        };
    }

    public static void getSwimmingDescription() {
        Activity runningExample = new Activity("Swimming Activity", "01/01/2011", 12, 1.5, 90){
            @Override
            public String toString() {
                return "Swimming is the self-propulsion of a person through water, or other liquid, usually for recreation, sport, exercise, or survival.";
            }
        };
    }

}
