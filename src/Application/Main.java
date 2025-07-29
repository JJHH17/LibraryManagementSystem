package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

    /** Page designed to allow the user to select what they wish to do */
    public void selectOption(Stage primaryStage) {
        Label title = new Label("Library Management System");
        VBox layout = new VBox(10);


        // App navigation buttons
        Button addBook = new Button("Add a Book");
        Button editBook = new Button("Edit a Book");
        Button deleteBook = new Button("Delete a Book");
        Button deleteAllBooks = new Button("Delete all books");
        Button getBooks = new Button("Get all books");


        layout.getChildren().addAll(title, addBook, editBook, deleteBook, deleteAllBooks, getBooks);

        // Adds and creates interface
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
