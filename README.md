# LibraryManagementSystem

- A library management system application.
- Allows users to Add and delete books.
- Allows for renting and returning books
- Displays available books.

The project uses JavaFX for a frontend, and Postgresql for a database.

The Jira board used for managing this project can be found on: https://jameshatfield.atlassian.net/jira/core/projects/LMS/board?groupBy=status&atlOrigin=eyJpIjoiZDg4YzE4ZmM5ZWYyNGZhOGE4YzZmNjc3YWVmNGI4MmYiLCJwIjoiaiJ9

```Installation Steps```

This Application uses Postgresql for a database and JavaFX for a frontend (hosted via a local database).
As this is the case, both need to be installed and added to the project in order to be used

```Postgresql```

1. Install Postgresql from: https://www.postgresql.org/
2. Install the Postgresql JDBC from: https://jdbc.postgresql.org/
- From the JDBC installer, you'll receive a number of .jar files which are needed.
3. If you're using Intellij IDEA:
- Select "File > Project Structure > Modules > Dependencies"
- Select "+" > "JARs or Directories"
- Add the relevant JAR file installed from the JDBC driver installation

```JavaFX (frontend)```

1. Install JavaFX from: https://gluonhq.com/products/javafx/ (Install the SDK folder)
2. Head over to "File > Project Structure > Project Settings > Libraries > + > Add the JAR files found in the Lib folder"
3. Set the VM options - "Run > Edit Configurations > Select Main class under Application > Enter the following in VM options":
```--module-path "/path/to/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml```

```How to connect to the database```

1. Create a db.properties file in the root of the project.
2. Use the db.properties.template file, which contains a template on how the credentials need to be laid out.
3. Create a Postgresql database to run connections.
4. The database class will then pick up these credentials via the dbURL, dbUsername and dbPassword variables

```How to run/use the project```

Once Postgres and JavaFX are added, you can run the project via the Main class.

```Launched Project```
<img width="708" height="584" alt="image" src="https://github.com/user-attachments/assets/4e33fc67-24b1-45fa-abce-8d73fcfd051f" />

From here, you're able to 
- Add a new book.
- Rent an available book.
- Delete a given book.
- Return a rented book.
- Delete all books.
- Get a list of all books.
