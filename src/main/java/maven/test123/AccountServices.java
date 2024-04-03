package maven.test123;

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

}
