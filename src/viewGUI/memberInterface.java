package viewGUI;

import Model.AccessToMembers;
import Model.members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Model.members;

public class memberInterface extends JPanel{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel bottumLayout;
    private JPanel membershipLayout;
    private JPanel searchBar;

    private JTextField searchFeild;

    private JButton add;
    private JButton edit;

    private JTable table;

    private int temp;

    private JScrollPane scrollWindow;

    private Font setFont;
    private members selectemem;

    private MemberTableModel model;
    private ArrayList<members> memberList;
    public memberInterface(MemberTableModel model, ArrayList<members> memberList, String seachPhrase) {
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
        bottumLayout = initSouth(setFont, seachPhrase);


        //Adds the different layouts to the boarder layout
        membershipLayout.add(scrollWindow, BorderLayout.CENTER);
        membershipLayout.add(bottumLayout, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(membershipLayout, BorderLayout.CENTER);
    }

    private JPanel initSouth(Font setFont, String searchPhrase){
        //Creates the Southern Layout using a FlowLayout
        bottumLayout = new JPanel();
        bottumLayout.setLayout(new GridLayout());
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout());

        //Creates an Add button and sets its font
        add = new JButton(" Add ");
        add.setFont(setFont);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gymInterface.refresh(new editMembers(model,memberList));
            }
        });

        //Creates an Edit button and set its font
        edit = new JButton(" Edit ");
        edit.setFont(setFont);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gymInterface.refresh((new editMembers(model,memberList, selectemem, temp)));
            }
        });

        //Creates a search feild and sets the width and fon

        //Create Search bar elements
        searchFeild = new JTextField();
        if (searchPhrase.compareTo("") == 0){
            searchFeild.setText("Search for Member");
        } else {
            searchFeild.setText(searchPhrase);
        }
        searchFeild.setFont(setFont);
        searchFeild.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                searchFeild.setText("");
            }public void focusLost(FocusEvent e) {}});
        JButton searchButton = new JButton("Search");
        searchButton.setFont(setFont);
        searchButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            ArrayList<members> updated_memberList = new ArrayList<members>();
            if (searchFeild.getText().compareTo("Search for Member") == 0){
                updated_memberList = searchForMembers(memberList, "");
            } else {
                updated_memberList = searchForMembers(memberList, searchFeild.getText());
            }
            final MemberTableModel updated_model = new MemberTableModel(updated_memberList);
            gymInterface.refreshNoMemento(new memberInterface(updated_model,memberList,searchFeild.getText()));}});

        tempPanel.add(searchButton);
        tempPanel.add(add);
        tempPanel.add(edit);

        bottumLayout.add(searchFeild);
        bottumLayout.add(tempPanel);

        return bottumLayout;
    }
    private JScrollPane initCenter(Font setFont){
        //This is just data to populate the table to show what it would look like
        String[] columnNames = {"First Name","Last Name","ID"};

 
        
        //Creates a table of all of the customers and sets the font
        table = new JTable(model);
        table.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        table.setRowHeight(45);
        table.isCellEditable(0, 0);
        table.getTableHeader().setReorderingAllowed(false);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //System.out.println(table.getValueAt(table.getSelectedRow(), 2).toString());
                temp = table.getSelectedRow();
                int tempid = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
                for(members mem: memberList){
                    if (mem.getId() == tempid){
                        //System.out.println(mem);
                        selectemem = mem;
                    }
                }
            }
        });
        
        //Table renderer for alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.LEFT   );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        
        
        table.getTableHeader().setFont(setFont);
        

        //new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        x.getVerticalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        x.getHorizontalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
        x.setBorder(BorderFactory.createEmptyBorder());
        return x;
    }

    private ArrayList<members> searchForMembers(ArrayList<members> memberList, String input){
        System.out.println(input);
        ArrayList<members> updated_memberList = new ArrayList<members>();
        for(members current: memberList){
            if (current.getId().toString().contains((input))){
                updated_memberList.add(current);
            }
            if (current.getFirstName().toUpperCase().contains(input.toUpperCase())){
                updated_memberList.add(current);
            }
            if (current.getLastName().toUpperCase().contains(input.toUpperCase())){
                updated_memberList.add(current);
            }
        }
        return updated_memberList;
    }
}