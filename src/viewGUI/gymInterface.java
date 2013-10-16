package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gymInterface {
	Dimension screenSize;

	private JFrame frame;

    private JPanel west;
    private JPanel center;

    public JButton membership;
    public JButton classes;
    public JButton equipment;
    public JButton league;
    public JButton logo;

    private ImageIcon imgMembership;
    private ImageIcon imgSchedule;
    private ImageIcon imgEquipment;
    private ImageIcon imgLeague;
    private ImageIcon imgLogo;
	
	public static void main(String[] args) {
		gymInterface gymGUI = new gymInterface();
	}
	public gymInterface(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
        frame.getContentPane().setLayout(new BorderLayout(20, 20));
		frame.setBounds(65, 65, screenSize.width-70, screenSize.height-70); //This was just so I could see it in ubunutu
		frame.setResizable(true);
        frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializes the west Panel, aka the 5 main buttons
        west = setWestPanel();

        //Adds the 5 main buttons to the layout
        frame.add(west, BorderLayout.WEST);

    //Add function to pass JPANELS around and set that up
    }
    public JPanel setWestPanel(){
        west = new JPanel();
        west.setLayout(new GridLayout(5,1));
        west.setVisible(true);

        //Creates the buttons for the panel
        membership = new JButton("Membership");
        classes = new JButton("Class");
        equipment  = new JButton("Equipment");
        league     = new JButton("League");
        logo       = new JButton();

        //Needs Images to be inserted
        //Creates images that can be inserted as objects
        imgMembership = new ImageIcon();
        imgSchedule   = new ImageIcon();
        imgEquipment  = new ImageIcon();
        imgLeague     = new ImageIcon();
        imgLogo       = new ImageIcon();

        //Inserts the images objects into the correct button
        membership.setIcon(imgMembership);
        classes.setIcon(imgSchedule);
        equipment.setIcon(imgEquipment);
        league.setIcon(imgLeague);
        logo.setIcon(imgLogo);

        //Creates all of the listeners for each button
        membership.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(0);}});
        classes.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(1);}});
        equipment.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(2);}});
        league.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(3);}});
        logo.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(4);}});

        //Adds all of the buttons to the layout
        west.add(membership);
        west.add(classes);
        west.add(equipment);
        west.add(league);
        west.add(logo);

        return west;
    }
    public void refresh(Integer buttonName){
        //Initializes and empty panel in case one option is not selected
        center= new JPanel();

        //Ensures the frame  stacking up the
        frame.remove(center);

        //Chooses the correct JPanel to display based on the button pressed
        switch (buttonName) {
            case 0:
                center = new memberInterface();
                break;
            case 1:
                center = new classInterface();
                break;
            case 2:
                //center = new equipment();
                break;
            case 3:
                center = new LeagueMain("League");
                break;
            case 4:
                //memento go back
                break;
        }
        frame.add(center, BorderLayout.CENTER);
        frame.revalidate();
        //repaint();
    }
}