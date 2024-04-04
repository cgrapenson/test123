package maven.test123;

import java.util.List;
import java.lang.reflect.Field;

public class ConsoleUI {

     public static void printAccounts(List<Account> accounts) {
        for (Account account : accounts) {
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
    public static void printObject(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("Error accessing field " + field.getName());
            }
        }
    }

}
