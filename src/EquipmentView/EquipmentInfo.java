package EquipmentView;

/*
 * EquipmentInfo.java
 * 
 */

/**
 * EquipmentInfo is the class that is responsible for displaying a particular
 * equipment's information.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import viewGUI.gymInterface;

public class EquipmentInfo extends JPanel{

	/** Equipment object that contains information */
	private Equipment equipment;
	
	/**
	 * Constructor of the Equipment Info panel.  It uses the attributes of
	 * the equipment passed in to populate the various fields.
	 * 
	 * @param equipment - Equipment - Equipment piece that has been requested
	 *                                to be displayed
	 */
	public EquipmentInfo(Equipment equipment){
		this.equipment = equipment;
		
		//Uses border layout for main layout
		this.setLayout(new BorderLayout(50,50));
		
		Font label_font = new Font("Serif", Font.PLAIN, 30);
		Font sub_label = new Font("Serif", Font.PLAIN, 20);
		
		//North border
		JPanel north = new JPanel();
		JLabel label = new JLabel(this.equipment.getName());
		label.setFont(new Font("Serif", Font.PLAIN, 40));
		north.add(label);
		
		this.add(north, BorderLayout.NORTH);
		
		
		//Center border
		JPanel center = new JPanel(new GridLayout(6,0,0,15));
		
		//ID Group
		
		JPanel id = new JPanel(new GridLayout(0,2));
		JLabel label_id = new JLabel("ID: ");
		label_id.setFont(label_font);
		id.add(label_id);
		JTextField equip_id = new JTextField(this.equipment.getID());
		equip_id.setEditable(false);
		equip_id.setFont(label_font);
		id.add(equip_id);
		
		//Model # Group
		JPanel model = new JPanel(new GridLayout(0,2));
		JLabel label_model = new JLabel("Model Number: ");
		label_model.setFont(label_font);
		model.add(label_model);
		JTextField equip_model = new JTextField(this.equipment.
				getModelNumber());
		equip_model.setEditable(false);
		equip_model.setFont(label_font);
		model.add(equip_model);
		
		//Location Group
		JPanel location = new JPanel(new GridLayout(0,2));
		JLabel label_location = new JLabel("Location: ");
		label_location.setFont(label_font);
		location.add(label_location);
		JTextField equip_location = new JTextField(this.equipment.
				getLocation());
		equip_location.setEditable(false);
		equip_location.setFont(label_font);
		location.add(equip_location);
		
		//Loan Group
		JPanel loan = new JPanel(new GridLayout(0,2));
		JLabel label_loan = new JLabel("On Loan: ");
		label_loan.setFont(label_font);
		
		
		JLabel equip_loan = new JLabel();
		equip_loan.setFont(label_font);
		JLabel label_who = new JLabel("Member ID: "); //Change to member?
		label_who.setFont(sub_label);
		JTextField member = new JTextField();
		member.setFont(sub_label);
		boolean on_loan = this.equipment.isOnLoan();
		
		if(on_loan){
			equip_loan.setText("Yes");
			member.setText(this.equipment.getMemberLoaning());
		} else {
			equip_loan.setText("No");
			member.setText("N/A");
		}
		
		loan.add(label_loan);
		loan.add(equip_loan);
		loan.add(label_who);
		loan.add(member);
		
		//Cleaning Group
		JPanel clean = new JPanel(new GridLayout(0,2));
		JLabel label_clean = new JLabel("Needs Cleaning: ");
		label_clean.setFont(label_font);
		
		JLabel equip_clean = new JLabel();
		equip_clean.setFont(label_font);
		boolean needs_cleaning = this.equipment.needsCleaning();

		if(needs_cleaning){
			equip_clean.setText("Yes");
		} else {
			equip_clean.setText("No");
		}
		
		clean.add(label_clean);
		clean.add(equip_clean);
		
		
		//Repair Group
		JPanel repair = new JPanel(new GridLayout(0,2));
		JLabel label_repair = new JLabel("Needs Repairs: ");
		label_repair.setFont(label_font);
		
		JLabel equip_repair = new JLabel();
		equip_repair.setFont(label_font);
		JLabel repair_when = new JLabel("When: "); //Change to member?
		repair_when.setFont(sub_label);
		JTextField repair_date = new JTextField(); //TODO Change
		repair_date.setFont(sub_label);
		JLabel repair_cost = new JLabel("Cost: "); //Change to member?
		repair_cost.setFont(sub_label);
		JTextField cost = new JTextField(); //TODO Change?
		cost.setFont(sub_label);
		boolean needs_repairs = this.equipment.needsRepairs();

		if(needs_repairs){
			equip_repair.setText("Yes");
			//TODO Change below
			repair_date.setText(this.equipment.getRepairDate().toString());
			cost.setText(this.equipment.getRepairCost().toString());
		} else {
			equip_repair.setText("No");
		}
		
		repair.add(label_repair);
		repair.add(equip_repair);
		repair.add(repair_when);
		repair.add(repair_date);
		repair.add(repair_cost);
		repair.add(cost);
		
		
		center.add(id);
		center.add(model);
		center.add(location);
		center.add(loan);
		center.add(clean);
		center.add(repair);
		
		this.add(center, BorderLayout.CENTER);
		
		
		//South border
		JPanel south = new JPanel(new GridLayout(0,2));
		JButton back = new JButton("Back");
		JButton edit = new JButton("Edit");
		edit.setFont(new Font("Serif", Font.PLAIN, 40));
		back.setFont(new Font("Serif", Font.PLAIN, 40));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gymInterface.undo();	
			}
		});
		south.add(edit);
		south.add(back);
		this.add(south, BorderLayout.SOUTH);
		
		
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
        Equipment equip = new Equipment("AN OBJECT", "1", "OBJT-01", 
        		"RM-9001");
        EquipmentInfo info = new EquipmentInfo(equip);
        
        frame.add(westPanel.getPanel(), BorderLayout.WEST);
        frame.add(info, BorderLayout.CENTER);
	}
}
