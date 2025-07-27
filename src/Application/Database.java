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
        this.dbUrl = properties.getProperty("dbUrl");
        this.dbUsername = properties.getProperty("dbUsername");
        this.dbPassword = properties.getProperty("dbPassword");
    }
}