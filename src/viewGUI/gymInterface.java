package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gymInterface {
	//Gets the size of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Defines what frame and west are
	private JFrame frame;
    private JPanel westPanel;
    private JPanel west;
    private JPanel centerFrame;

    public JButton membership;
    public JButton schedule;
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
		gymGUI.frame.setVisible(true);
	}
	public gymInterface(){
		//Creates and sets up the main frame that will be used in the program
		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
        frame.getContentPane().setLayout(new BorderLayout(20, 20));
		frame.setBounds(65, 65, screenSize.width-70, screenSize.height-70); //This was just so I could see it in ubunutu
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializes the west Panel, aka the 5 main buttons
        westPanel = setWestPanel();

        frame.add(westPanel, BorderLayout.WEST);
        //frame.add(centerFrame, BorderLayout.CENTER);

    //Add function to pass JPANELS around and set that up
    }
    public JPanel setWestPanel(){
        //Creates the panel layout, which is a vertical grid layout
        west = new JPanel();
        west.setLayout(new GridLayout(5,1));
        west.setVisible(true);

        //Creates the buttons for the panel
        membership = new JButton("Membership");
        schedule   = new JButton("Schedule");
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
        schedule.setIcon(imgSchedule);
        equipment.setIcon(imgEquipment);
        league.setIcon(imgLeague);
        logo.setIcon(imgLogo);

        membership.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(0);
            }
        });
        schedule.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(1);
            }
        });
        equipment.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(2);
            }
        });
        league.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(3);
            }
        });
        logo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(4);
            }
        });

        //Adds all of the buttons to the layout
        west.add(membership);
        west.add(schedule);
        west.add(equipment);
        west.add(league);
        west.add(logo);

        return west;
    }
    public void refresh(Integer buttonName){
        centerFrame = new JPanel();
        frame.remove(centerFrame);
        switch (buttonName) {
            case 0:
                memberInterface newCenter = new memberInterface();
                centerFrame = newCenter.getPanel();
                break;
            case 1:
                classInterface newCenter1 = new classInterface();
                centerFrame = newCenter1;
                break;
            case 2:
                //centerFrame = newCenter2;
                break;
            case 3:
                LeagueMain newCenter3 = new LeagueMain("League");
                centerFrame = newCenter3;
                break;
            case 4:

                break;
        }
        frame.add(centerFrame, BorderLayout.CENTER);
        frame.revalidate();
        //repaint();
    }
}