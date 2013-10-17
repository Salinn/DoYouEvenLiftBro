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
	
	public TeamModel(String name){
		this.teamName = name;
		
	}
	
	public GridMenuItem getMenuItem(){
		return new GridMenuItem(this,teamName);
	}

}
