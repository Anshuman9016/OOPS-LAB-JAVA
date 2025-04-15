import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EXP10Q2 extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double firstNum = 0;

    public EXP10Q2() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9]")) {
            display.setText(display.getText() + input);
        } else if (input.matches("[+\\-*/]")) {
            try {
                firstNum = Double.parseDouble(display.getText());
                operator = input;
                display.setText("");
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (input.equals("=")) {
            try {
                double secondNum = Double.parseDouble(display.getText());
                double result = switch (operator) {
                    case "+" -> firstNum + secondNum;
                    case "-" -> firstNum - secondNum;
                    case "*" -> firstNum * secondNum;
                    case "/" -> secondNum != 0 ? firstNum / secondNum : Double.NaN;
                    default -> 0;
                };
                display.setText(String.valueOf(result));
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (input.equals("C")) {
            display.setText("");
            firstNum = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new EXP10Q2();
    }
}
