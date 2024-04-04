package maven.test123;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class AccountServices {

    public static Account createAccount(Scanner console) {
        Account newAccount = new Account();
     
       // Consume the newline character
        console.nextLine();
        /* Att göra, kolla så att det automatiskt ändrar ifall input är lite fel */
        System.out.print("Enter first name: ");
        newAccount.setFirstName(console.nextLine());
         System.out.print("Enter last name: ");
        newAccount.setLastName(console.nextLine());
        System.out.print("Enter department: Student, Teacher, Researcher:");
         newAccount.setDepartment(console.nextLine());
         System.out.print("Enter email: ");
         newAccount.setEmail(console.nextLine());
        System.out.print("Enter password: ");
         newAccount.setPassword(console.nextLine());
        return newAccount;
    }


    public static Account accountToUpdate(Scanner console) {
        // Change parameters to update
        Account updatedAccount = new Account();
        console.nextLine();
        System.out.print("Enter account ID to update: ");
        updatedAccount.setAccountId(console.nextInt());
        console.nextLine();
        System.out.print("Enter first name: ");
        updatedAccount.setFirstName(console.nextLine());
        System.out.print("Enter last name: ");
        updatedAccount.setLastName(console.nextLine());
        System.out.print("Enter department: Student, Teacher, Researcher:");
        updatedAccount.setDepartment(console.nextLine());
        System.out.print("Enter email: ");
        updatedAccount.setEmail(console.nextLine());
        System.out.print("Enter password: ");
        updatedAccount.setPassword(console.nextLine());
        return updatedAccount;

    }

}
