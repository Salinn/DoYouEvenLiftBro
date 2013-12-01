/**
 * 
 */
package Model;

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
	
}
