package viewGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import EquipmentView.EquipmentPanel;
import Model.*;

import java.util.Collections;

public class gymInterface {
    private GymMediatorModel theMediator;
    private ClassesModel theClassesHolder;
    private AccessToMembers theMembers;

	Dimension screenSize;

	private static JFrame frame;

    private static JPanel west;
    private static JPanel center;
    private static LoginPage login;

    public static JButton membership;
    public static JButton classes;
    public static JButton equipment;
    public static JButton league;
    public static JButton logo;
    public static JButton logOut;
    
    public static AccessToMembers memberAccess;
    private Font setFont;

    private ImageIcon imgMembership;
    private ImageIcon imgSchedule;
    private ImageIcon imgEquipment;
    private ImageIcon imgLeague;
    private ImageIcon imgLogo;
    private Object[][] data;
    private static Originator originator;
    ArrayList<GridMenuItem> testList;
    

	public gymInterface(){
        theClassesHolder = new ClassesModel();

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
        setFont = new Font("SansSerif", Font.BOLD, 40);

        originator = new Originator();

		frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
        frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(0, 0, screenSize.width, screenSize.height); //This was just so I could see it in ubunutu
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createLeagueModel();
		//Initializes the west Panel, aka the 5 main buttons
        west = setWestPanel();

        //Adds the 5 main buttons to the layout
        frame.add(west, BorderLayout.WEST);
        
        //Add Login Panel to the layout
        login = new LoginPage();
        gymInterface.refresh(login);
        
        frame.setVisible(true);

    //Add function to pass JPANELS around and set that up
    }
    private JPanel setWestPanel(){
        west = new JPanel();
        west.setLayout(new GridLayout(6,1));

        
        //Creates the buttons for the panel
        membership = new JButton("Membership");
        classes    = new JButton("Class");
        equipment  = new JButton("Equipment");
        league     = new JButton("League");
        logo       = new JButton("Back");
        logOut     = new JButton("Log Out");

        membership.setFont(setFont);
        classes.setFont(setFont);
        equipment.setFont(setFont);
        league.setFont(setFont);
        logo.setFont(setFont);
        logOut.setFont(setFont);


        /*
        //Needs Images to be inserted
        //Creates images that can be inserted as objects
        imgMembership = new ImageIcon();
        imgSchedule   = new ImageIcon();
        imgEquipment  = new ImageIcon();
        imgLeague     = new ImageIcon();
        imgLogo       = new ImageIcon();

        //Inserts the images objects into the correct button
        membership.setIcon(imgMembership);
        classes.setIcon(imgSchedule);
        equipment.setIcon(imgEquipment);
        league.setIcon(imgLeague);
        logo.setIcon(imgLogo);
        */

        disable();

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

        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(Calendar.MONTH,1);
        String nextMonthAsString = sf.format(calendar.getTime());

        final ArrayList<members> memberList = new ArrayList<members>();
        members mem1 = new members("Paul", "Darragh", "Basic", 1234, calendar.getTime() , "1234567887654321");
        members mem2 = new members("Joe", "Smith", "Trial", 1235, calendar.getTime() , "8765432112345678");
        members mem3 = new members("Nick", "Cifranic", "Basic", 1254, calendar.getTime() , "9234567887654321");
        members mem4 = new members("Matt", "Smith", "League", 2235, calendar.getTime() , "2765432112345678");
        members mem5 = new members("Mason", "Sciotti", "Premium", 3234, calendar.getTime() , "8234567887654321");
        members mem6 = new members("Marissa", "Thomas", "Class", 1435, calendar.getTime() , "3765432112345678");

        memberList.add(mem1);
        memberList.add(mem2);
        memberList.add(mem3);
        memberList.add(mem4);
        memberList.add(mem5);
        memberList.add(mem6);
        final MemberTableModel model = new MemberTableModel(memberList);

        //catmeowwow <- wtf?

        AccessToMembers memberAccess = new AccessToMembers(memberList);
        ClassModel running00 = new ClassModel("Running00","1pm-2pm","M-W-F","20/30","1233");
        running00.addStudents(mem1);
        theClassesHolder.addClass(running00.getClassName(),running00);
        ClassModel running01 = new ClassModel("Running01","2pm-3pm","M-W-F","10/30","1233");
        running01.addStudents(mem2);
        theClassesHolder.addClass(running01.getClassName(),running01);
        ClassModel running02 = new ClassModel("Running02","4pm-5pm","T-Th","24/30","1233");
        running02.addStudents(mem3);
        theClassesHolder.addClass(running02.getClassName(),running02);
        ClassModel swimming00 = new ClassModel("Swimming00","1pm-3pm","M-W-F","24/35","1235");
        swimming00.addStudents(mem4);
        theClassesHolder.addClass(swimming00.getClassName(),swimming00);
        ClassModel swimming01 = new ClassModel("Swimming01","4pm-6pm","T-Th","12/15","1235");
        swimming01.addStudents(mem5);
        theClassesHolder.addClass(swimming01.getClassName(),swimming01);
        ClassModel spinning00 = new ClassModel("Spinning00","5pm-7pm","M-W-F","20/67","1236");
        spinning00.addStudents(mem6);
        theClassesHolder.addClass(spinning00.getClassName(),spinning00);

        theMediator = new GymMediatorModel(memberAccess,theClassesHolder);

        //Creates all of the listeners for each button
        membership.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new memberInterface(model,memberList,""));}});
        classes.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new classInterface(theMediator,memberList));}});
        equipment.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new EquipmentPanel(equipment_list,memberList));}});
        league.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {refresh(new GridButtonPanel("League", createLeagueModel(), false));}});
        logo.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {undo();}});
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                disable();
                refreshNoMemento(new LoginPage());
            }
        });

        //Adds all of the buttons to the layout
        west.add(logOut);
        west.add(membership);
        west.add(classes);
        west.add(equipment);
        west.add(league);
        west.add(logo);


        west.setVisible(true);
        
        return west;
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

    public static void refreshNoMemento(JPanel new_center){
        if (center != null){
            center.removeAll();
        }
        center=new_center;
        frame.add(center, BorderLayout.CENTER);
        frame.revalidate();
    }
    
    public static void enable(){
        logOut.setEnabled(true);
        membership.setEnabled(true);
        classes.setEnabled(true);
        equipment.setEnabled(true);
        league.setEnabled(true);
        logo.setEnabled(true);
    }

    public static void disable(){
        logOut.setEnabled(false);
        membership.setEnabled(false);
        classes.setEnabled(false);
        equipment.setEnabled(false);
        league.setEnabled(false);
        logo.setEnabled(false);
    }
    
    public static void undo(){
    	
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

    private ArrayList<GridMenuItem> createLeagueModel(){
        ArrayList<GridMenuItem> tempLeague;

    	//Build a temp league
        tempLeague = new ArrayList<GridMenuItem>();
        LeagueModel tempLeagueModel = new LeagueModel("Football");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Soccer");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Ping Pong");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Weight Club");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Basketball");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Dodgeball");
        tempLeague.add(tempLeagueModel.getMenuItem());
        tempLeagueModel = new LeagueModel("Tennis");
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Field Hockey");
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Hockey");
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	tempLeagueModel = new LeagueModel("Underwater Basket Weaving");
    	tempLeague.add(tempLeagueModel.getMenuItem());
    	
    	return tempLeague;
    }

}