package Application;

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
        database.addBook(book);
    }

    public void getBooks() {
        return;
    }

    public void deleteBook(String bookName) {
        database.deleteBook(bookName);
    }
}
