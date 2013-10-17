package viewGUI;


import javax.swing.*;
import java.awt.*;

public class AddClass extends JPanel {
    private JButton addButton;

    private JPanel westPanel;
    private JPanel centerPanel;

    private JLabel className;
    private JLabel classTime;
    private JLabel classDays;
    private JLabel classCapacity;
    private JLabel classLocation;

    private JTextField name;
    private JTextField time;
    private JTextField days;
    private JTextField capacity;
    private JTextField location;

    public AddClass(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        addButton = new JButton("ADD CLASS");

        westPanel = new JPanel();
        centerPanel = new JPanel();

        westPanel.setLayout(new GridLayout(5,1));
        centerPanel.setLayout(new GridLayout(5,1));
        this.setLayout(new BorderLayout());

        className = new JLabel("Class Name");
        classTime = new JLabel("Class Time");
        classDays = new JLabel("Class Days");
        classCapacity = new JLabel("Class Capacity");
        classLocation = new JLabel("Class Location");

        name = new JTextField();
        time = new JTextField();
        days = new JTextField();
        capacity = new JTextField();
        location = new JTextField();

        westPanel.add(className);
        westPanel.add(classTime);
        westPanel.add(classDays);
        westPanel.add(classLocation);
        westPanel.add(classCapacity);

        centerPanel.add(name);
        centerPanel.add(time);
        centerPanel.add(days);
        centerPanel.add(location);
        centerPanel.add(capacity);

        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
    }
}

