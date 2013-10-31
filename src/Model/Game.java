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

	public Game(){
		opponent = "opponent";
		theirScore = 15;
		ourScore = 16;
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
}
