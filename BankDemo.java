interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
}

class Account implements Bank {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", Updated Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Updated Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {

        Account myAccount = new Account(2500);
        myAccount.deposit(500);
        myAccount.withdraw(200);
        myAccount.withdraw(3500); 
    }
}
