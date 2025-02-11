class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    protected void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class Q2EXP4 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(100);

        myAccount.deposit(50);
        
        myAccount.checkBalance();
        
        myAccount.withdraw(30);
        
        myAccount.checkBalance();
    }
}
