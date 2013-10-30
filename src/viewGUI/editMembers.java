package viewGUI;

import Model.members;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class editMembers extends JPanel {
    private JPanel customerInfo;
    private JPanel bottumLayout;
    private JPanel west;
    private JPanel south;
    private JPanel center;
    private JPanel editLayout;

    private Font setFont;
    private Integer value;
    private JButton add;

    private JLabel firstName;
    private JLabel lastName;
    private JLabel membership;
    private JLabel id;
    private JLabel renewalDate;
    private JLabel cardNumber;

    private JTextField firstNameTextBox;
    private JTextField lastNameTextBox;
    private JTextField membershipTextBox;
    private JTextField idTextBox;
    private JTextField renewalDateTextBox;
    private JPasswordField cardNumberTextBox;

    private MemberTableModel model;
    private ArrayList<members> memberList;
    private members mem;

    public editMembers(MemberTableModel model, ArrayList<members> memberList){
        this.model = model;
        this.memberList = memberList;
        ArrayList<Integer> tempIdList = new ArrayList<Integer>();
        for(members person : memberList){
            tempIdList.add(person.getId());
        }
        boolean flag = true;
        while (flag){
            this.value = (int)(Math.random() * 8847);
            for(Integer tempNum : tempIdList){
                if (tempNum != value){
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
        }


        setFont = new Font("SansSerif", Font.BOLD, 40);
        editLayout = new JPanel();
        editLayout.setLayout(new BorderLayout());

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont, value);

        editLayout.add(west, BorderLayout.WEST);
        editLayout.add(south, BorderLayout.SOUTH);
        editLayout.add(center, BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(editLayout, BorderLayout.CENTER);
    }
    public editMembers(MemberTableModel model, ArrayList<members> memberList, members mem){
        this.model = model;
        this.memberList = memberList;
        this.mem = mem;

        setFont = new Font("SansSerif", Font.BOLD, 40);

        editLayout = new JPanel();
        editLayout.setLayout(new BorderLayout());

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont, mem.getId());

        System.out.println(mem.getClass());

        firstNameTextBox.setText(mem.getFirstName());
        lastNameTextBox.setText(mem.getLastName());
        membershipTextBox.setText(mem.getMembershipType());
        renewalDateTextBox.setText(mem.getRenwalDate().toString());
        cardNumberTextBox.setText(mem.getCreditCard());



        editLayout.add(west, BorderLayout.WEST);
        editLayout.add(south, BorderLayout.SOUTH);
        editLayout.add(center, BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(editLayout, BorderLayout.CENTER);
    }
    private JPanel initWest(Font setFont){
        west = new JPanel();
        west.setLayout(new GridLayout(9,1));

        firstName   = new JLabel("First Name");
        lastName    = new JLabel("Last Name");
        membership  = new JLabel("Membership Type");
        id          = new JLabel("ID");
        renewalDate = new JLabel("Renewal Date");
        cardNumber  = new JLabel("Credit Care");

        firstName.setFont(setFont);
        lastName.setFont(setFont);
        membership.setFont(setFont);
        id.setFont(setFont);
        renewalDate.setFont(setFont);
        cardNumber.setFont(setFont);

        west.add(firstName);
        west.add(lastName);
        west.add(membership);
        west.add(id);
        west.add(renewalDate);
        west.add(cardNumber);

        return west;
    }
    private JPanel initCenter(Font setFont, Integer value){
        center = new JPanel();
        center.setLayout(new GridLayout(9,1));

        firstNameTextBox   = new JTextField();
        lastNameTextBox    = new JTextField();
        membershipTextBox  = new JTextField();
        idTextBox          = new JTextField();
        renewalDateTextBox = new JTextField();
        cardNumberTextBox  = new JPasswordField();

        firstNameTextBox.setFont(setFont);
        lastNameTextBox.setFont(setFont);
        membershipTextBox.setFont(setFont);
        idTextBox.setFont(setFont);
        renewalDateTextBox.setFont(setFont);
        cardNumberTextBox.setFont(setFont);

        idTextBox.setText(value.toString());
        idTextBox.setEnabled(false);

        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(Calendar.MONTH,1);
        String nextMonthAsString = sf.format(calendar.getTime());

        renewalDateTextBox.setText(nextMonthAsString);
        renewalDateTextBox.setEnabled(false);

        membershipTextBox.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                gymInterface.refresh(new MembershipOptions());
            }
            public void focusLost(FocusEvent e) {
            }
        });

        center.add(firstNameTextBox);
        center.add(lastNameTextBox);
        center.add(membershipTextBox);
        center.add(idTextBox);
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
        add.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            if (cardNumberTextBox.getText().length() == 16){
                Calendar calendar = new GregorianCalendar();
                Date trialTime = new Date();
                calendar.setTime(trialTime);
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                calendar.add(Calendar.MONTH,1);
                String nextMonthAsString = sf.format(calendar.getTime());
                members mem = new members(firstNameTextBox.getText(), lastNameTextBox.getText(), membershipTextBox.getText() , Integer.parseInt(idTextBox.getText()),calendar.getTime(), cardNumberTextBox.getText());
                memberList.add(mem);
                model = new MemberTableModel(memberList);
                gymInterface.refresh(new memberInterface(model, memberList));
            } else if (cardNumberTextBox.getText().length() < 16){
                JOptionPane.showMessageDialog(center,
                        "The credit card is missing a few numbers",
                        "Please update",
                        JOptionPane.ERROR_MESSAGE);
            } else if (cardNumberTextBox.getText().length() > 16){
                JOptionPane.showMessageDialog(center,
                        "The credit card has to many numbers",
                        "Please update",
                        JOptionPane.ERROR_MESSAGE);
            }}});

        //Adds the 2 buttons and text feild to the flow layout
        bottumLayout.add(add);

        return bottumLayout;
    }
}
