/**
 * 
 */
package Model;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.UIManager;

import viewGUI.BracketsPage;
import viewGUI.GridMenuItem;


/**
 * @author Eric Majchrzak
 *
 */
public class LeagueModel {
	
	private ArrayList<TeamModel> teams = populateLeague();
	private ArrayList<LeagueGame> games = populateGames();
	private String leagueName;
	private boolean isBracket;
	private BracketsPage leagueBracket;
	
	public LeagueModel(String name,boolean bracketMode){
		this.leagueName = name;
		
		isBracket = bracketMode;
		
		if(isBracket){
			leagueBracket = new BracketsPage();
			leagueBracket.setTeams(teams);
		} else {
			leagueBracket = null;
		}
		
	}

	public String getName() {
		return leagueName;
	}
	
	public GridMenuItem getMenuItem(){
		return new GridMenuItem(this,leagueName);
	}
	
	public ArrayList<GridMenuItem> getTeams(){
		ArrayList<GridMenuItem> temp = new ArrayList<GridMenuItem>();
		for(int i=0;i<teams.size();i++){
			temp.add(teams.get(i).getMenuItem());
		}
		return temp;
	}
	
	public String highScore(){
		int tmpScore = 0;
		String tmpName = "No one";
		for(int i=0; i<teams.size();i++){
			if(teams.get(i).getWins() > tmpScore){
				tmpName = teams.get(i).getName();
				tmpScore = teams.get(i).getWins();
			}
		}
		return tmpName;
	}
	
	public boolean bracket(){
		return isBracket;
	}
	
	public ArrayList<TeamModel> getTeamModels(){
		return teams;
	}
	
	private ArrayList<TeamModel> populateLeague(){
		//Build a temp league
        ArrayList<TeamModel> tempTeam = new ArrayList<TeamModel>();
        TeamModel tempTeamModel = new TeamModel("Gruul");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Simic");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Izzet");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Orzhov");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Selesnya");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Rakdos");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Boros");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Golgari");
        tempTeam.add(tempTeamModel);
    	tempTeamModel = new TeamModel("Azourious");
    	tempTeam.add(tempTeamModel);
    	tempTeamModel = new TeamModel("Dimir");
    	tempTeam.add(tempTeamModel);
    	
    	return tempTeam;
	}
	
	private ArrayList<LeagueGame> populateGames(){
		//Games
		ArrayList<LeagueGame> tempGames = new ArrayList<LeagueGame>();
		
		Random generator = new Random();
		
		for(int i=0;i<100;i++){
			TeamModel team1 = teams.get(generator.nextInt( teams.size() ));
			int team1Score = generator.nextInt(50);
		
			TeamModel team2 = teams.get(generator.nextInt( teams.size() ));
			int team2Score = generator.nextInt(50);
		
			if(!team1.getName().equals(team2.getName())){
				LeagueGame temp = new LeagueGame(team1,team1Score,team2,team2Score);
				tempGames.add(temp);
			}
		}
		
		return tempGames;
	}

	public int getNumberGames() {
		return games.size();
	}

	public ArrayList<LeagueGame> getGames() {
		return games;
	}
	
	public BracketsPage getBracketsPage(){
		return leagueBracket;
	}

}
