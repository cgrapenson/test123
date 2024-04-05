package maven.test123;

import java.util.*;
import java.sql.*;

public class BookRepository {

    // method for creating a book

    // method for deleting a book

    // method for updating a book

    // method for retrieving list of books
    public static List<Book> retrieveBook(Connection conn) {
        List<Book> books = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Create a statement
            stmt = conn.createStatement();
            // Execute a query to retrieve list of books
                rs = stmt.executeQuery("SELECT * FROM BOOK b JOIN Item i ON b.itemID = i.itemID");
                

                // Store the retrieved books in a list
                while (rs.next()) {
                    Book book = new Book();
                    book.setGenre(rs.getString("genre"));
                    book.setTitle(rs.getString("title"));
                    book.setItemId(rs.getInt("itemID"));
                    book.setAuthor(rs.getString("author"));
                    book.setpublisher(rs.getString("publisher"));
                    book.setIsbn(rs.getString("isbn"));
                    
                    books.add(book);
                }

            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return books;
    }
    // method for retrieving all books

    // method for retrieving all books by genre

    // method for retrieving all books by author

    // method for retrieving all books by title

    // method for retrieving all books by release year

    // method for retrieving all books by status (available or not available)

}
