package maven.test123;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    // method for creating an account
    public static void insertAccount(Connection conn, Account account) {
        PreparedStatement stmt = null;
        try {
            // Create a statement
            stmt = conn.prepareStatement(
                    "INSERT INTO account (firstName, lastName, department, email, password) VALUES (?, ?, ?, ?, ?)");

            // Set the parameters

            stmt.setString(1, account.getFirstName());
            stmt.setString(2, account.getLastName());
            stmt.setString(3, account.getDepartment());
            stmt.setString(4, account.getEmail());
            stmt.setString(5, account.getPassword());

            // Execute the insert statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // method for retrieving accounts
    public static List<Account> retrieveAccounts(Connection conn) {
        List<Account> accounts = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Create a statement
            stmt = conn.createStatement();

            // Execute a query to retrieve all users
            rs = stmt.executeQuery("SELECT * FROM account");

            // Store the retrieved users in a list
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt("accountId"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setDepartment(rs.getString("department"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                accounts.add(account);
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
        return accounts;
    }
    //method for updating an account, based on accountID
    public static void updateAccount(Connection conn, Account account) {
        PreparedStatement stmt = null;
        try {
            // Create a statement
            stmt = conn.prepareStatement(
                "UPDATE account SET firstName = ?, lastName = ?, department = ?, email = ?, password = ? WHERE accountID = ?");
            // Set the parameters
            stmt.setString(1, account.getFirstName());
            stmt.setString(2, account.getLastName());
            stmt.setString(3, account.getDepartment());
            stmt.setString(4, account.getEmail());
            stmt.setString(5, account.getPassword());
            stmt.setInt(6, account.getAccountId());
            
            // Execute the update statement
            stmt.executeUpdate();

        } catch (SQLException e) {
        }   finally {
            // Close the resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean login(String email, String password, Connection conn) {
        String sql = "SELECT * FROM account WHERE email = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if there's at least one matching account
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}

// method for deleting an account

// method for updating an account

// method for retrieving an account

// method for retrieving all accounts

// method for retrieving all accounts by type

// method for retrieving all accounts by status
