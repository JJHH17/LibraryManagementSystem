package Application;

public class Book {
    private String name;
    private String author;
    private int numberOfRents;
    private boolean isAvailable;
    private Library library;

    public Book(String name, String author, int numberOfRents, boolean isAvailable, Library library) {
        this.name = name;
        this.author = author;
        this.numberOfRents = numberOfRents;
        this.isAvailable = isAvailable;
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfRents() {
        return numberOfRents;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Library getLibrary() {
        return library;
    }
}
