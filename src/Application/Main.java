package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static Library library = new Library("Main Library");

    @Override
    public void start(Stage primaryStage) {
        selectOption(primaryStage);
        primaryStage.setTitle("Library Management System");
        primaryStage.show();
    }

    /** Page designed to allow the user to select what they wish to do */
    public static void selectOption(Stage primaryStage) {
        Label title = new Label("Library Management System");
        VBox layout = new VBox(10);

        // App navigation buttons
        Button addBook = new Button("Add a Book");
        Button rentBook = new Button("Rent a Book");
        Button returnBook = new Button("Return a Book");
        Button deleteBook = new Button("Delete a Book");
        Button deleteAllBooks = new Button("Delete all books");
        Button getBooks = new Button("Get all books");
        layout.getChildren().addAll(title, addBook, rentBook, deleteBook, returnBook, deleteAllBooks, getBooks);

        // Allowing user to click to add a new book
        addBook.setOnAction(e -> addBook(primaryStage));

        // Allowing user to print all books
        getBooks.setOnAction(e -> printAllBooks(primaryStage));

        deleteAllBooks.setOnAction(e -> deleteAllBooks(primaryStage));

        deleteBook.setOnAction(e -> deleteBook(primaryStage));

        rentBook.setOnAction(e -> rentBook(primaryStage));

        // Adds and creates interface
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    /** Allows user to add a book via frontend*/
    public static void addBook(Stage primaryStage) {
        Label title = new Label("Add a Book");
        VBox layout = new VBox(10);

        Label libraryNameLabel = new Label("Library Name: ");
        TextField libraryNameField = new TextField();
        Label bookNameLabel = new Label("Book Name: ");
        TextField bookNameField = new TextField();
        Label authorLabel = new Label("Author: ");
        TextField authorField = new TextField();

        // Allowing user to enter up to 100 rents for a book via a ranged list
        Label numberOfRentsLabel = new Label("Number of Rents: ");
        List<Integer> rentOptions = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            rentOptions.add(i);
        }
        ComboBox<Integer> numberOfRentsField = new ComboBox<>();
        numberOfRentsField.getItems().addAll(rentOptions);
        numberOfRentsField.setValue(0);

        // Allowing user to select whether book is available or not
        Label isAvailableLabel = new Label("Is the book Available? ");
        ComboBox<String> isAvailableField = new ComboBox<>();
        isAvailableField.getItems().addAll("true", "false");
        isAvailableField.setValue("true"); // Default status value

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            Library library = new Library(libraryNameField.getText());
            Book book = new Book(bookNameField.getText(), authorField.getText(), numberOfRentsField.getValue(),
                    Boolean.getBoolean(isAvailableField.getValue()), library);
            library.addBook(book);
            // Navigating back to original page
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        // Allows the user to cancel and go back to the home page
        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        layout.getChildren().addAll(title, libraryNameLabel, libraryNameField, bookNameLabel, bookNameField, authorLabel,
                authorField, numberOfRentsLabel, numberOfRentsField, isAvailableLabel, isAvailableField, submit, cancel);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    /** Method allowing user to print all books when called */
    public static void printAllBooks(Stage primaryStage) {
        Label title = new Label("Print All Books");
        VBox layout = new VBox(10);
        // Used to store items from the database
        ArrayList<String> books = library.getBooks();

        Label booksLabel = new Label("Books: ");
        Label printBooks = new Label();
        printBooks.setText(String.join("\n", books));

        Button back = new Button("Back");
        back.setOnAction(e -> {
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        layout.getChildren().addAll(title, booksLabel, printBooks, back);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    /** Method used to delete all books on the database */
    public static void deleteAllBooks(Stage primaryStage) {
        Label title = new Label("Delete All Books");
        VBox layout = new VBox(10);

        Label warning = new Label("WARNING: This will delete all books from the database!");
        Button confirm = new Button("Confirm");
        confirm.setOnAction(e -> {
            library.deleteAllBooks();
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        layout.getChildren().addAll(title, warning, confirm, cancel);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    /** Method to delete a given book from the database (Duplicates will all be deleted) */
    public static void deleteBook(Stage primaryStage) {
        Label title = new Label("Delete a Book");
        VBox layout = new VBox(10);

        Label bookNamelabel = new Label("Book Name: ");
        TextField bookNameField = new TextField();

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            library.deleteBook(bookNameField.getText());
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            layout.getChildren().clear();
        });

        layout.getChildren().addAll(title, bookNamelabel, bookNameField, submit, cancel);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    /** Method to rent a given book */
    public static void rentBook(Stage primaryStage) {
        Label title = new Label("Rent a Book");
        VBox layout = new VBox(10);

        Label bookNamelabel = new Label("Book Name: ");
        TextField bookNameField = new TextField();

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            library.editBook(bookNameField.getText(), "rent");
            layout.getChildren().clear();
            selectOption(primaryStage);
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            layout.getChildren().clear();
        });

        layout.getChildren().addAll(title, bookNamelabel, bookNameField, submit, cancel);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
