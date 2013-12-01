/**
 * 
 */
package Model;

/**
 * @author Eric Majchrzak
 *
 */
public class Game {
	
	String opponent;
	int theirScore;
	int ourScore;

	public Game(TeamModel enemy, int myScore, int theirScore){
		opponent = enemy.getName();
		this.theirScore = theirScore;
		ourScore = myScore;
	}
	
	public String getGame(){
		return ourScore + " to " + theirScore + " vs. " + opponent;
	}
	
	public boolean won(){
		if(ourScore > theirScore){
			return true;
		}
		return false;
	}

	public int getPoints() {
		return ourScore;
	}
}
