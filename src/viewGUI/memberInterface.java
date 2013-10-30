package viewGUI;

import Model.members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import Model.members;

public class memberInterface extends JPanel{
    private JPanel bottumLayout;
    private JPanel membershipLayout;

    private JTextField searchFeild;

    private JButton add;
    private JButton edit;

    private JTable table;

    private JScrollPane scrollWindow;

    private Font setFont;
    private members selectemem;

    private MemberTableModel model;
    private ArrayList<members> memberList;
    public memberInterface(MemberTableModel model, ArrayList<members> memberList) {
        this.model = model;
        this.memberList =memberList;
        //Creates the font that the rest of the program will use
        setFont = new Font("SansSerif", Font.BOLD, 40);

        membershipLayout = new JPanel();

        //Creates the panel to be passed back and makes it a border layout
        membershipLayout.setLayout(new BorderLayout(15, 15));
        membershipLayout.setVisible(true);

        //Gets the layout of different parts of the boarder layout
        scrollWindow = initCenter(setFont);
        bottumLayout = initSouth(setFont);


        //Adds the different layouts to the boarder layout
        membershipLayout.add(scrollWindow, BorderLayout.CENTER);
        membershipLayout.add(bottumLayout, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(membershipLayout, BorderLayout.CENTER);
    }

    private JPanel initSouth(Font setFont){
        //Creates the Southern Layout using a FlowLayout
        bottumLayout = new JPanel();
        bottumLayout.setLayout(new FlowLayout());

        //Creates an Add button and sets its font
        add = new JButton(" Add Member ");
        add.setFont(setFont);
        add.setSize(1000, 1000);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gymInterface.refresh(new editMembers(model,memberList));
            }
        });

        //Creates an Edit button and set its font
        edit = new JButton(" Edit Member ");
        edit.setFont(setFont);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gymInterface.refresh((new editMembers(model,memberList, selectemem)));
            }
        });

        //Creates a search feild and sets the width and font
        searchFeild = new JTextField("",15);
        searchFeild.setFont(setFont);

        //Adds the 2 buttons and text feild to the flow layout
        bottumLayout.add(searchFeild);
        bottumLayout.add(add);
        bottumLayout.add(edit);

        return bottumLayout;
    }
    private JScrollPane initCenter(Font setFont){
        //This is just data to populate the table to show what it would look like
        String[] columnNames = {"First Name","Last Name","ID"};

        //Creates a table of all of the customers and sets the font
        table = new JTable(model);
        table.setFont(setFont);
        table.setRowHeight(45);
        table.isCellEditable(0,0);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(table.getValueAt(table.getSelectedRow(), 2).toString());
                int temp = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
                for(members mem: memberList){
                    if (mem.getId() == temp){
                        //System.out.println(mem);
                        selectemem = mem;
                    }
                }
            }
        });


        //new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        x.getVerticalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        x.getHorizontalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        x.setBorder(BorderFactory.createEmptyBorder());
        return x;
    }
}
