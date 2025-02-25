package Balance;

public class Account {
    private double balance;

    // Constructor to initialize balance
    public Account(double balance) {
        this.balance = balance;
    }

    // Method to display account balance
    public void Display_Balance() {
        System.out.println("Account Balance: $" + balance);
    }

    public static void main(String[] args) {
        Account acc = new Account(1000);
        acc.Display_Balance();
    }
}
