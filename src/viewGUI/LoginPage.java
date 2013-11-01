package viewGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginPage extends JPanel {

    private Hashtable<String,String> loginHash = new Hashtable<String,String>();

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton buttonEnter;
    private JButton buttonClear;

    private JButton homeLabel;

    private JPasswordField passwordField;

    private Font setFont;

    private ImageIcon homeScreen;

    private JPanel north;
    private JPanel center;
    private JPanel mainView;
    private JPanel startingImage;
    public LoginPage(){
        mainView = new JPanel();
        mainView.setLayout(new BorderLayout());

        initCredentials();
        north = initNorth();
        center = initCenter();

        mainView.add(north, BorderLayout.NORTH);
        mainView.add(center, BorderLayout.CENTER);
        mainView.setVisible(true);
        

        this.setLayout(new BorderLayout());
        this.add(mainView, BorderLayout.CENTER);
        this.setVisible(true);
        
    }
    private void initCredentials(){
        loginHash.put("1111", "Welcome Robert!");
        loginHash.put("2222", "Welcome Nsama!");
        loginHash.put("3333", "Welcome Paul!");
        loginHash.put("4444", "Welcome Eric!");
        loginHash.put("5555", "Welcome Andrew!");
        loginHash.put("9999", "Welcome Guest!");
    }

    private JPanel initNorth(){
        north = new JPanel();
        north.setLayout(new BorderLayout());
        setFont = new Font("SansSerif", Font.BOLD, 40);

        passwordField = new JPasswordField();
        passwordField.setFont(setFont);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);

        north.add(passwordField);
        north.setVisible(true);
        return north;
    }

    private JPanel initCenter(){
        center = new JPanel();
        center.setLayout(new GridLayout(4,3));

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        button0.setFont(setFont);
        button1.setFont(setFont);
        button2.setFont(setFont);
        button3.setFont(setFont);
        button4.setFont(setFont);
        button5.setFont(setFont);
        button6.setFont(setFont);
        button7.setFont(setFont);
        button8.setFont(setFont);
        button9.setFont(setFont);

        button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 0);
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 1);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 2);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 3);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 4);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 5);
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 6);
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 7);
            }
        });
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 8);
            }
        });
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + 9);
            }
        });

        buttonEnter = new JButton("Enter");
        buttonClear = new JButton("Clear");

        buttonEnter.setFont(setFont);
        buttonClear.setFont(setFont);

        buttonEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String pass = passwordField.getText();
                String welcomeMessage = loginHash.get(pass);

                if(welcomeMessage != null){
                    JOptionPane.showMessageDialog(null, welcomeMessage);
                    gymInterface.enable();
                    getIconPage();
                    gymInterface.refresh(startingImage);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No user with that password can be found.");
                    passwordField.setText("");
                }
            }});

        buttonClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                passwordField.setText("");
            }});

        center.add(button1);
        center.add(button2);
        center.add(button3);
        center.add(button4);
        center.add(button5);
        center.add(button6);
        center.add(button7);
        center.add(button8);
        center.add(button9);
        center.add(buttonEnter);
        center.add(button0);
        center.add(buttonClear);
        center.setVisible(true);

        return center;
    }

    private JPanel getIconPage(){
        homeScreen = null;
        try{
            homeScreen = new ImageIcon("Images/Gym.PNG");
            System.out.println("Should have created new ImageIcon");
        }
        catch(Exception e){

        }
        startingImage = new JPanel();
        homeLabel = new JButton();
        homeLabel.setIcon(homeScreen);
        homeLabel.setEnabled(false);
        startingImage.add(homeLabel);
        return startingImage;
    }
    
    public static void main(String[] args){
    	JPanel l = new LoginPage();
    	JFrame f = new JFrame();
    	f.add(l);
    	f.setVisible(true);
    	
    }
}
