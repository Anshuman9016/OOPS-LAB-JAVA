class InvalidOrderAmountException extends Exception {
    public InvalidOrderAmountException(String message) {
        super(message);
    }
}

class OrderProcessor {
    public static void processOrder(double amount) throws InvalidOrderAmountException {
        if (amount <= 0) {
            throw new InvalidOrderAmountException("Error: Order amount must be greater than zero.");
        }
        System.out.println("Order processed successfully with amount: " + amount);
    }
}

public class EXP8Q3 {
    public static void main(String[] args) {
        double[] orderAmounts = {100, -50, 0, 250};

        for (double amount : orderAmounts) {
            try {
                OrderProcessor.processOrder(amount);
            } catch (InvalidOrderAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
