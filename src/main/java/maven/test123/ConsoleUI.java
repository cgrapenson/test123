package maven.test123;

import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;


public class ConsoleUI {
     public static void printAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getAccountId());
            System.out.println("First Name: " + account.getFirstName());
            System.out.println("Last Name: " + account.getLastName());
            System.out.println("Department: " + account.getDepartment());
            System.out.println("Email: " + account.getEmail());
            System.out.println("Password: " + account.getPassword());
            System.out.println("------------------------");
        }
    }
    // class that prints all the books
    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("------------------------");
            System.out.println("Publisher: " + book.getpublisher());
        }
    }

    
public static Pair<String, String> promptForLogin() {
    Scanner console = new Scanner(System.in);

    System.out.print("Enter your email: ");
    String email = console.nextLine();

    System.out.print("Enter your password: ");
    String password = console.nextLine();

    return new Pair<>(email, password);

}
}
