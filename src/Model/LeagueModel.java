/**
 * 
 */
package Model;

import java.awt.LayoutManager;
import java.util.ArrayList;

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
	
	public LeagueModel(String name){
		this.leagueName = name;
		leagueBracket = new BracketsPage();
		leagueBracket.setTeams(teams);
		
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
		//return isBracket;
		return true;
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
		LeagueGame temp = new LeagueGame();
		
		for(int i=0;i<100;i++){
			tempGames.add(temp);
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
