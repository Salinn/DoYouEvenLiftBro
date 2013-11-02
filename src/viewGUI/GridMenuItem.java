package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.LeagueModel;
import Model.TeamModel;

/**
 * This class is a generic data structure that can be used to make
 * all data structures that need to use the grid button panel.
 * @author Eric Majchrzak
 *
 */
public class GridMenuItem {
	
	//The object the menu item is representing
	private Object target;
	
	//The name of the Object
	private String name;
	
	//Button of object
	JButton button;
	
	//temp league page
	LeagueMain tempLeaguePage;
	
	//Image of the object
	
	/**
	 * This is the basic constructor that takes in any object and the
	 * objects name. It is solely a test constructor.
	 * @param target
	 * @param name
	 */
	public GridMenuItem(Object target, String name){
		this.name = name;
		this.target = target;
		
		//Insert button generation Methods here
		if(target instanceof LeagueModel){
			createLeagueButton((LeagueModel)target);
		} else if(target instanceof TeamModel){
			createTeamButton((TeamModel) target);
		} else if(target instanceof JPanel) {
            createdMembershipOptionButton();
        } else {
			createButton(target);
		}
	}

	/**
	 * This text is used by the GridMenuItem to find items the user
	 * searched for.
	 * @param searchText
	 * @return
	 */
	public boolean searchName(String searchText){
		return name.toUpperCase().contains(searchText.toUpperCase());
	}
	
	/**
	 * Create a league button
	 * @return JButton
	 */
	public JButton createLeagueButton(final LeagueModel target){
		//Create Button
		button = new JButton(name);
		
		//Create Listener
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempLeaguePage = new LeagueMain(target.getName(),target);
				gymInterface.refresh(tempLeaguePage);
			}
		});
		return button;
	}
	
	/**
	 * Create a Team button
	 * @return JButton
	 */
	public JButton createTeamButton(final TeamModel target){
		//Create Button
		button = new JButton(name);
		
		//Create Listener
		//Generate Screen
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel tmp = new TeamView(target);
				gymInterface.refresh(tmp);
			}
		});
		return button;
	}

    public JButton createdMembershipOptionButton(){
        button = new JButton(name);
        final JPanel temp = (JPanel) target;
        System.out.println("CREDIT CARE!!!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(temp.getLayout());
                for(int i = 0; i < temp.getComponentCount(); i++){
                    Component comp = temp.getComponent(i);

                }
                gymInterface.refresh(temp);
            }
        });
        return button;
    }
	
	/**
	 * This function returns an button representation of the object
	 * @return
	 */
	 
	public JButton createButton(Object target){
		//Create Button
		button = new JButton(name);
		return button;
	}
	
	/**
	 * This function returns an button representation of the object
	 * @return
	 */
	public JButton getButton(){
		return button;
	}

}
