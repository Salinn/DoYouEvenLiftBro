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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import Model.Equipment;
import Model.GymMediatorModel;

import viewGUI.gymInterface;

public class EquipmentInfo extends JPanel{

	/** Equipment object that contains information */
	private Equipment equipment;
	
	/** Text field for the gym id */
	private JTextField equip_id;
	
	private JTextField equip_location;
	
	private JLabel equip_loan;
	
	private JTextField member;
	
	private JRadioButton yes;
	
	private JRadioButton no;
	
	private JLabel equip_repair;
	
	private JTextField repair_date;
	
	private JTextField cost;
	
	private JButton edit;
	
	private boolean isEditing;
	
	/**
	 * Constructor of the Equipment Info panel.  It uses the attributes of
	 * the equipment passed in to populate the various fields.
	 * 
	 * @param equipment - Equipment - Equipment piece that has been requested
	 *                                to be displayed
	 */
	public EquipmentInfo(Equipment equipment){
		this.equipment = equipment;
		this.isEditing = false;
		
		//Uses border layout for main layout
		this.setLayout(new BorderLayout());
		
		Font label_font = new Font("Serif", Font.PLAIN, 30);
		Font sub_label = new Font("Serif", Font.PLAIN, 20);
		final JPanel frame = new JPanel(new BorderLayout(50, 50));
		
		//North border
		JPanel north = new JPanel();
		JLabel label = new JLabel(this.equipment.getName());
		label.setFont(new Font("Serif", Font.PLAIN, 40));
		north.add(label);
		
		frame.add(north, BorderLayout.NORTH);
		
		
		//Center border
		JPanel center = new JPanel(new GridLayout(6,0,0,15));
		
		//ID Group
		
		JPanel id = new JPanel(new GridLayout(0,2));
		JLabel label_id = new JLabel("ID: ");
		label_id.setFont(label_font);
		id.add(label_id);
		equip_id = new JTextField(this.equipment.getID());
		equip_id.setEnabled(false);
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
		equip_location = new JTextField(this.equipment.
				getLocation());
		equip_location.setEnabled(false);
		equip_location.setFont(label_font);
		location.add(equip_location);
		
		//Loan Group
		JPanel loan = new JPanel(new GridLayout(0,2));
		JLabel label_loan = new JLabel("On Loan: ");
		label_loan.setFont(label_font);
		
		
		equip_loan = new JLabel();
		equip_loan.setFont(label_font);
		JLabel label_who = new JLabel("Member ID Loaning: "); //Change to member?
		label_who.setFont(sub_label);
		member = new JTextField();
		member.setEnabled(false);
		member.setFont(sub_label);
		
		
		loan.add(label_loan);
		loan.add(equip_loan);
		loan.add(label_who);
		loan.add(member);
		
		//Cleaning Group
		JPanel clean = new JPanel(new GridLayout(0,2));
		JLabel label_clean = new JLabel("Needs Cleaning: ");
		label_clean.setFont(label_font);
		ButtonGroup radioButtons = new ButtonGroup();
		yes = new JRadioButton("Yes");
		no = new JRadioButton("No");
		yes.setFont(label_font);
		no.setFont(label_font);
		yes.setEnabled(false);
		no.setEnabled(false);
		JPanel radio = new JPanel(new GridLayout(0,3));
		radioButtons.add(yes);
		radioButtons.add(no);
		radio.add(yes);
		radio.add(no);
		
		
		
		clean.add(label_clean);
		clean.add(radio);
		
		
		
		//Repair Group
		JPanel repair = new JPanel(new GridLayout(0,2));
		JLabel label_repair = new JLabel("Needs Repairs: ");
		label_repair.setFont(label_font);
		
		equip_repair = new JLabel();
		equip_repair.setFont(label_font);
		JLabel repair_when = new JLabel("When: "); //Change to member?
		repair_when.setFont(sub_label);
		repair_date = new JTextField(); //TODO Change
		repair_date.setEnabled(false);
		repair_date.setFont(sub_label);
		JLabel repair_cost = new JLabel("Cost: "); //Change to member?
		repair_cost.setFont(sub_label);
		cost = new JTextField(); //TODO Change?
		cost.setEnabled(false);
		cost.setFont(sub_label);
		
		
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
		
		updateScreen();
		frame.add(center, BorderLayout.CENTER);
		
		
		//South border
		JPanel south = new JPanel(new FlowLayout());
		edit = new JButton("Edit Equipment");
		
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(isEditing){
					//Retrieve fields and perform validation check
					String id = equip_id.getText();
					String location = equip_location.getText();
					String member_id = member.getText();
					String entered_cost = cost.getText();
					String date = repair_date.getText();
					if (!validateChanges(id, member_id, entered_cost, date)){
						return;
					}
					
					
					// If successful show changes
					updateEquipment(id, location, member_id, date, entered_cost);
					isEditing = false;
					equip_id.setEnabled(false);
					equip_location.setEnabled(false);
					member.setEnabled(false);
					yes.setEnabled(false);
					no.setEnabled(false);
					repair_date.setEnabled(false);
					cost.setEnabled(false);
					
					edit.setText("Edit Equipment");
					
				}else{
					
					//Enable all fields that should be editable
					isEditing = true;
					equip_id.setEnabled(true);
					equip_location.setEnabled(true);
					member.setEnabled(true);
					yes.setEnabled(true);
					no.setEnabled(true);
					repair_date.setEnabled(true);
					cost.setEnabled(true);
					
					edit.setText("Apply");
				}
				updateScreen();
				frame.revalidate();
				
			}
			
		});
		
		
		edit.setFont(new Font("Serif", Font.PLAIN, 40));
		south.add(edit, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		this.add(frame, BorderLayout.CENTER);
		
		
	}
	
	
	private void updateScreen(){
		boolean on_loan = this.equipment.isOnLoan();
		if(on_loan){
			equip_loan.setText("Yes");
			member.setText(this.equipment.getMemberLoaning());
		} else {
			equip_loan.setText("No");
			member.setText("N/A");
		}
		
		boolean needs_cleaning = this.equipment.needsCleaning();

		if(needs_cleaning){
			this.yes.setSelected(true);
		} else {
			this.no.setSelected(true);
		}
		
		boolean needs_repairs = this.equipment.needsRepairs();

		if(needs_repairs){
			equip_repair.setText("Yes");
			repair_date.setText(this.equipment.getRepairDate().toString());
			cost.setText(this.equipment.getRepairCost().toString());
		} else {
			equip_repair.setText("No");
		}
	}
	
	
	
	
	private boolean validateChanges(String id, String member_id, String cost,
			String repair_date){
		try{
			int gym_id = Integer.parseInt(id);
			if(gym_id < 0){
				JOptionPane.showMessageDialog(null, "Gym ID is not valid.");
				return false;
			}	
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Gym ID is not valid.");
			return false;
		}
		
		try{
			int mem_id = Integer.parseInt(member_id);
			if(GymMediatorModel.getAccess().getMember(mem_id) == null){
				JOptionPane.showMessageDialog(null, "Member ID is not a valid ID.");
				return false;
			}
		} catch (NumberFormatException e){
			if (!member_id.equals("") && !member_id.equals("N/A")){
				System.out.println(member_id);
				JOptionPane.showMessageDialog(null, "Member ID is not a valid ID.");
				return false;
			}
		}
		
		if(repair_date.equals("") ^ cost.equals("")){
			if(repair_date.equals("")){
				JOptionPane.showMessageDialog(null, "Please enter a repair date in the format of mm-dd-yyyy.");
			}
			if(cost.equals("")){
				JOptionPane.showMessageDialog(null, "Please enter a repair cost.");
			}
			return false;
		}
		
		try{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("mm-dd-yyyy");
			Date date = sf.parse(repair_date);
			Date today = calendar.getTime();  //TODO Not today's date?
			
			/*
			System.out.println(sf.format(date));
			if(date.compareTo(today)<0){
				JOptionPane.showMessageDialog(null, "Repair date is not valid.\nPlease enter a date following the format of mm-dd-yyyy.");
				return false;
			}
			*/
		} catch (ParseException e) {
			if(!repair_date.equals("")){
				JOptionPane.showMessageDialog(null, "Repair date is not valid.\nPlease enter a date following the format of mm-dd-yyyy.");
				return false;
			}
		}
		
		try{
			DecimalFormat df = new DecimalFormat("#.##");
			double repair_cost = Double.parseDouble(cost);
		} catch (NumberFormatException e) {
			if(!cost.equals("")){
				JOptionPane.showMessageDialog(null, "Repair cost is not valid.\nPlease enter a valid price.");
				return false;
			}
		}
		
		return true;
	}
	
	private void updateEquipment(String id, String location, String member_id,
			String date, String cost){
		this.equipment.setID(id);
		this.equipment.setLocation(location);
		
		if(!member_id.equals("") && !member_id.equals("N/A")){
			this.equipment.setLoan(true, member_id);
		} else {
			this.equipment.setLoan(false, null);
		}
		
		if (yes.isSelected()){
			this.equipment.setCleaning(true);
		} else {
			this.equipment.setCleaning(false);
		}
		
		if(!date.equals("") && !cost.equals("")){
			
			this.equipment.setRepairs(true, date, cost);
		} else {
			this.equipment.setRepairs(false, null, null);
		}
		

	}
	

}
