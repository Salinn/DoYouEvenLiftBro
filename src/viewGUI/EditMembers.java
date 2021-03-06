package viewGUI;

import Model.AccessToMembers;
import Model.members;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EditMembers extends JPanel {
    private JPanel customerInfo;
    private JPanel bottumLayout;
    private JPanel west;
    private JPanel south;
    private JPanel center;
    private JPanel editLayout;
    private JPanel membershipLayout;
    private JPanel creditCardLayout;

    private Font setFont;
    private Integer value;
    private JButton add;
    private JButton editMembership;

    private JLabel firstName;
    private JLabel lastName;
    private JLabel membership;
    private JLabel id;
    private JLabel renewalDate;
    private JLabel cardNumber;
    private JLabel numberOfDigitsLeft;

    private JTextField firstNameTextBox;
    private JTextField lastNameTextBox;
    private JTextField membershipTextBox;
    private JTextField idTextBox;
    private JTextField renewalDateTextBox;
    private JPasswordField cardNumberTextBox;

    private MemberTableModel model;
    private ArrayList<members> memberList;
    private members mem;
    private int temp;

    public EditMembers(MemberTableModel model, ArrayList<members> memberList){
        this.model = model;
        this.memberList = memberList;
        temp = -1;
        ArrayList<Integer> tempIdList = new ArrayList<Integer>();
        for(members person : memberList){
            tempIdList.add(person.getId());
        }
        boolean flag = true;
        while (flag){
            this.value = ((int)(Math.random() * 9999)) + 1;
            for(Integer tempNum : tempIdList){
                if (tempNum != value){
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
        }
        this.temp = 0;
        this.mem = null;


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
    public EditMembers(MemberTableModel model, ArrayList<members> memberList, members mem, int temp){
        this.model = model;
        this.memberList = memberList;
        this.mem = mem;
        this.temp = temp;

        setFont = new Font("SansSerif", Font.BOLD, 40);

        editLayout = new JPanel();
        editLayout.setLayout(new BorderLayout());

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont, mem.getId());

        System.out.println(mem.getClass());

        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        String nextMonthAsString = sf.format(mem.getRenwalDate());

        firstNameTextBox.setText(mem.getFirstName());
        lastNameTextBox.setText(mem.getLastName());
        membershipTextBox.setText(mem.getMembershipType());
        renewalDateTextBox.setText(nextMonthAsString);
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
        cardNumber  = new JLabel("Credit Card");

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
        membershipLayout = new JPanel();
        membershipLayout.setLayout(new GridLayout(1,2));
        creditCardLayout = new JPanel();
        creditCardLayout.setLayout(new GridLayout(1,2));

        firstNameTextBox   = new JTextField();
        lastNameTextBox    = new JTextField();
        membershipTextBox  = new JTextField();
        idTextBox          = new JTextField();
        renewalDateTextBox = new JTextField();
        cardNumberTextBox  = new JPasswordField();
        editMembership     = new JButton("Edit Membership");
        numberOfDigitsLeft = new JLabel("16 Digits To Enter");

        numberOfDigitsLeft.setFont(setFont);
        editMembership.setFont(setFont);
        firstNameTextBox.setFont(setFont);
        lastNameTextBox.setFont(setFont);
        membershipTextBox.setFont(setFont);
        idTextBox.setFont(setFont);
        renewalDateTextBox.setFont(setFont);
        cardNumberTextBox.setFont(setFont);

        idTextBox.setText(value.toString());
        idTextBox.setEnabled(false);

        final Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(Calendar.MONTH,1);
        final String nextMonthAsString = sf.format(calendar.getTime());

        renewalDateTextBox.setText(nextMonthAsString);
        renewalDateTextBox.setEnabled(false);
        membershipTextBox.setEnabled(false);
        editMembership.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            members mem = new members(firstNameTextBox.getText(), lastNameTextBox.getText(), membershipTextBox.getText(), Integer.parseInt(idTextBox.getText()), calendar.getTime(), cardNumberTextBox.getText());
            gymInterface.refreshNoMemento(new MembershipOptions(new EditMembers(model, memberList, mem, temp), model, memberList, mem, temp));}});

        cardNumberTextBox.setDocument(new JTextFieldLimit(16));

        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
                //System.out.println(cardNumberTextBox.getText());
                int keyCode = keyEvent.getKeyCode();
                String keyText = KeyEvent.getKeyText(keyCode);
                System.out.println(keyCode + "  |  " + keyText);
                int numbersLeft = 16;
                numbersLeft = numbersLeft - (cardNumberTextBox.getText().length());
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_DOWN);
                    robot.keyRelease(KeyEvent.VK_DOWN);
                } catch (AWTException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                numberOfDigitsLeft.setText(Integer.toString(numbersLeft) + " Digits To Enter");
            }public void keyReleased(KeyEvent keyEvent) {}
            public void keyTyped(KeyEvent keyEvent) {}};
        cardNumberTextBox.addKeyListener(keyListener);

        membershipLayout.add(membershipTextBox);
        membershipLayout.add(editMembership);

        creditCardLayout.add(cardNumberTextBox);
        creditCardLayout.add(numberOfDigitsLeft);

        center.add(firstNameTextBox);
        center.add(lastNameTextBox);
        center.add(membershipLayout);
        center.add(idTextBox);
        center.add(renewalDateTextBox);
        center.add(creditCardLayout);

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
                if (temp != -1){
                    memberList.remove(temp);
                }
                Calendar calendar = new GregorianCalendar();
                Date trialTime = new Date();
                calendar.setTime(trialTime);
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                calendar.add(Calendar.MONTH,1);
                String nextMonthAsString = sf.format(calendar.getTime());
                members mem = new members(firstNameTextBox.getText(), lastNameTextBox.getText(), membershipTextBox.getText() , Integer.parseInt(idTextBox.getText()),calendar.getTime(), cardNumberTextBox.getText());
                memberList.add(mem);
                model = new MemberTableModel(memberList);
                gymInterface.memberAccess = new AccessToMembers(memberList);
                gymInterface.refresh(new MemberInterface(model, memberList,""));
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
