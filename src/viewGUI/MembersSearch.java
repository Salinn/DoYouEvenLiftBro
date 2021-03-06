package viewGUI;

import EquipmentView.EquipmentInfo;
import Model.ClassModel;
import Model.Equipment;
import Model.GymMediatorModel;
import Model.members;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: salinn
 * Date: 11/14/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembersSearch extends JPanel {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel bottumLayout;
    private JPanel membershipLayout;
    private JPanel searchBar;

    private JTextField searchFeild;

    private JTable table;

    private int temp;
    GymMediatorModel mediator;
    ClassModel className;

    private JScrollPane scrollWindow;
    JButton selectButton;

    private Font setFont;
    private members selectemem;
    private Equipment equipment;

    private MemberTableModel model;
    private ArrayList<members> memberList;
    public MembersSearch(Equipment equipment,MemberTableModel model, ArrayList<members> memberList, String seachPhrase) {
        this.model = model;
        this.memberList =memberList;
        this.equipment = equipment;
        //Creates the font that the rest of the program will use
        setFont = new Font("SansSerif", Font.PLAIN, 30);

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
    public MembersSearch(GymMediatorModel mediator, ClassModel className, ArrayList<members> memberList, String seachPhrase) {
        this.model = new MemberTableModel(memberList);
        this.mediator = mediator;
        this.className = className;
        this.memberList = memberList;
        //Creates the font that the rest of the program will use
        setFont = new Font("SansSerif", Font.PLAIN, 30);

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
        
        //TODO Once this screen is used for classes change the text of the 
        //select button to be based on the what the screen is
        //i.e. if(loan screen){text set to loan} elif(class screen){text set to add}
        if (equipment == null){
            selectButton = new JButton("Add");
        } else {
            selectButton = new JButton("Loan");
        }
        searchButton.setFont(setFont);
        selectButton.setFont(setFont);
        searchButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            ArrayList<members> updated_memberList = new ArrayList<members>();
            if (searchFeild.getText().compareTo("Search for Member") == 0){
                updated_memberList = searchForMembers(memberList, "");
            } else {
                updated_memberList = searchForMembers(memberList, searchFeild.getText());
            }
            final MemberTableModel updated_model = new MemberTableModel(updated_memberList);
            gymInterface.refreshNoMemento(new MembersSearch(equipment,updated_model,memberList,searchFeild.getText()));}});

        selectButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            if (equipment == null){
                gymInterface.refresh(new ClassInfoandStudents(className, mediator, memberList));
            }else{
                gymInterface.refresh(new EquipmentInfo(equipment, memberList));
            }}});

        tempPanel.add(searchButton);
        tempPanel.add(selectButton);

        bottumLayout.add(searchFeild);
        bottumLayout.add(tempPanel);

        return bottumLayout;
    }
    private JScrollPane initCenter(Font setFont){
        //This is just data to populate the table to show what it would look like
        String[] columnNames = {"First Name","Last Name","ID"};

        //Creates a table of all of the customers and sets the font
        table = new JTable(model);
        table.setFont(setFont);
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
                    if(equipment == null){
                        if(mem.getId() == tempid){
                            selectemem = mem;
                            className.addStudents(selectemem);
                        }
                    } else {
                        if (mem.getId() == tempid){
                            //System.out.println(mem);
                            selectemem = mem;
                            equipment.setLoan(true, Integer.toString(selectemem.getId()));
                        }
                    }
                }
            }
        });
        
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
        ArrayList<members> updated_memberList = new ArrayList<members>();
        for(members current: memberList){
            try {
                if (current.getId().toString().contains((input))){
                    updated_memberList.add(current);
                }
            }
            catch( Exception e ) {
                if (current.getFirstName().toUpperCase().contains(input.toUpperCase())){
                    updated_memberList.add(current);
                } else if (current.getFirstName().toUpperCase().contains(input.toUpperCase())){
                    updated_memberList.add(current);
                }
            }
        }
        return updated_memberList;
    }
}