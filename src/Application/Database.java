package Application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ArrayList;

public class Database {
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;

    /** Fetches database credentials from the db.properties file */
    public Database() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* From the db.properties credentials file */
        this.dbUrl = properties.getProperty("db.url");
        this.dbUsername = properties.getProperty("db.username");
        this.dbPassword = properties.getProperty("db.password");
    }

    public void createBookTable() {
        String sql = "CREATE TABLE IF NOT EXISTS book (" +
                "bookId SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "author VARCHAR(255)," +
                "numberOfRents INTEGER," +
                "isAvailable BOOLEAN NOT NULL," +
                "libraryName VARCHAR(255) NOT NULL)";

        // Creating the connection to DataBase
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Failed to create table: " + e.getMessage());
            throw new RuntimeException("Database operation failed (Table creation)", e);
        }
    }

    /** Allowing user to add books, which is fed in via library class */
    public void addBook(Book book) {
        String sql = "INSERT INTO book (name, author, numberOfRents, isAvailable, libraryName) VALUES (?, ?, ?, ?, ?)";

        // Feeding Object into SQL
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setString(1, book.getName());
            prepared.setString(2, book.getAuthor());
            prepared.setInt(3, book.getNumberOfRents());
            prepared.setBoolean(4, book.isAvailable());
            prepared.setString(5, book.getLibrary().getName());
            prepared.executeUpdate();
            System.out.println("Book added successfully");

        } catch (SQLException e) {
            System.out.println("There was an error adding the book");
            e.printStackTrace();
        }
    }

    /** Allows user to delete a book from DataBase */
    public void deleteBook(String bookName) {
        String sql = "DELETE FROM book WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setString(1, bookName);
            int rowsDeleted = prepared.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("Book not found");
            }

        } catch (SQLException e) {
            System.out.println("There was an error when deleting the book");
            e.printStackTrace();
        }
    }

    /** Returns a list of books from the database for displaying */
    public ArrayList<String> getBooks() {
        ArrayList<String> books = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            ResultSet result = prepared.executeQuery();

            while (result.next()) {
                int bookId = result.getInt("bookId");
                String name = result.getString("name");
                String author = result.getString("author");
                int numberOfRents = result.getInt("numberOfRents");
                boolean isAvailable = result.getBoolean("isAvailable");
                String libraryName = result.getString("libraryName");

                books.add("Book ID: " + bookId + " Book Name: " + name + " Author: " + author + " Number of Rents: " + numberOfRents
                        + " Is Available? " + isAvailable + " Library Name: " + libraryName);
            }

        } catch (SQLException e) {
            System.out.println("There was an error when fetching the books");
            e.printStackTrace();
        }
        return books;
    }

    /** Allows user to rent the book or return the book, which increments the quantity of takeouts and status of the book */
    public void editBook(String bookName, String callName) {
        if (callName.equalsIgnoreCase("rent")) {
            String sql = "UPDATE book SET numberOfRents = numberOfRents + 1, isAvailable = false WHERE name = ? AND isAvailable = true";

            try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                 PreparedStatement prepared = connection.prepareStatement(sql)) {

                prepared.setString(1, bookName);
                prepared.executeUpdate();
                System.out.println("Book rented successfully");

            } catch (SQLException e) {
                System.out.println("There was an error renting the book");
                e.printStackTrace();
            }

        } else if (callName.equalsIgnoreCase("return")) {
            String sql = "UPDATE book SET isAvailable = true WHERE name = ?";

            try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                 PreparedStatement prepared = connection.prepareStatement(sql)) {

                prepared.setString(1, bookName);
                prepared.executeUpdate();
                System.out.println("Book returned successfully");

            } catch (SQLException e) {
                System.out.println("There was an error returning the book");
                e.printStackTrace();
            }

        } else {
            System.out.println("Invalid call name");
        }
    }

    /** Deletes all books from the database */
    public void deleteAllBooks() {
        String sql = "DELETE FROM book";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            int rowsDeleted = prepared.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Books in library deleted successfully");
            } else {
                System.out.println("Library not found");
            }

        } catch (SQLException e) {
            System.out.println("There was an error when deleting the books");
            e.printStackTrace();
        }
    }
}