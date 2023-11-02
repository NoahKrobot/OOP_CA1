//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class ActivityTrackerUI extends Application {
//
//    public static void main(String[] args) {
//
//        start(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Activity Tracker");
//
//        // Create a button to add a new activity
//        Button addButton = new Button("Add Activity");
//
//        // Add an action when the button is clicked
//        addButton.setOnAction(e -> {
//            // You can implement code here to add a new activity
//            // For simplicity, we'll just print a message for now
//            System.out.println("New activity added!");
//        });
//
//        // Create a layout to organize the button
//        VBox layout = new VBox(10); // 10 pixels spacing
//        layout.getChildren().add(addButton);
//
//        // Create a scene and set it in the stage
//        Scene scene = new Scene(layout, 300, 200); // Width and height of the window
//        primaryStage.setScene(scene);
//
//        // Show the user interface
//        primaryStage.show();
//    }
//}
