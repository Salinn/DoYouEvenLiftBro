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
    public MembershipOptions(){
        this.setLayout(new BorderLayout());
        ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();
        testList.add(new GridMenuItem(null,"Basic"));
        testList.add(new GridMenuItem(null,"Intramural"));
        testList.add(new GridMenuItem(null,"Class"));
        testList.add(new GridMenuItem(null,"Premium"));
        testList.add(new GridMenuItem(null,"Trial"));
        buttons = new GridButtonPanel("Membership Options",testList);
        this.add(buttons, BorderLayout.CENTER);
    }
}
