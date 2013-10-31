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

	public LeagueGame(){
		opponent1 = "team 1";
		opponent2 = "team 2";
		score1 = 15;
		score2 = 16;
	}
	
	public String getGame(){
		return opponent1 + ": " + score1 + " vs. " + opponent2 + ": " + score2;
	}
	
}
