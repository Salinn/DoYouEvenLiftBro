package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;

/**
 * This class is the grid button panel that is used to create
 * a usable touch screen interface for many of the views in our system.
 * It utilizes the GridMenuItem as it's input data structure.
 * @author Eric Majchrzak
 *
 */
public class GridButtonPanel extends JPanel {
	
	//The current page of buttons being viewed
	private int currentPage = 0;
	
	//The list of menu items
	private ArrayList<GridMenuItem> menuItems;
	
	//The list of filtered menu items that met the search qualifications
	private ArrayList<GridMenuItem> currentList;
	
	//The pane containing all of the buttons and left and right arrow buttons
	private JPanel centerPane;
	
	//The add new button
	private JButton addButton;
	
	//The search bar
	private JPanel searchBar;
	
	//The title bar
	private JPanel titlePanel;
	
	//The search text field
	private JTextField searchText;
	
	//The name of the page
	private String name;
	
	//Get screen size
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public GridButtonPanel(String mainName, ArrayList<GridMenuItem> menuItems){
		
		this.menuItems = menuItems;
		this.currentList = menuItems;
		this.name = mainName;
		
		//Create the title
		titlePanel = new JPanel(new GridLayout(1, 1), false);
		JLabel titleLabel = new JLabel(mainName, JLabel.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
		titlePanel.add(titleLabel);
		
		//Title Border
		Border blueline = BorderFactory.createLineBorder(Color.blue);
		titlePanel.setBorder(blueline);
	
		//Create the add button
		addButton = new JButton("Add New " + mainName);
		addButton.setPreferredSize(new Dimension(40, screenSize.height/18));
		
		//addButton ActionListener
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addNew();
			}
		});
		
		//Put Center Pane Together
		centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		centerPane.add(buildGridButtons(),BorderLayout.CENTER);
		centerPane.add(buildLeftButton(),BorderLayout.WEST);
		centerPane.add(buildRightButton(),BorderLayout.EAST);
		centerPane.add(addButton,BorderLayout.NORTH);
		
		//Create Search bar elements
		searchText = new JTextField();
		searchText.setFont(new Font("Serif", Font.PLAIN, 25));
		JButton searchButton = new JButton("Search");
		searchButton.setPreferredSize(new Dimension(screenSize.width/18, 40));
		
		//searchButton ActionListener
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		//Put search bar together
		searchBar = new JPanel();
		searchBar.setLayout(new BorderLayout());
		searchBar.add(searchText,BorderLayout.CENTER);
		searchBar.add(searchButton,BorderLayout.EAST);
		searchBar.setPreferredSize(new Dimension(40, screenSize.height/18));
		
		
		//Add panels to the window
		this.setLayout(new BorderLayout());
		this.add(titlePanel,BorderLayout.NORTH);
		this.add(centerPane,BorderLayout.CENTER);
		this.add(searchBar,BorderLayout.SOUTH);

	}
	
	/**
	 * This function will be called when the left arrow 
	 * button is pressed.
	 */
	private void leftButtonPressed(){
		this.currentPage--;
		refresh();
	}
	
	/**
	 * This function will be called when the right arrow 
	 * button is pressed.
	 */
	private void rightButtonPressed(){
		this.currentPage++;
		refresh();
	}
	
	/**
	 * This function will be called to build the grid of
	 * buttons that represent the objects that the menu is
	 * displaying.
	 * @return a 3 by 3 grid view of buttons
	 */
	private JPanel buildGridButtons(){
		//Create the grid
		JPanel newGridPanel = new JPanel(new GridLayout(3, 3, 0, 0), false);
				
		//Add buttons to the grid
		for(int i = (9 * currentPage); i < (9 * currentPage + 9); i++){
			if(i < currentList.size()){
				newGridPanel.add(currentList.get(i).getButton());
				
			//Keep the grid buttons sized correctly
			} else {
				JButton temp = new JButton();
				temp.setVisible(false);
				newGridPanel.add(temp);
			}
		}
		
		return newGridPanel;
	}
	
	/**
	 * This function will build the right button. The right
	 * button will be grayed out if there is no more objects to display
	 * @return the right page button
	 */
	private JButton buildRightButton(){
		//Create the right button
		JButton rightButton = new JButton(">");
		rightButton.setPreferredSize(new Dimension(screenSize.width/18, 40));
					
		//leftButton ActionListener
		rightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					rightButtonPressed();
				}
			});
						
		//Gray right Button if needed
		if(currentPage + 1 >= currentList.size()/9){
			rightButton.setEnabled(false);
		}
		return rightButton;
	}
	
	/**
	 * This function will build the right button. The right
	 * button will be grayed out if there is no more objects to display
	 * @return the left page button
	 */
	private JButton buildLeftButton(){
		//Create the left button
		JButton leftButton = new JButton("<");
		leftButton.setPreferredSize(new Dimension(screenSize.width/18, 40));
				
		//leftButton ActionListener
		leftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				leftButtonPressed();
			}
		      });
				
		//Gray left Button if needed
		if(currentPage == 0){
			leftButton.setEnabled(false);
		}
		return leftButton;
	}
	
	/**
	 * This function will search the list of GridMenuItems for items
	 * that share text with the text in the search bar. It will then
	 * update the window with the new list.
	 */
	private void search() {
		ArrayList<GridMenuItem> newList = new ArrayList<GridMenuItem>();
		String text = searchText.getText();
		
		for(int i=0;i<menuItems.size();i++){
			if(menuItems.get(i).searchName(text)){
				newList.add(menuItems.get(i));
			}
		}
		
		currentList = newList;
		currentPage = 0;
		refresh();
		
	}
	
	/**
	 * The addNew() function is called whenever the add new button is
	 * pressed and has yet to be implemented. For now it just refreshes
	 * the panel.
	 */
	private void addNew(){
		refresh();
	}
	
	/**
	 * This is the refresh function. It is used to reload the active
	 * grid button page. It is primarily used in the button functions
	 * and the search function.
	 */
	private void refresh(){
		//build new center pane
		centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		centerPane.add(buildGridButtons(),BorderLayout.CENTER);
		centerPane.add(buildLeftButton(),BorderLayout.WEST);
		centerPane.add(buildRightButton(),BorderLayout.EAST);
		centerPane.add(addButton,BorderLayout.NORTH);
		this.removeAll();
		
		//Add panels to the window
		this.setLayout(new BorderLayout());
		this.add(titlePanel,BorderLayout.NORTH);
		this.add(centerPane,BorderLayout.CENTER);
		this.add(searchBar,BorderLayout.SOUTH);
		
		this.revalidate();
	}
	
	/**
	 * main method used to test the screen
	 * to be removed once finalized.
	 * @param args
	 */
    public static void main(String [] args){
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
    	
    	ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();
    	testList.add(new GridMenuItem(null,"Team Applesauce"));
    	testList.add(new GridMenuItem(null,"Team Knightmare"));
    	testList.add(new GridMenuItem(null,"Team Fight Club"));
    	testList.add(new GridMenuItem(null,"Team Muffins"));
    	testList.add(new GridMenuItem(null,"Bruce Cambell"));
    	testList.add(new GridMenuItem(null,"Team Bangarang"));
    	testList.add(new GridMenuItem(null,"Fort Knox"));
    	testList.add(new GridMenuItem(null,"Rock Raiders"));
    	testList.add(new GridMenuItem(null,"The A Team"));
    	testList.add(new GridMenuItem(null,"Team Ownage"));
    	testList.add(new GridMenuItem(null,"USA"));
    	testList.add(new GridMenuItem(null,"Gruul"));
    	testList.add(new GridMenuItem(null,"Simic"));
    	testList.add(new GridMenuItem(null,"Izzet"));
    	testList.add(new GridMenuItem(null,"Orzhov"));
    	testList.add(new GridMenuItem(null,"Selesnya"));
    	testList.add(new GridMenuItem(null,"Rakdos"));
    	testList.add(new GridMenuItem(null,"Boros"));
    	testList.add(new GridMenuItem(null,"Golgari"));
    	testList.add(new GridMenuItem(null,"Azourious"));
    	testList.add(new GridMenuItem(null,"Dimir"));
    	
    	JFrame test = new JFrame();
    	test.add(new GridButtonPanel("Team",testList));
    	test.setLocationRelativeTo(null);
    	test.setMinimumSize(new Dimension(800,800));
    	test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	test.setVisible(true);
    }
}