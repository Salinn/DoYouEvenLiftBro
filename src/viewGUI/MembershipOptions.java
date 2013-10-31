package viewGUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class MembershipOptions extends JPanel {
    private GridButtonPanel buttons;
    public MembershipOptions(JPanel temp){
        this.setLayout(new BorderLayout());
        ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();
        testList.add(new GridMenuItem(temp ,"Basic"));
        testList.add(new GridMenuItem(temp,"Intramural"));
        testList.add(new GridMenuItem(temp,"Class"));
        testList.add(new GridMenuItem(temp,"Premium"));
        testList.add(new GridMenuItem(temp,"Trial"));
        buttons = new GridButtonPanel("Membership Options",testList);
        this.add(buttons, BorderLayout.CENTER);
    }
}
