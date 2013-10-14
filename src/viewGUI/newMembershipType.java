package viewGUI;

import javax.swing.*;
import java.awt.*;

public class newMembershipType {
    private Font setFont;
    private JPanel membershipType;
    private JPanel west;
    private JPanel south;
    private JPanel center;
    private JButton add;

    private JLabel typeName;
    private JLabel price;
    private JLabel classAccess;
    private JLabel leagueAccess;
    private JLabel gymAccess;

    private JTextField typeNameTextBox;
    private JTextField priceTextBox;
    private JTextField classAccessTextBox;
    private JTextField leagueAccessTextBox;
    private JTextField gymAccessTextBox;

    public  newMembershipType(){
        setFont = new Font("SansSerif", Font.BOLD, 40);
        membershipType = new JPanel();
        membershipType.setLayout(new BorderLayout(15,15));

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont);

        membershipType.add(west, BorderLayout.WEST);
        membershipType.add(south, BorderLayout.SOUTH);
        membershipType.add(center, BorderLayout.CENTER);
        //membershipType.add(center, BorderLayout.CENTER);

    }
    private JPanel initWest(Font setFont){
        west = new JPanel();
        west.setLayout(new GridLayout(9,1));

        typeName     = new JLabel("Name of Membership");
        price        = new JLabel("Price");
        classAccess  = new JLabel("Class Access");
        leagueAccess = new JLabel("League Access");
        gymAccess    = new JLabel("Gym Access");

        typeName.setFont(setFont);
        price.setFont(setFont);
        classAccess.setFont(setFont);
        leagueAccess.setFont(setFont);
        gymAccess.setFont(setFont);

        west.add(typeName);
        west.add(price);
        west.add(classAccess);
        west.add(leagueAccess);
        west.add(gymAccess);

        return west;
    }
    private JPanel initCenter(Font setFont){
        center = new JPanel();
        center.setLayout(new GridLayout(9,1));

        typeNameTextBox     = new JTextField();
        priceTextBox        = new JTextField();
        classAccessTextBox  = new JTextField();
        leagueAccessTextBox = new JTextField();
        gymAccessTextBox    = new JTextField();

        typeNameTextBox.setFont(setFont);
        priceTextBox.setFont(setFont);
        classAccessTextBox.setFont(setFont);
        leagueAccessTextBox.setFont(setFont);
        gymAccessTextBox.setFont(setFont);

        center.add(typeNameTextBox);
        center.add(priceTextBox);
        center.add(classAccessTextBox);
        center.add(leagueAccessTextBox);
        center.add(gymAccessTextBox);

        return center;
    }
    private JPanel initSouth(Font setFont){
        //Creates the Southern Layout using a FlowLayout
        south = new JPanel();
        south.setLayout(new FlowLayout());

        //Creates an Add button and sets its font
        add = new JButton(" Add Membership Type ");
        add.setFont(setFont);
        add.setSize(1000,1000);

        //Adds the 2 buttons and text feild to the flow layout
        south.add(add);

        return south;
    }
    public JPanel getPanel(){
        return membershipType;
    }
}
