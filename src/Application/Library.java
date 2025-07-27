package Application;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Library {
    private String name;
    private Database database;;

    public Library(String name) {
        this.name = name;
        this.database = new Database();
        this.database.createBookTable();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        // To be added with database class
        database.addBook(book);
    }

    public void getBooks() {
        return;
    }
}
