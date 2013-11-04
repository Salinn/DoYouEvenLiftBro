package Model;

/*
 * Equipment.java
 * 
 */

/**
 * Equipment is the model class representing a piece of equipment in a gym.
 *
 * @author Andrew Popovich (ajp7560@rit.edu)
 */

import java.util.Date;

public class Equipment {

	/** Name (label) for piece of equipment */
	private String name;
	
	/** Gym ID number for equipment piece */
	private String id;

	/** Manfactuer's model number for equipment piece */
	private String model_number;
	
	/** Location of the equipment in the gym */
	private String location;
	
	/** Represents whether or not the equipment is being loaned */
	private boolean on_loan;
	
	/** ID of the member borrowing the equipment, if applicable */
	private String member_id_loaning;
	
	/** Represents whether or not the equipment needs to be cleaned */
	private boolean needs_cleaning;
	
	/** Represents whether or not the equipment needs to be repaired */
	private boolean needs_repairs;
	
	/** The repair date for the equipment, if applicable */
	private Date repair_date;
	
	/** The cost to repair the equipment, if applicable */
	private Float repair_cost;
	
	//TODO Schedule of classes as an attribute w/ appropriate methods
	
	/**
	 * Constructor of the Equipment class.  Initializes an equipment piece
	 * so that the piece of equipment is not on loan and doesn't require
	 * cleaning and repairs.
	 * 
	 * @param name - String - label used in the system
	 * @param id - String - ID used in the system
	 * @param model_num - String - manfactuer's model number
	 * @param location - String - gym room name where equipment resides
	 */
	public Equipment(String name, String id, String model_num, 
			String location){
		this.name = name;
		this.id = id;
		this.model_number = model_num;
		this.location = location;
		
		//Initialize to boolean attributes to false to show that 
		//the equipment is in a 'new' state
		this.on_loan = false;
		this.needs_cleaning = false;
		this.needs_repairs = false;
		
		//Initialize specific attributes to null because they are not
		//applicable to the current state of the equipment
		this.member_id_loaning = null;
		this.repair_date = null;
		this.repair_cost = null;
	}
	
	/**
	 * Getter method for the name attribute.
	 * @return name - String - label for the equipment in the system.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Getter method for the id attribute.
	 * @return id - String - system ID of the equipment
	 */
	public String getID(){
		return this.id;
	}
	
	/**
	 * Getter method for the model number attribute.
	 * @return model_number - String - manufacter's ID number
	 */
	public String getModelNumber(){
		return this.model_number;
	}
	
	/**
	 * Getter method for the location of the equipment.
	 * @return location - String - location of the equipment in the gym
	 */
	public String getLocation(){
		return this.location;
	}
	
	/**
	 * Getter method for determining whether or the equipment is on loan.
	 * @return on_loan - boolean - indicates if the equipment is on loan
	 */
	public boolean isOnLoan(){
		return this.on_loan;
	}
	
	/**
	 * Getter method for retrieving the ID of the member loaning the equipment.
	 * @return member_id_loaning - String - ID of the member loaning the piece
	 *                                      of equipment.
	 */
	public String getMemberLoaning(){
		return this.member_id_loaning;
	}
	/**
	 * Getter method for determining if the equipment needs to be cleaned.
	 * @return needs_cleaning - boolean - indicates if the equipment needs to
	 *                                    be cleaned
	 */
	public boolean needsCleaning(){
		return this.needs_cleaning;
	}
	
	/**
	 * Getter method for determining if the equipment needs to be repaired.
	 * @return needs_repairs - boolean - indicates if the equipment needs to be
	 *                                   repaired
	 */
	public boolean needsRepairs(){
		return this.needs_repairs;
	}
	
	/**
	 * Getter method for retrieving the repair date of the equipment, if
	 * applicable.
	 * @return repair_date - Date - repair date of the equipment piece
	 */
	public Date getRepairDate(){
		return this.repair_date;
	}
	
	/**
	 * Getter method for the cost of the repair, if applicable.
	 * @return repair_cost - Float - cost to repair the equipment
	 */
	public Float getRepairCost(){
		return this.repair_cost;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Sets the member that is borrowing the equipment and the on loan 
	 * attribute that indicates that the equipment is/isn't on loan.
	 * 
	 * @param on_loan - boolean - indicates if the equipment is on loan
	 * @param member_id - String - ID of the member loaning the piece of 
	 *                             equipment
	 */
	public void setLoan(boolean on_loan, String member_id){
		this.on_loan = on_loan;
		this.member_id_loaning = member_id;
	}
	
	/**
	 * Sets the cleaning attribute of the equipment. 
	 * @param cleaning - boolean - Indicates if the equipment needs to be
	 *                             cleaned
	 */
	public void setCleaning(boolean cleaning){
		this.needs_cleaning = cleaning;
	}
	
	/**
	 * Sets the repair attributes of the equipment.
	 * @param repairs - boolean - indicates if the equipment needs to be
	 *                            repaired 
	 * @param date - Date - repair date of the equipment piece
	 * @param cost - Float - cost to repair the equipment
	 */
	public void setRepairs(boolean repairs, Date date, Float cost){
		this.needs_repairs = repairs;
		this.repair_date = date;
		this.repair_cost = cost;
	}
	
	
	
	

}
