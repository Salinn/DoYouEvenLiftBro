/**
 * 
 */
package Model;

import java.awt.LayoutManager;
import java.util.ArrayList;

import viewGUI.GridMenuItem;

/**
 * @author Eric Majchrzak
 *
 */
public class LeagueModel {
	
	ArrayList<TeamModel> teams;
	String leagueName;
	
	public LeagueModel(String name, ArrayList<TeamModel> teams){
		this.teams = teams;
		this.leagueName = name;
		
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

}
