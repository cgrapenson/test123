package maven.test123;
import java.sql.*;



public class DbMethods {

    public static void SearchByAuthor(Connection conn, String author) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Create a statement
            stmt = conn.createStatement();
    
            // Execute a query to retrieve all users
            rs = stmt.executeQuery("SELECT title, author_name, genre_name\n" +
                                   "FROM Books\n" +
                                   "JOIN Authors ON Books.author_id = Authors.author_id\n" +
                                   "JOIN Genres ON Books.genre_id = Genres.genre_id\n" +
                                   "WHERE Authors.author_name = '" + author + "'");
    
            // Print the retrieved users
            System.out.println("Books by " + author + ":");
            System.out.println("Title: " + " Author name: "+ " Genre: " );
            while (rs.next()) {
               
                String title = rs.getString("title");
                String authorName = rs.getString("author_name");
                String genre = rs.getString("genre_name");
                
                System.out.println(title + " | " + authorName +" | " + genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
 } 

