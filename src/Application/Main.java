package Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean active = true;

        while (active) {
            System.out.println("Welcome to the library management system!");
            System.out.println("Please select an option:");
            System.out.println("1. Create a library");
            System.out.println("2. Exit");

            try {
                String input = scanner.nextLine();
                int option;

                try {
                    option = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid option");
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.println("Please enter the name of the library:");
                        String libraryName = scanner.next();
                        Library library = new Library(libraryName);
                        System.out.println("Library created successfully!");
                        continue;

                    case 2:
                        active = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
                scanner.nextLine(); // clears scanner buffer
            }
        }
        scanner.close();
    }
}
