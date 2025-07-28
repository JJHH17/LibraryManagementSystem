package Application;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    boolean active = true;

    public void start() {
        while (active) {
        System.out.println("Welcome to the library management system!");
        System.out.println("Please select an option:");
        System.out.println("1. Add a Book");
        System.out.println("2. Get all books");
        System.out.println("3. Delete all books");
        System.out.println("4. Delete a a specific book");
        System.out.println("5. Exit");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                System.out.println("\nPlease enter the name of the library:");
                String libraryName = scanner.nextLine();
                Library library = new Library(libraryName);
                System.out.println("Please enter the name of the book:");
                String bookName = scanner.nextLine();
                System.out.println("Please enter the author of the book:");
                String author = scanner.nextLine();
                library.addBook(new Book(bookName, author, 0, true, library));
                System.out.println("Book added successfully!");
                break;

            case 2:
                Library library1 = new Library("Library 1");
                library1.getBooks();
                break;

            case 3:
                System.out.println("Please enter the name of the library:");
                String libraryName1 = scanner.nextLine();
                Library library2 = new Library(libraryName1);
                library2.deleteAllBooks();
                break;

            case 4:
                System.out.println("Please enter the name of the book you wish to delete:");
                Library library3 = new Library("Library 1");
                String bookName1 = scanner.nextLine();
                library3.deleteBook(bookName1);
                break;

            case 5:
                active = false;
                break;
            }
        }
        scanner.close();
    }
}
