import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EXP10Q4 extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField, confirmPasswordField;
    JLabel nameError, emailError, passError, confirmPassError, resultLabel;
    JButton registerButton;

    public EXP10Q4() {
        setTitle("Registration Form");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 3, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameError = new JLabel();
        nameError.setForeground(Color.RED);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailError = new JLabel();
        emailError.setForeground(Color.RED);

        JLabel passLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passError = new JLabel();
        passError.setForeground(Color.RED);

        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();
        confirmPassError = new JLabel();
        confirmPassError.setForeground(Color.RED);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(nameLabel);
        add(nameField);
        add(nameError);

        add(emailLabel);
        add(emailField);
        add(emailError);

        add(passLabel);
        add(passwordField);
        add(passError);

        add(confirmPassLabel);
        add(confirmPasswordField);
        add(confirmPassError);

        add(new JLabel());
        add(registerButton);
        add(new JLabel());

        add(new JLabel());
        add(resultLabel);
        add(new JLabel());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean valid = true;

        nameError.setText("");
        emailError.setText("");
        passError.setText("");
        confirmPassError.setText("");
        resultLabel.setText("");

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (name.isEmpty()) {
            nameError.setText("Name is required");
            valid = false;
        }

        if (email.isEmpty()) {
            emailError.setText("Email is required");
            valid = false;
        } else if (!email.contains("@")) {
            emailError.setText("Invalid email");
            valid = false;
        }

        if (password.isEmpty()) {
            passError.setText("Password is required");
            valid = false;
        }

        if (confirmPassword.isEmpty()) {
            confirmPassError.setText("Confirm your password");
            valid = false;
        } else if (!password.equals(confirmPassword)) {
            confirmPassError.setText("Passwords do not match");
            valid = false;
        }

        if (valid) {
            resultLabel.setForeground(new Color(0, 128, 0)); // dark green
            resultLabel.setText("Registration Successful!");
        } else {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Please fix the above errors.");
        }
    }

    public static void main(String[] args) {
        new EXP10Q4();
    }
}
