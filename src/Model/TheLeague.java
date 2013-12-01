package Model;

import java.util.ArrayList;

import viewGUI.GridMenuItem;

public class TheLeague {
	
	static ArrayList<GridMenuItem> allLeagues;
	
	public TheLeague(){
		
		//Initialize Array
		allLeagues = new ArrayList<GridMenuItem>();
		
		//Populate Leagues
		ArrayList<GridMenuItem> tempLeague;

    	//Build a temp league
        tempLeague = new ArrayList<GridMenuItem>();
        
        LeagueModel tempLeagueModel = new LeagueModel("Football with Brackets",true);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Soccer",false);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Ping Pong",false);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Weight Club",false);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Basketball",false);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Dodgeball",false);
        tempLeague.add(tempLeagueModel.getMenuItem());
        
        tempLeagueModel = new LeagueModel("Tennis",false);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	
    	tempLeagueModel = new LeagueModel("Field Hockey",false);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	
    	tempLeagueModel = new LeagueModel("Hockey",false);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	
    	tempLeagueModel = new LeagueModel("Underwater Basket Weaving",false);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	
    	allLeagues = tempLeague;
    	
	}
	
	public static ArrayList<GridMenuItem> getModel(){
		return allLeagues;
	}

}
