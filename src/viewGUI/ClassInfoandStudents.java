package viewGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassInfoandStudents extends JPanel {
    private  JPanel centerPanel;
    private JButton addStudent;
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
        centerPanel = new JPanel();
        addStudent = new JButton("Add Student");
        addStudent.addActionListener(new ActionListener() {
                    				public void actionPerformed(ActionEvent e){
                                        JPanel addClass= new AddStudent();
                                        gymInterface.refresh(addClass);
                                    }
        });

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

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
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(studentScrollWindow, BorderLayout.CENTER);
        centerPanel.add(addStudent, BorderLayout.SOUTH);
        this.add(centerPanel);


    }
}
