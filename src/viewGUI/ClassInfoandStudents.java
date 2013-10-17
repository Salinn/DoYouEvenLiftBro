package viewGUI;

import javax.swing.*;
import java.awt.*;

public class ClassInfoandStudents extends JPanel {
    private JPanel topPanel;


    private JTextField name;
    private JTextField time;
    private JTextField days;
    private JTextField capacity;
    private JTextField location;


    public ClassInfoandStudents(){


        topPanel = new JPanel();

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());

        name = new JTextField();
        time = new JTextField();
        days = new JTextField();
        capacity = new JTextField();
        location = new JTextField();

    }
}
