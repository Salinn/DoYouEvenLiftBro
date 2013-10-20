/**
 * 
 */
package viewGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import Model.LeagueModel;

/**
 * This class represents the page that the user will be brought to if they
 * tap on a specific league. It has 4 major buttons.
 * -Teams will take the user to a GridButtonView of all of the teams in
 * 	the league
 * -Stats will take the user to the stat page view of the league
 * -Add Game will bring up a pop-up that allows the user to select 2 teams,
 * 	the number of points each team scored and select which team won. They
 * 	can then add that game to the league.
 * -Edit is a manager function that will allow the manager to delete and
 * 	modify sensitive league information.
 * @author Eric Majchrzak
 */
public class LeagueMain extends JPanel {

	LeagueModel league;
	
	GridButtonPanel tempTeamsMenu;
	
	public LeagueMain(String mainName,LeagueModel league){
		
		this.league = league;
		
		//Create the title
		JPanel titlePanel = new JPanel(new GridLayout(1, 1), false);
		JLabel titleLabel = new JLabel(mainName, JLabel.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		//Title Border
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		titlePanel.setBorder(blueline);
		
		//Create the teams button
		JButton teams = new JButton();
		StretchIcon teamsIcn = new StretchIcon("Images/teamsIcn.jpg");
		teams.setIcon(teamsIcn);
		
		//Create teams button listener
		tempTeamsMenu = new GridButtonPanel(mainName,league.getTeams());
		teams.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gymInterface.refresh(tempTeamsMenu);
			}
		});
		
		//Create the stats button
		JButton stats = new JButton();
		StretchIcon statsIcn = new StretchIcon("Images/statsIcn.jpg");
		stats.setIcon(statsIcn);
				
		//Create stats button listener
		stats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//add method call
			}
		});
		
		//Create the addGame button
		JButton addGame = new JButton();
		StretchIcon addGameIcn = new StretchIcon("Images/addGameIcn.jpg");
		addGame.setIcon(addGameIcn);
						
		//Create addGame button listener
		addGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//add method call
			}
		});
		
		//Create the edit button
		JButton edit = new JButton();
		StretchIcon editIcn = new StretchIcon("Images/editIcn.png");
		edit.setIcon(editIcn);
								
		//Create edit button listener
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//add method call
			}
		});
		
		//Create and populate the grid panel
		JPanel gridPanel = new JPanel(new GridLayout(2, 2, 0, 0), false);
		gridPanel.add(teams);
		gridPanel.add(stats);
		gridPanel.add(addGame);
		gridPanel.add(edit);
		
		//Create the panel
		this.setLayout(new BorderLayout());
		this.add(titlePanel,BorderLayout.NORTH);
		this.add(gridPanel,BorderLayout.CENTER);
	}
	
	/**
	 * main method used to test the screen
	 * to be removed once finalized.
	 * @param args
	 */
    public static void main(String [] args){
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
    	
    	JFrame test = new JFrame();
    	test.add(new LeagueMain("League",null));
    	test.setMinimumSize(new Dimension(800,800));
    	test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	test.setVisible(true);
    }
}
