/**
 * 
 */
package Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.media.sound.Toolkit;

/**
 * @author Eric Majchrzak
 *
 */
public class LeagueGame {
	String opponent1;
	String opponent2;
	int score1;
	int score2;

	public LeagueGame(TeamModel team1,int score1,TeamModel team2,int score2){
		opponent1 = team1.getName();
		opponent2 = team2.getName();
		this.score1 = score1;
		this.score2 = score2;
		
		Game team2Game = new Game(team1,score2,score1);
		team2.addGame(team2Game);
		
		Game team1Game = new Game(team2,score1,score2);
		team1.addGame(team1Game);
	}
	
	public String getGame(){
		return opponent1 + ": " + score1 + " vs. " + opponent2 + ": " + score2;
	}
	
	public static void popUpGame(final LeagueModel thisLeague){
		final JFrame gameDialog = new JFrame();
		
		String[] teamNames = new String[thisLeague.getTeamModels().size() + 1];
		
		//generate array of Strings
		for(int i=1;i<teamNames.length;i++){
			teamNames[i] = thisLeague.getTeamModels().get(i-1).getName();
		}
		
		teamNames[0] = "Team Name";
		
		final JComboBox teamBox1 = new JComboBox(teamNames);
		final JTextField team1Score = new JTextField("Score");
		team1Score.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                team1Score.setText("");
            }
        });
		
		final JComboBox teamBox2 = new JComboBox(teamNames);
		final JTextField team2Score = new JTextField("Score");
		team2Score.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                team2Score.setText("");
            }
        });
		
		JLabel versus = new JLabel("Vs.");
		
		JButton addGame = new JButton("Add Game");
		
		//Create addGame button listener
		addGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(((String)teamBox1.getSelectedItem()).equals((String)teamBox2.getSelectedItem())){
					
				} else if(((String)teamBox1.getSelectedItem()).equals("Team Name") || ((String)teamBox2.getSelectedItem()).equals("Team Name")){
					
				} else if(isNumeric(team1Score.getText())&&isNumeric(team2Score.getText())){
					thisLeague.addGame((String)teamBox1.getSelectedItem(),(String)teamBox2.getSelectedItem(),Integer.parseInt((String)team1Score.getText()),Integer.parseInt((String)team2Score.getText()));
					gameDialog.dispose();
				}
			}
		});
		
		JButton cancel = new JButton("Cancel");
		
		//Create addGame button listener
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		
				gameDialog.dispose();
			}
		});
		
		JPanel gameInfo = new JPanel();
		gameInfo.setLayout(new GridLayout(1,5));
		gameInfo.add(teamBox1);
		gameInfo.add(team1Score);
		gameInfo.add(versus);
		gameInfo.add(teamBox2);
		gameInfo.add(team2Score);
		
		JPanel gameButtons = new JPanel();
		gameInfo.setLayout(new GridLayout(1,2));
		gameButtons.add(addGame);
		gameButtons.add(cancel);
		
		gameDialog.setLayout(new BorderLayout());
		
		gameDialog.add(gameInfo,BorderLayout.CENTER);
		gameDialog.add(gameButtons,BorderLayout.SOUTH);
		gameDialog.setSize(1000, 150);
		gameDialog.setLocationRelativeTo(null);
		gameDialog.setVisible(true);
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Integer d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
