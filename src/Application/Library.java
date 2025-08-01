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

    public void increaseBookRent(String bookName) {
        database.increaseBookRent(bookName);
    }
}
