package viewGUI;

import javax.swing.*;
import java.awt.*;

public class ClassInfoandStudents extends JPanel {
    private JPanel topPanel;

    private JLabel name;
    private JLabel time;
    private JLabel days;
    private JLabel capacity;
    private JLabel location;

    private JTable studentTable;
    private JScrollPane studentScrollWindow;


    public ClassInfoandStudents(){
        studentTable = new JTable();
        topPanel = new JPanel();

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());

        name = new JLabel("the name");
        time = new JLabel("the time");
        days = new JLabel("the days");
        capacity = new JLabel("the capacity");
        location = new JLabel("the location");

        String[] columnNames = {"First Name","Last Name","ID"};
        Object[][] data = { {"Nsama", "Chipalo", new Integer(1234)},
                            {"Paul", "Allen", new Integer(4321)},
                            {"John", "leen", new Integer(1234)},
                            };


        studentTable = new JTable(data, columnNames);
        studentTable.setRowHeight(45);
        studentTable.isCellEditable(0,0);

        studentScrollWindow = new JScrollPane(studentTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        studentScrollWindow.getVerticalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        studentScrollWindow.getHorizontalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        studentScrollWindow.setBorder(BorderFactory.createEmptyBorder());


        topPanel.add(name);
        topPanel.add(time);
        topPanel.add(days);
        topPanel.add(capacity);
        topPanel.add(location);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(studentScrollWindow, BorderLayout.CENTER);


    }
}
