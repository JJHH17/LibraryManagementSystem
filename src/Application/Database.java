package Application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ArrayList;

public class Database {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    /** Fetches database credentials from the db.properties file */
    public Database() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /** From the db.properties credentials file */
        this.dbUrl = properties.getProperty("db.url");
        this.dbUsername = properties.getProperty("db.username");
        this.dbPassword = properties.getProperty("db.password");
    }

    public void createBookTable() {
        String sql = "CREATE TABLE IF NOT EXISTS book (" +
                "bookId SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL UNIQUE," +
                "author VARCHAR(255)," +
                "numberOfRents INTEGER," +
                "isAvailable BOOLEAN NOT NULL," +
                "libraryName VARCHAR(255) NOT NULL)";

        // Creating the connection to database
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Failed to create table: " + e.getMessage());
            throw new RuntimeException("Database operation failed (Table creation)", e);
        }
    }
}