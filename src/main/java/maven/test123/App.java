package maven.test123;

import java.sql.*;
import java.util.*;

public class App {
	public static void main(String[] args) {
		try {
			// Create a DatabaseConnector instance
			DatabaseConnector dbConnector = new DatabaseConnector("jdbc:mysql://localhost/javadb", "root", "hejsan123");
			Connection conn = dbConnector.getConnection();

			if (conn != null) {
				System.out.println("Connected to the database!");
				try {
					// Create a Scanner object for keyboard input.
					Scanner console = new Scanner(System.in);
					int choice;
					do {
						// Ask the user to enter a choice.
						System.out.print(
								"Enter choice (0: exit, 1: retrieve accounts, 2: search books by author, 3: insert account, 4: retrieve books");
						choice = console.nextInt();

						// Determine the corresponding action
						switch (choice) {
							case 1:
								// Retrieve accounts from the database and print them
								List<Account> accounts = AccountRepository.retrieveAccounts(conn);
								ConsoleUI.printAccounts(accounts);
								break;
							case 2:
								// nonfunctional
								// Search books by author
								console.nextLine(); // Consume the newline character
								System.out.print("Enter author: ");
								String author = console.nextLine();
								DbMethods.SearchByAuthor(conn, author);
								break;
							case 3:
								// Insert a new account into the database
								Account newAccount = AccountServices.createAccount(console);
								AccountRepository.insertAccount(conn, newAccount);
								break;
							case 4:
								// Retrieve list of books from the database and print them
								List<Book> books = BookRepository.retrieveBook(conn);
								ConsoleUI.printBooks(books);
								break;
							case 5:
								books = BookRepository.retrieveBook(conn);
								ConsoleUI.printBooks(books);

							default:
								System.out.println("Invalid choice");
						}
					} while (choice != 0);
				} finally {
					dbConnector.close(); // Close the connection
				}
			} else {
				System.out.println("Failed to connect to the database.");
			}
		} catch (SQLException e) {
			System.out.println("Connection failed! Check output console");
			e.printStackTrace();
		}
	}
}
