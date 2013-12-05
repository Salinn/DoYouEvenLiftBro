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

    private JPanel centerPanel;
    private JButton addStudent;
    private JPanel topGridPanel;
    private JPanel topPanel;
    private GridMenuItem addButton;

    private JLabel name;
    private JLabel time;
    private JLabel days;
    private JLabel capacity;
    private JLabel location;

    private ArrayList<members> memberList;

    private JTable studentTable;
    private JScrollPane studentScrollWindow;
    private GymMediatorModel mediator;

    private ArrayList<members> theStudents;


    public ClassInfoandStudents(final ClassModel theClass, final GymMediatorModel mediator, final ArrayList<members> memberList){
        Font label_font = new Font("Serif", Font.PLAIN, 30);
        this.mediator = mediator;
        studentTable = new JTable();
        topPanel = new JPanel();
        topGridPanel = new JPanel();
        centerPanel = new JPanel();
        JPanel tempPanel = new JPanel();

        tempPanel.setLayout(new FlowLayout());
        topGridPanel.setLayout(new GridLayout(5,1));
        addStudent = new JButton("Add Student");
        addStudent.setFont(new Font("Sans Serif", Font.BOLD, 40));
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel addClass = new AddStudent(mediator, theClass, memberList);
                gymInterface.refresh(addClass);
            }
        });

        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        name = new JLabel(theClass.getClassName());
        name.setFont(label_font);
        time = new JLabel(theClass.getClassTime());
        time.setFont(label_font);
        days = new JLabel(theClass.getClassDays());
        days.setFont(label_font);
        capacity = new JLabel(theClass.getClassCapacity());
        capacity.setFont(label_font);
        location = new JLabel(theClass.getClassLocation());
        location.setFont(label_font);

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
        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(table.getValueAt(table.getSelectedRow(), 2).toString());
                temp = studentTable.getSelectedRow();
                int tempid = Integer.parseInt(studentTable.getValueAt(studentTable.getSelectedRow(), 2).toString());
                for (members mem : theStudents) {
                    if (mem.getId() == tempid) {
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


        tempPanel.add(addStudent);
        topGridPanel.add(name);
        topGridPanel.add(time);
        topGridPanel.add(days);
        topGridPanel.add(capacity);
        topGridPanel.add(location);
        topPanel.add(topGridPanel);
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(studentScrollWindow, BorderLayout.CENTER);
        centerPanel.add(tempPanel, BorderLayout.SOUTH);
        this.add(centerPanel);


    }

}
