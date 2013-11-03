package viewGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.TeamModel;


public class BracketButton extends JButton {
	
	private TeamModel team;
	private BracketButton inBracketWith;
	private BracketButton nextBracket;
	private boolean recordedGame;
	
	public BracketButton(BracketButton inBracket){
		super("TBD");
		recordedGame = false;
		inBracketWith = inBracket;
		this.addActionListener(recordWin);
	}
	
	//Team should be team object. Temporarily a string
	//When clicking on this button, the button will record win losses and change color
	public BracketButton(TeamModel Team, BracketButton inBracket){
		super(Team.getName());
		team = Team;
		inBracketWith = inBracket;
		recordedGame = false;
		this.addActionListener(recordWin);
	}
	
	public BracketButton(TeamModel Team){
		super(Team.getName());
		team = Team;
		recordedGame = false;
		this.addActionListener(recordWin);
	}
	
	public BracketButton(){
		super("TBD");
		recordedGame = false;
		this.addActionListener(recordWin);
	}

	private ActionListener recordWin = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			if(getTeam() !=null && !recordedGame && inBracketWith!=null)
			{
				//record team stats here
				//create momento for back button?
				if(inBracketWith.getTeam()!=null){
					setBackground(Color.GREEN);
					inBracketWith.setBackground(Color.RED);
					inBracketWith.setRecordedGame();
					recordedGame = true;
					if(nextBracket != null){
						nextBracket.setTeam(getTeam());
						nextBracket.setText(team.getName());
					}
				}else{
					System.out.println("Other Team was null");
				}
				
			}
			System.out.println("Button Press");	
		}
		
	};
	
	public TeamModel getTeam(){
		return team;
	}
	
	public void setBracketButton(BracketButton but){
		inBracketWith = but;
	}
	
	public void setNextBracketButton(BracketButton next){
		nextBracket = next;
	}

	public void setTeam(TeamModel Team){
		team = Team;
		this.setText(team.getName());
		
		this.validate();
		this.repaint();
	}
	
	public void setRecordedGame(){
		recordedGame = true;
	}
}
