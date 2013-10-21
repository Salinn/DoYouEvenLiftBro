package viewGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class editMembers extends JPanel {
    private JPanel customerInfo;
    private JPanel bottumLayout;
    private JPanel west;
    private JPanel south;
    private JPanel center;
    private JPanel editLayout;

    private Font setFont;

    private JButton add;
    private JButton back;

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

    public editMembers(){
        setFont = new Font("SansSerif", Font.BOLD, 40);

        this.setLayout(new BorderLayout(15, 15));

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont);

        this.add(west, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);
        this.add(center, BorderLayout.CENTER);
    }
    public editMembers(Object[][] person){
        setFont = new Font("SansSerif", Font.BOLD, 40);

        editLayout = new JPanel();
        editLayout.setLayout(new BorderLayout());

        west = initWest(setFont);
        south = initSouth(setFont);
        center = initCenter(setFont);

        firstNameTextBox.setText("Paul");
        lastNameTextBox.setText("Darragh");
        membershipTextBox.setText("Basic");
        renewalDateTextBox.setText("11-10-2013");
        cardNumberTextBox.setText("**********");

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
    private JPanel initCenter(Font setFont){
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

        idTextBox.setText("1234");
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
            if (cardNumberTextBox.getText().length() == 10){
                gymInterface.refresh(new memberInterface());
            } else if (cardNumberTextBox.getText().length() < 10){
                JOptionPane.showMessageDialog(center,
                        "The credit card is missing a few numbers",
                        "Please update",
                        JOptionPane.ERROR_MESSAGE);
            } else if (cardNumberTextBox.getText().length() > 10){
                JOptionPane.showMessageDialog(center,
                        "The credit card has to many numbers",
                        "Please update",
                        JOptionPane.ERROR_MESSAGE);
            }}});


        //Creates an Add button and sets its font
        back = new JButton(" Back ");
        back.setFont(setFont);
        back.setSize(1000,1000);
        back.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {gymInterface.undo();}});

        //Adds the 2 buttons and text feild to the flow layout
        bottumLayout.add(add);
        bottumLayout.add(back);

        return bottumLayout;
    }
}
