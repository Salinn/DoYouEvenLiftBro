import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class gymInterface {
	//Gets the size of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Defines what frame and west are
	private JFrame frame;
	private JPanel west;
	
	public static void main(String[] args) {
		gymInterface gymGUI = new gymInterface();
		gymGUI.frame.setVisible(true);
	}
	public gymInterface(){
		initialize();
	}
	private void initialize(){
		//Creates and sets up the main frame that will be used in the program
		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
		frame.setBounds(65, 0, screenSize.width-70, screenSize.height); //This was just so I could see it in ubunutu
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(5, 5));
		
		//Initializes the west Panel, aka the 5 main buttons
		initializeWest();
		
		//Frame adds panels to the correct locations
		frame.add(west,BorderLayout.WEST);
	}
	private void initializeWest(){
		west = new JPanel();
		west.setLayout(new GridLayout(5,1));
		west.setVisible(true);
		
		JButton membership = new JButton("Membership");
		JButton schedule   = new JButton("Schedule");
		JButton equipment  = new JButton("Equipment");
		JButton league     = new JButton("League");
		JButton logo       = new JButton();
		
		//Needs Images to be inserted
		ImageIcon imgMembership = new ImageIcon();
		ImageIcon imgSchedule   = new ImageIcon();
		ImageIcon imgEquipment  = new ImageIcon();
		ImageIcon imgLeague     = new ImageIcon();
		ImageIcon imgLogo       = new ImageIcon();
		
		membership.setIcon(imgMembership);
		schedule.setIcon(imgSchedule);
		equipment.setIcon(imgEquipment);
		league.setIcon(imgLeague);
		logo.setIcon(imgLogo);
		
		
		west.add(membership);
		west.add(schedule);
		west.add(equipment);
		west.add(league);
		west.add(logo);
	}

}
