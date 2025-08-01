package Application;

import java.util.ArrayList;

public class Library {
    private Database database;;
    private String name;

    public Library(String name) {
        this.name = name;
        this.database = new Database();
        this.database.createBookTable();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        database.addBook(book);
    }

    public ArrayList<String> getBooks() {
        return database.getBooks();
    }

    public void deleteBook(String bookName) {
        database.deleteBook(bookName);
    }

    public void deleteAllBooks() {
        database.deleteAllBooks();
    }

    /** Used for either returning or renting a book, from the database class */
    public void editBook(String bookName, String callName) {
        database.editBook(bookName, callName);
    }
}
