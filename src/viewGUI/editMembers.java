package viewGUI;

import javax.swing.*;
import java.awt.*;

public class editMembers extends JPanel {
    private JPanel customerInfo;
    private JPanel bottumLayout;
    private JPanel west;
    private JPanel south;
    private JPanel center;

    private Font setFont;

    private JButton add;

    private JTextField searchFeild;

    private JLabel firstName;
    private JLabel lastName;
    private JLabel membership;
    private JLabel id;
    private JLabel address;
    private JLabel renewalDate;
    private JLabel cardNumber;

    private JTextField firstNameTextBox;
    private JTextField lastNameTextBox;
    private JTextField membershipTextBox;
    private JTextField idTextBox;
    private JTextField addressTextBox;
    private JTextField renewalDateTextBox;
    private JTextField cardNumberTextBox;

    public editMembers(){
        setFont = new Font("SansSerif", Font.BOLD, 40);
        customerInfo = new JPanel();
        customerInfo.setLayout(new BorderLayout(15,15));

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont);

        customerInfo.add(west, BorderLayout.WEST);
        customerInfo.add(south, BorderLayout.SOUTH);
        customerInfo.add(center, BorderLayout.CENTER);

    }
    private JPanel initWest(Font setFont){
        west = new JPanel();
        west.setLayout(new GridLayout(9,1));

        firstName   = new JLabel("First Name");
        lastName    = new JLabel("Last Name");
        membership  = new JLabel("Membership Type");
        id          = new JLabel("ID");
        address     = new JLabel("Address");
        renewalDate = new JLabel("Renewal Date");
        cardNumber  = new JLabel("Credit Care");

        firstName.setFont(setFont);
        lastName.setFont(setFont);
        membership.setFont(setFont);
        id.setFont(setFont);
        address.setFont(setFont);
        renewalDate.setFont(setFont);
        cardNumber.setFont(setFont);

        west.add(firstName);
        west.add(lastName);
        west.add(membership);
        west.add(id);
        west.add(address);
        west.add(renewalDate);
        west.add(cardNumber);

        return west;
    }
    private JPanel initCenter(Font setFont){
        center = new JPanel();
        center.setLayout(new GridLayout(9,1));

        firstNameTextBox   = new JTextField();
        lastNameTextBox    = new JTextField();
        membershipTextBox  = new JTextField();
        idTextBox          = new JTextField();
        addressTextBox     = new JTextField();
        renewalDateTextBox = new JTextField();
        cardNumberTextBox  = new JTextField();

        firstNameTextBox.setFont(setFont);
        lastNameTextBox.setFont(setFont);
        membershipTextBox.setFont(setFont);
        idTextBox.setFont(setFont);
        addressTextBox.setFont(setFont);
        renewalDateTextBox.setFont(setFont);
        cardNumberTextBox.setFont(setFont);

        center.add(firstNameTextBox);
        center.add(lastNameTextBox);
        center.add(membershipTextBox);
        center.add(idTextBox);
        center.add(addressTextBox);
        center.add(renewalDateTextBox);
        center.add(cardNumberTextBox);

        return center;
    }
    private JPanel initSouth(Font setFont){
        //Creates the Southern Layout using a FlowLayout
        bottumLayout = new JPanel();
        bottumLayout.setLayout(new FlowLayout());

        //Creates an Add button and sets its font
        add = new JButton(" Add Member ");
        add.setFont(setFont);
        add.setSize(1000,1000);

        //Adds the 2 buttons and text feild to the flow layout
        bottumLayout.add(add);

        return bottumLayout;
    }
}
