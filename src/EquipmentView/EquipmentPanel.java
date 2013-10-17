/*
 * EquipmentPanel.java
 * 
 */
package EquipmentView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import viewGUI.GridButtonPanel;
import viewGUI.GridMenuItem;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EquipmentPanel extends JPanel{

	private GridButtonPanel buttons;
	
	private ArrayList<Equipment> equipment;
	
	public EquipmentPanel(ArrayList<Equipment> equipment){
		
		this.setLayout(new BorderLayout());
		this.equipment = equipment;
		ArrayList<GridMenuItem> menu_items = makeGridItems();
		this.buttons = new GridButtonPanel("Equipment", menu_items);
		this.add(this.buttons, BorderLayout.CENTER);
	}
	
	private ArrayList<GridMenuItem> makeGridItems(){
		ArrayList<GridMenuItem> items = new ArrayList<GridMenuItem>();
		for(int index = 0; index < this.equipment.size(); index++){
			final Equipment equipment_piece = this.equipment.get(index);
			GridMenuItem item = new GridMenuItem(equipment_piece,
								equipment_piece.getName());
			JButton button = item.getButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JPanel panel = new EquipmentInfo(equipment_piece);
					//Set to frame
					
					
				}
			});
			items.add(item);
		}
		return items;
	}
	
	/**
	 * Main method for testing purposes.
	 */
	public static void main(String[] args){
		//Code borrowed from gymInterface
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Creates and sets up the main frame that will be used in the program
		JFrame frame = new JFrame("DO YOU EVEN LIFT BRO?!?!");
		frame.setVisible(true);
        frame.getContentPane().setLayout(new BorderLayout(20, 20));
		frame.setBounds(65, 0, screenSize.width-70, screenSize.height); //This was just so I could see it in ubunutu
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializes the west Panel, aka the 5 main buttons
        panelInterface westPanel = new panelInterface();
        
        //My Equipment Panel Initialization
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
        
        ArrayList<Equipment> equipment = new ArrayList<Equipment>();
        equipment.add(equip);
        equipment.add(equip1);
        equipment.add(equip2);
        equipment.add(equip3);
        equipment.add(equip4);
        equipment.add(equip5);
        equipment.add(equip6);
        
        JPanel eq = new EquipmentPanel(equipment);
        
        frame.add(westPanel.getPanel(), BorderLayout.WEST);
        frame.add(eq, BorderLayout.CENTER);
	}
}
