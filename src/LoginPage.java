
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LoginPage {
	//Gets the size of the screen
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Defines what frame and west are
	private JFrame frame;
	private JPanel center;
	
	public static void main(String[] args) {
		LoginPage loginGUI = new LoginPage();
		loginGUI.frame.setVisible(true);
	}
	public LoginPage(){
		initialize();
	}
	private void initialize(){
		//Creates and sets up the main frame that will be used in the program
		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
		frame.setBounds(65, 0, screenSize.width-70, screenSize.height); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new BorderLayout());
		
		//Initializes the west Panel, aka the 5 main buttons
		initializeCenter();
		
		//Frame adds panels to the correct locations
		frame.add(center);
	}
	private void initializeCenter(){
		center = new JPanel();
		center.setLayout(new GridLayout(3,4));
		center.setVisible(true);
		
		for(int i = 1; i <=9; i++){
			center.add(new JButton(""+i));
		}
		
	}
}

