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

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;

import Model.TeamModel;

/**
 * @author Eric Majchrzak
 *
 */
public class TeamView extends JPanel{
	
	private JPanel teamPanel;
	
	public TeamView(TeamModel thisTeam){
		
		//generate title
		JPanel titlePanel = new JPanel(new GridLayout(1, 1), false);
		JLabel titleLabel = new JLabel(thisTeam.getName(), JLabel.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		//Title Border
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		titlePanel.setBorder(blueline);
		
		//generate main stats
		JPanel statPanel = new JPanel(new BorderLayout());
		JPanel statSpecificPanel = new JPanel(new GridLayout(4, 1), false);
		
		JLabel ttlPoints = new JLabel("  Total Points: " + thisTeam.getPoints());
		ttlPoints.setFont(new Font("Serif", 1, 25));
		statSpecificPanel.add(ttlPoints);
		
		JLabel nmbGames = new JLabel("  Games Played: " + thisTeam.getNumberGames());
		nmbGames.setFont(new Font("Serif", 1, 25));
		statSpecificPanel.add(nmbGames);
		
		JLabel avgPoints = new JLabel("  Average Points Per Game: " + thisTeam.getaveragePoints());
		avgPoints.setFont(new Font("Serif", 1, 25));
		statSpecificPanel.add(avgPoints);
		
		JLabel wins = new JLabel("  Total Wins: " + thisTeam.getWins());
		wins.setFont(new Font("Serif", 1, 25));
		statSpecificPanel.add(wins);
		
		statPanel.add(makeSouthBar(),BorderLayout.NORTH);
		statPanel.add(statSpecificPanel,BorderLayout.SOUTH);
		
		//generate players
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());
		
		JLabel playerMainLabel = new JLabel("Players", JLabel.CENTER);
		playerMainLabel.setFont(new Font("Serif", 1, 25));
		playerMainLabel.setBorder(blueline);
		playerPanel.add(playerMainLabel,BorderLayout.NORTH);
		
		boolean isEven = true;
		int numRows = thisTeam.getTeamSize();
		
		JPanel players = new JPanel(new GridLayout(numRows, 1), false);
		
		for(int i=0;i<numRows;i++){
			
			JLabel player1Label = new JLabel("  " + thisTeam.getPlayers().get(i));
			player1Label.setFont(new Font("Serif", 0, 18));
			players.add(player1Label);
		}
		
		playerPanel.add(players,BorderLayout.CENTER);
		
		//generate games
		JPanel games = new JPanel();
		games.setLayout(new BorderLayout());
		
		JLabel gamesMainLabel = new JLabel("Games", JLabel.CENTER);
		gamesMainLabel.setFont(new Font("Serif", 1, 25));
		gamesMainLabel.setBorder(blueline);
		games.add(gamesMainLabel,BorderLayout.NORTH);
		
		JPanel gameStats = new JPanel(new GridLayout(thisTeam.getNumberGames(), 1), false);
		
		for(int i=0;i<thisTeam.getNumberGames();i++){
			JLabel tempGame = new JLabel("  Game " + i + ": " + thisTeam.getGames().get(i).getGame());
			tempGame.setFont(new Font("Serif", 0, 18));
			gameStats.add(tempGame);
		}
		
		games.add(gameStats,BorderLayout.CENTER);
		
		//Put it all together
		teamPanel = new JPanel();
		teamPanel.setLayout(new BorderLayout());
		teamPanel.add(titlePanel,BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(games,BorderLayout.NORTH);
		
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new BorderLayout());
		secondPanel.add(playerPanel,BorderLayout.NORTH);
		secondPanel.add(bottomPanel,BorderLayout.CENTER);
		
		JPanel thirdPanel = new JPanel();
		thirdPanel.setLayout(new BorderLayout());
		thirdPanel.add(statPanel,BorderLayout.NORTH);
		thirdPanel.add(secondPanel,BorderLayout.CENTER);
		
		teamPanel.add(thirdPanel,BorderLayout.CENTER);
		
		JScrollPane x = new JScrollPane(teamPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    x.getVerticalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
	    x.getHorizontalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
	    x.setBorder(BorderFactory.createEmptyBorder());
		
		this.setLayout(new BorderLayout());
		this.add(x, BorderLayout.CENTER);
	}
	
	public JPanel makeSouthBar(){
		//Create the addGame button
		JButton addGame = new JButton("Add Game");
		addGame.setFont(new Font("Serif", 1, 25));
		addGame.setPreferredSize(new Dimension(40, 80));
								
		//Create addGame button listener
		addGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//add method call
			}
		});
		
		//Create the edit button
		JButton edit = new JButton("Edit Team");
		edit.setFont(new Font("Serif", 1, 25));
		edit.setPreferredSize(new Dimension(40, 80));
								
		//Create edit button listener
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//add method call
			}
		});
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(1,2));
		rightPanel.add(addGame);
		rightPanel.add(edit);
		return rightPanel;
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
    	JPanel myPanel = new TeamView(new TeamModel());
    	test.add(myPanel);
    	test.setMinimumSize(new Dimension(400,400));
    	test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	test.setVisible(true);
    }
}
