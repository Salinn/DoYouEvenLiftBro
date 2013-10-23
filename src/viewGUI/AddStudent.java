package viewGUI;
import java.awt.*;

import javax.swing.*;

public class AddStudent extends JPanel {
    private JButton addStudent;
    private JTextField studentId;
    private JLabel id;

    private JPanel gridPanel;


    public AddStudent(){
        addStudent = new JButton("Add");
        studentId = new JTextField();
        id = new JLabel("Add Student ID");

        gridPanel = new JPanel();

        gridPanel.setLayout(new GridLayout(1,1));
        this.setLayout(new BorderLayout());

        gridPanel.add(id);
        gridPanel.add(studentId);
        this.add(gridPanel, BorderLayout.NORTH);
        this.add(addStudent, BorderLayout.SOUTH);
    }


}
