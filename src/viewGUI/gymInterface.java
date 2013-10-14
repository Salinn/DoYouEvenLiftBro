package viewGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class gymInterface {
	//Gets the size of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Defines what frame and west are
	private JFrame frame;
	
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
        panelInterface westPanel = new panelInterface();

        //Initialize the member
        //memberInterface centerFrame = new memberInterface();
        editMembers centerFrame = new editMembers();
        //newMembershipType centerFrame = new newMembershipType();

		//Frame adds the west panel to the correct location
        frame.add(westPanel.getPanel(), BorderLayout.WEST);
        frame.add(centerFrame.getPanel(), BorderLayout.CENTER);
	}

}
