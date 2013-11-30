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

import Model.Equipment;

import Model.members;
import viewGUI.GridButtonPanel;
import viewGUI.GridMenuItem;
import viewGUI.MemberTableModel;
import viewGUI.gymInterface;

/**
 * Enter description here.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */
public class EquipmentPanel extends JPanel{

	private GridButtonPanel buttons;
	
	private ArrayList<Equipment> equipment;

    ArrayList<members> memberList;
	
	public EquipmentPanel(ArrayList<Equipment> equipment, ArrayList<members> memberList){
        this.memberList = memberList;

		this.setLayout(new BorderLayout());
		this.equipment = equipment;
		ArrayList<GridMenuItem> menu_items = makeGridItems();
		this.buttons = new GridButtonPanel("Equipment", menu_items, null);
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
					JPanel panel = new EquipmentInfo(equipment_piece, memberList);
					gymInterface.refresh(panel);	
				}
			});
			items.add(item);
		}
		return items;
	}
	

}
