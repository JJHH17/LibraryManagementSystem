package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        selectOption(primaryStage);
        primaryStage.setTitle("Library Management System");
        primaryStage.show();
    }

    public void selectOption(Stage primaryStage) {
        Button button = new Button("Hello");
        VBox layout = new VBox(10);
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
