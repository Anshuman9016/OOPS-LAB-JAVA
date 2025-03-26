class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class Calculator {
    public static int divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }
}

public class EXP8Q1 {
    public static void main(String[] args) {
        int[] numerators = {10, 20, 30};
        int[] denominators = {2, 0, 5};

        for (int i = 0; i < numerators.length; i++) {
            try {
                int result = Calculator.divide(numerators[i], denominators[i]);
                System.out.println("Result: " + result);
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
