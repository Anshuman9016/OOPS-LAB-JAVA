class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}

class PasswordValidator {
    // Method to validate password
    public static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < 8 || !password.matches(".*[a-zA-Z].*") || !password.matches(".*\\d.*")) {
            throw new WeakPasswordException("Error: Password must be at least 8 characters long and include both letters and numbers.");
        }
        System.out.println("Password is strong and valid.");
    }
}

public class PasswordValidationSystem {
    public static void main(String[] args) {
        String[] passwords = {"pass123", "SecurePass1", "12345678", "password", "Pass12"};

        for (String password : passwords) {
            try {
                PasswordValidator.validatePassword(password);
            } catch (WeakPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
