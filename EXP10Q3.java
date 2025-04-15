import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EXP10Q3 extends JFrame implements ActionListener {

    JTextField taskField;
    JButton addButton, removeButton;
    JList<String> taskList;
    DefaultListModel<String> listModel;

    public EXP10Q3() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel for input and buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        taskField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        topPanel.add(taskField);
        topPanel.add(addButton);
        topPanel.add(removeButton);
        add(topPanel, BorderLayout.NORTH);

        // List and model for tasks
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new EXP10Q3();
    }
}
