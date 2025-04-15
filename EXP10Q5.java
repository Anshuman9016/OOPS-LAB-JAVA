import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EXP10Q5 extends JFrame implements ActionListener {

    JLabel timeLabel;
    JButton startButton, stopButton, resetButton;
    Timer timer;
    int elapsedTime = 0;

    public EXP10Q5() {
        setTitle("Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("Elapsed Time: 0s");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(startButton);
        add(stopButton);
        add(resetButton);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                timeLabel.setText("Elapsed Time: " + elapsedTime + "s");
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
            startButton.setEnabled(false); // Disable the Start button while running
            stopButton.setEnabled(true);   // Enable the Stop button
        } else if (e.getSource() == stopButton) {
            timer.stop();
            startButton.setEnabled(true);  // Enable the Start button to resume
            stopButton.setEnabled(false); // Disable the Stop button
        } else if (e.getSource() == resetButton) {
            timer.stop();
            elapsedTime = 0;
            timeLabel.setText("Elapsed Time: 0s");
            startButton.setEnabled(true);  // Enable the Start button to begin again
            stopButton.setEnabled(false); // Disable the Stop button
        }
    }

    public static void main(String[] args) {
        new EXP10Q5();
    }
}
