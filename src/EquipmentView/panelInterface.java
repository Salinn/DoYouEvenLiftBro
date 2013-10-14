/*
 * panelInterface.java
 * 
 */
package EquipmentView;

/**
 * Copied from defualt package so that my testing code works.
 *   -Pop
 */
import javax.swing.*;
import java.awt.*;

public class panelInterface {
    private JPanel west;
    private JButton membership;
    private JButton schedule;
    private JButton equipment;
    private JButton league;
    private JButton logo;

    private ImageIcon imgMembership;
    private ImageIcon imgSchedule;
    private ImageIcon imgEquipment;
    private ImageIcon imgLeague;
    private ImageIcon imgLogo;


    public panelInterface(){
        //Creates the panel layout, which is a vertical grid layout
        west = new JPanel();
        west.setLayout(new GridLayout(5,1));

        //Creates the buttons for the panel
        membership = new JButton("Membership");
        schedule   = new JButton("Schedule");
        equipment  = new JButton("Equipment");
        league     = new JButton("League");
        logo       = new JButton();

        //Needs Images to be inserted
        //Creates images that can be inserted as objects
        imgMembership = new ImageIcon();
        imgSchedule   = new ImageIcon();
        imgEquipment  = new ImageIcon();
        imgLeague     = new ImageIcon();
        imgLogo       = new ImageIcon();

        //Inserts the images objects into the correct button
        membership.setIcon(imgMembership);
        schedule.setIcon(imgSchedule);
        equipment.setIcon(imgEquipment);
        league.setIcon(imgLeague);
        logo.setIcon(imgLogo);

        //Adds all of the buttons to the layout
        west.add(membership);
        west.add(schedule);
        west.add(equipment);
        west.add(league);
        west.add(logo);
    }


    public JPanel getPanel(){
        return west;
    }
}