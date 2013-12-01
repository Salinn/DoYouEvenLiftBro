/**
 * 
 */
package Model;

import java.util.ArrayList;

import viewGUI.GridMenuItem;

/**
 * @author Eric Majchrzak
 *
 */
public class TeamModel {
	
	String teamName;
	ArrayList<String> teamMembers;
	ArrayList<Game> gamesPlayed;
	int totalPoints;
	
	public TeamModel(String name){
		this.teamName = name;
		//players
		teamMembers = new ArrayList<String>();
		teamMembers.add("Georgia Lass");
		teamMembers.add("Chuck Finnly");
		teamMembers.add("Chaos Theory");
		teamMembers.add("Eren Jager");
		teamMembers.add("Suzaku Kururugi");
		teamMembers.add("Ovan");
		teamMembers.add("Udesky Sarris");
		teamMembers.add("Malcolm Reynolds");
		teamMembers.add("Han Solo");
		teamMembers.add("Jeffrey Winger");
		teamMembers.add("Bilbo Baggins");
		teamMembers.add("Wesley Snipes");
		teamMembers.add("Link");
		teamMembers.add("Sock");
		teamMembers.add("Doran");
				
		//Games
		gamesPlayed = new ArrayList<Game>();
				
		//totalPoints
		totalPoints = 0;
	}
	
	public TeamModel(){
		//name
		this.teamName = "TEST";
		
		//players
		teamMembers = new ArrayList<String>();
		teamMembers.add("Test 1");
		teamMembers.add("Test 2");
		teamMembers.add("Test 3");
		teamMembers.add("Test 4");
		teamMembers.add("Test 5");
		teamMembers.add("Test 6");
		teamMembers.add("Test 7");
		teamMembers.add("Test 8");
		teamMembers.add("Test 9");
		teamMembers.add("Test 10");
		teamMembers.add("Test 11");
		teamMembers.add("Test 12");
		teamMembers.add("Test 13");
		teamMembers.add("Test 14");
		teamMembers.add("Test 15");
		
		//Games
		gamesPlayed = new ArrayList<Game>();
		
		//totalPoints
		totalPoints = 0;
		
	}
	
	public String getName(){
		return teamName;
	}
	
	public GridMenuItem getMenuItem(){
		return new GridMenuItem(this,teamName);
	}
	
	public ArrayList<String> getPlayers(){
		return teamMembers;
	}
	
	public int getPoints(){
		int tempScore = 0;
		for(int i=0;i<gamesPlayed.size();i++){
			tempScore+=gamesPlayed.get(i).ourScore;
		}
		totalPoints = tempScore;
		return totalPoints;
	}
	
	public int getNumberGames(){
		return gamesPlayed.size();
	}
	
	public int getTeamSize(){
		return teamMembers.size();
	}
	
	public double getaveragePoints(){
		return totalPoints/gamesPlayed.size();
	}
	
	public ArrayList<Game> getGames(){
		return gamesPlayed;
	}
	
	public void addGame(Game thisGame){
		gamesPlayed.add(thisGame);
		totalPoints += thisGame.getPoints();
	}
	
	public int getWins(){
		int wins = 0;
		for(int i=0; i<gamesPlayed.size();i++){
			if(gamesPlayed.get(i).won())
				wins++;
		}
		return wins;
	}

}
