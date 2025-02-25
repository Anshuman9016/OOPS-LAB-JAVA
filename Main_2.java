// Main.java
import Balance.Account; // Import the Account class from Balance package

public class Main_2 {
    public static void main(String[] args) {
        // Create an account object with a balance
        Account myAccount = new Account(1000.50);

        // Display the account balance
        myAccount.Display_Balance();
    }
}
