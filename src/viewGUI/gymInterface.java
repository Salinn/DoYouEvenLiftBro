package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import EquipmentView.Equipment;
import EquipmentView.EquipmentPanel;
import Model.LeagueModel;
import Model.TeamModel;

public class gymInterface {
	Dimension screenSize;

	private static JFrame frame;

    private static JPanel west;
    private static JPanel center;

    public JButton membership;
    public JButton classes;
    public JButton equipment;
    public JButton league;
    public JButton logo;

    private ImageIcon imgMembership;
    private ImageIcon imgSchedule;
    private ImageIcon imgEquipment;
    private ImageIcon imgLeague;
    private ImageIcon imgLogo;

    private static Originator originator;
    
    //temp for leagues
    static ArrayList<GridMenuItem> tempLeague;

	public gymInterface(){
		
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
		
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        originator = new Originator();

		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
        frame.getContentPane().setLayout(new BorderLayout(20, 20));
		frame.setBounds(65, 65, screenSize.width-70, screenSize.height-70); //This was just so I could see it in ubunutu
		frame.setResizable(true);
        frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializes the west Panel, aka the 5 main buttons
        setWestPanel();

        //Adds the 5 main buttons to the layout
        frame.add(west, BorderLayout.WEST);

    //Add function to pass JPANELS around and set that up
    }
    private void setWestPanel(){
        west = new JPanel();
        west.setLayout(new GridLayout(5,1));
        west.setVisible(true);

        
        //Creates the buttons for the panel
        membership = new JButton("Membership");
        classes = new JButton("Class");
        equipment  = new JButton("Equipment");
        league     = new JButton("League");
        logo       = new JButton();

        /*
        //Needs Images to be inserted
        //Creates images that can be inserted as objects
        imgMembership = new ImageIcon();
        imgSchedule   = new ImageIcon();
        imgEquipment  = new ImageIcon();
        imgLeague     = new ImageIcon();
        imgLogo       = new ImageIcon();
        */
        
        //Build a temp league
        ArrayList<TeamModel> tempTeam = new ArrayList<TeamModel>();
        TeamModel tempTeamModel = new TeamModel("Gruul");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Simic");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Izzet");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Orzhov");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Selesnya");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Rakdos");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Boros");
        tempTeam.add(tempTeamModel);
        tempTeamModel = new TeamModel("Golgari");
        tempTeam.add(tempTeamModel);
    	tempTeamModel = new TeamModel("Azourious");
    	tempTeam.add(tempTeamModel);
    	tempTeamModel = new TeamModel("Dimir");
    	tempTeam.add(tempTeamModel);
    	
    	//Build a temp league
        tempLeague = new ArrayList<GridMenuItem>();
        LeagueModel tempLeagueModel = new LeagueModel("Football",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Soccer",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Ping Pong",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Weight Club",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Basketball",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Dodgeball",tempTeam);
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Tennis",tempTeam);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Field Hockey",tempTeam);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Hockey",tempTeam);
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Underwater Basket Weaving",tempTeam);
    	tempLeague.add(tempLeagueModel.getMenuItem());

    	/*
        //Inserts the images objects into the correct button
        membership.setIcon(imgMembership);
        classes.setIcon(imgSchedule);
        equipment.setIcon(imgEquipment);
        league.setIcon(imgLeague);
        logo.setIcon(imgLogo);

		*/
    	Equipment equip = new Equipment("Treadmill", "1", "OBJT-01", 
        		"RM-9001");
        Equipment equip1 = new Equipment("Weight Bench", "2", "OBJT-01", 
        		"RM-9001");
        Equipment equip2 = new Equipment("Dumbbells", "3", "OBJT-01", 
        		"RM-9001");
        Equipment equip3 = new Equipment("Elliptical", "4", "OBJT-01", 
        		"RM-9001");
        Equipment equip4 = new Equipment("Stationary Bike", "5", "OBJT-01", 
        		"RM-9001");
        Equipment equip5 = new Equipment("Weight Machine", "6", "OBJT-01", 
        		"RM-9001");
        Equipment equip6 = new Equipment("Something else", "7", "OBJT-01", 
        		"RM-9001");
        final ArrayList<Equipment> equipment_list = new ArrayList<Equipment>();
        equipment_list.add(equip);
        equipment_list.add(equip1);
        equipment_list.add(equip2);
        equipment_list.add(equip3);
        equipment_list.add(equip4);
        equipment_list.add(equip5);
        equipment_list.add(equip6);
    	
    	
        //Creates all of the listeners for each button
        membership.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new memberInterface());}});
        classes.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new classInterface());}});
        equipment.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new EquipmentPanel(equipment_list));}});
        league.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new GridButtonPanel("League", tempLeague));}});
        logo.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {undo();}});

        //Adds all of the buttons to the layout
        west.add(membership);
        west.add(classes);
        west.add(equipment);
        west.add(league);
        west.add(logo);
        
        frame.revalidate();

    }
    
    public static void refresh(JPanel new_center){
        if (center != null){
            //originator.set(copyCenter());
        	Caretaker caretaker = Caretaker.getInstance();
            caretaker.addMemento(new Memento(center));
            center.removeAll();
        }
        //Initializes and empty panel in case one option is not selected
        
        //Ensures the frame  stacking up the
        center=new_center;
        frame.add(center, BorderLayout.CENTER);
        frame.revalidate();

    }
    
    
    
    private void undo(){
    	
    	//TODO Differentiate between panels because if the same button is pressed multiple times
    	//each new panel is still saved on the stack
    	Caretaker caretaker = Caretaker.getInstance();
    	Memento restored_state = caretaker.restore();
    	
    	if(restored_state != null){
    		
    		//Clear the center if necessary
    		if (center != null){
    			center.removeAll();	
    		}
    		
    		center=restored_state.getState();
            frame.add(center, BorderLayout.CENTER);
    		frame.revalidate();
    	}
    	//Otherwise do nothing
    }
    
    public static void main(String[] args) {
		gymInterface gymGUI = new gymInterface();
    }
}