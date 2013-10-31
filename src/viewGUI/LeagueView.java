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

import Model.LeagueModel;
import Model.TeamModel;

/**
 * @author Eric Majchrzak
 *
 */
public class LeagueView extends JPanel{
	
	public LeagueView(LeagueModel thisLeague){
		
		//generate title
		JPanel titlePanel = new JPanel(new GridLayout(1, 1), false);
		JLabel titleLabel = new JLabel(thisLeague.getName(), JLabel.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		//Title Border
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		titlePanel.setBorder(blueline);
		
		//generate main stats
		JPanel statPanel = new JPanel(new BorderLayout());
		JPanel statSpecificPanel = new JPanel(new GridLayout(1, 2), false);
		

		JLabel winning = new JLabel("Point Leader: " + thisLeague.highScore());
		//ttlPoints.setFont(new Font("Serif", Font.BOLD, 25));
		statSpecificPanel.add(winning);
		
		JLabel nmbTeams = new JLabel("Number of Teams: " + thisLeague.getTeams().size());
		//nmbGames.setFont(new Font("Serif", Font.BOLD, 25));
		statSpecificPanel.add(nmbTeams);
		
		statPanel.add(makeSouthBar(thisLeague.bracket()),BorderLayout.NORTH);
		statPanel.add(statSpecificPanel,BorderLayout.SOUTH);
		
		//generate teams
		JPanel teamPanel = new JPanel();
		teamPanel.setLayout(new BorderLayout());
		
		JLabel teamMainLabel = new JLabel("Teams", JLabel.CENTER);
		teamMainLabel.setBorder(blueline);
		teamPanel.add(teamMainLabel,BorderLayout.NORTH);
		
		boolean isEven = true;
		int numRows = thisLeague.getTeamModels().size() / 2;
		if(thisLeague.getTeams().size()%2 == 1){
			isEven = false;
			numRows++;
		}
		
		JPanel players = new JPanel(new GridLayout(numRows, 2), false);
		
		for(int i=0;i<numRows;i++){
			int roundCount = 2*i;
			
			TeamModel team1 = thisLeague.getTeamModels().get(roundCount);
			JLabel team1Label = new JLabel(team1.getName() + " wins: " + team1.getWins());
			players.add(team1Label);
			
			if(!((i==numRows-1) && (!isEven))){
				team1 = thisLeague.getTeamModels().get(roundCount);
				team1Label = new JLabel(team1.getName() + " wins: " + team1.getWins());
				players.add(team1Label);
			}
		}
		
		teamPanel.add(players,BorderLayout.CENTER);
		
		//generate games
		JPanel games = new JPanel();
		games.setLayout(new BorderLayout());
		
		JLabel gamesMainLabel = new JLabel("Games", JLabel.CENTER);
		gamesMainLabel.setBorder(blueline);
		games.add(gamesMainLabel,BorderLayout.NORTH);
		
		JPanel gameStats = new JPanel(new GridLayout(thisLeague.getNumberGames(), 2), false);
		
		for(int i=0;i<thisLeague.getNumberGames();i++){
			JLabel tempGame = new JLabel("Game " + i + ": " + thisLeague.getGames().get(i).getGame(), JLabel.CENTER);
			gameStats.add(tempGame);
		}
		
		games.add(gameStats,BorderLayout.CENTER);
		
		//Put it all together
		JPanel leaguePanel = new JPanel();
		leaguePanel.setLayout(new BorderLayout());
		leaguePanel.add(titlePanel,BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(games,BorderLayout.NORTH);
		
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new BorderLayout());
		secondPanel.add(teamPanel,BorderLayout.NORTH);
		secondPanel.add(bottomPanel,BorderLayout.CENTER);
		
		JPanel thirdPanel = new JPanel();
		thirdPanel.setLayout(new BorderLayout());
		thirdPanel.add(statPanel,BorderLayout.NORTH);
		thirdPanel.add(secondPanel,BorderLayout.CENTER);
		
		leaguePanel.add(thirdPanel,BorderLayout.CENTER);
		
		JScrollPane x = new JScrollPane(leaguePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    x.getVerticalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
	    x.getHorizontalScrollBar().setPreferredSize(new Dimension(50, Integer.MAX_VALUE));
	    x.setBorder(BorderFactory.createEmptyBorder());
		
		this.setLayout(new BorderLayout());
		this.add(x, BorderLayout.CENTER);
	}
	
	public JPanel makeSouthBar(boolean bracket){
		JButton addGame;
		if(bracket){
			//Create the bracket button
			addGame = new JButton("Bracket");
			addGame.setPreferredSize(new Dimension(40, 80));
									
			//Create bracket button listener
			addGame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//add method call
				}
			});
		} else {
		
			//Create the addGame button
			addGame = new JButton("Add Game");
			addGame.setPreferredSize(new Dimension(40, 80));
								
			//Create addGame button listener
			addGame.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					//add method call
				}
			});
		}
		
		//Create the edit button
		JButton edit = new JButton("Edit League");
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
    	JPanel myPanel = new LeagueView(new LeagueModel("Test"));
    	test.add(myPanel);
    	test.setMinimumSize(new Dimension(400,400));
    	test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	test.setVisible(true);
    }
}
