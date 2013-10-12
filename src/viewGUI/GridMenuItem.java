package viewGUI;

import javax.swing.*;

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
	 * This function returns an button representation of the object
	 * @return
	 */
	public JButton getButton(){
		//Create Button
		JButton button = new JButton(name);
		
		//Create Listener
		
		
		return button;
	}

}
