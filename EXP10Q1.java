import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EXP10Q1 extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;
    JButton loginButton;
    JLabel messageLabel;

    public EXP10Q1() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        messageLabel = new JLabel("");

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(new JLabel()); // empty cell
        add(loginButton);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("password")) {
            messageLabel.setText("Login successful!");
        } else {
            messageLabel.setText("Invalid credentials!");
        }
    }

    public static void main(String[] args) {
        new EXP10Q1();
    }
}
