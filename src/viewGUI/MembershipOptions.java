package viewGUI;


import Model.members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class MembershipOptions extends JPanel {
    private GridButtonPanel buttons;
    public MembershipOptions(JPanel buttonPanel, MemberTableModel model, ArrayList<members> memberList, members mem, int temp){
        this.setLayout(new BorderLayout());
        ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();
        testList.add(new GridMenuItem(buttonPanel ,"Basic",model, memberList, mem, temp));
        testList.add(new GridMenuItem(buttonPanel,"Intramural",model, memberList, mem, temp));
        testList.add(new GridMenuItem(buttonPanel,"Class",model, memberList, mem, temp));
        testList.add(new GridMenuItem(buttonPanel,"Premium",model, memberList, mem, temp));
        testList.add(new GridMenuItem(buttonPanel,"Trial",model, memberList, mem, temp));
        buttons = new GridButtonPanel("Membership Options",testList, null);
        this.add(buttons, BorderLayout.CENTER);
    }
}
