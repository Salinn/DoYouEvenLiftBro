package viewGUI;

import Model.ClassModel;
import Model.GymMediatorModel;
import Model.members;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClassInfoandStudents extends JPanel {
    private int temp;
    private members selectemem;

    private  JPanel centerPanel;
    private JButton addStudent;
    private JPanel topPanel;
    private GridMenuItem addButton;

    private JLabel name;
    private JLabel time;
    private JLabel days;
    private JLabel capacity;
    private JLabel location;

    private JTable studentTable;
    private JScrollPane studentScrollWindow;
    private GymMediatorModel mediator;

    private ArrayList<members> theStudents;


    public ClassInfoandStudents(final ClassModel theClass, final GymMediatorModel mediator){
        this.mediator = mediator;
        studentTable = new JTable();
        topPanel = new JPanel();
        centerPanel = new JPanel();
        addStudent = new JButton("Add Student");
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel addClass = new AddStudent(mediator, theClass);
                gymInterface.refresh(addClass);
            }
        });

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        name = new JLabel(theClass.getClassName());
        time = new JLabel(theClass.getClassTime());
        days = new JLabel(theClass.getClassDays());
        capacity = new JLabel(theClass.getClassCapacity());
        location = new JLabel(theClass.getClassLocation());

        theStudents = mediator.getAllMembers(theClass);
        String[] columnNames = {"First Name","Last Name","ID"};
        /*
        String[] columnNames = {"First Name","Last Name","ID"};
        Object[][] data = { {"Nsama", "Chipalo", new Integer(1234)},
                            {"Paul", "Allen", new Integer(4321)},
                            {"John", "leen", new Integer(1234)},
                            };
        */
        MemberTableModel model = new MemberTableModel(theStudents);
        studentTable = new JTable(model);
        studentTable.setRowHeight(45);
        studentTable.isCellEditable(0,0);
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(table.getValueAt(table.getSelectedRow(), 2).toString());
                temp = studentTable.getSelectedRow();
                int tempid = Integer.parseInt(studentTable.getValueAt(studentTable.getSelectedRow(), 2).toString());
                for(members mem: theStudents){
                    if (mem.getId() == tempid){
                        //System.out.println(mem);
                        selectemem = mem;
                    }
                }
            }
        });

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
