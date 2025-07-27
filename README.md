# LibraryManagementSystem

- A library management system application.
- Allows users to Add, Delete and Update book records
- Allows for issuing and returning books
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

```How to run/use the project```