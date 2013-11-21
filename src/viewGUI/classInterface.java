package viewGUI;


import Model.ClassModel;
import Model.GymMediatorModel;
import Model.members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class classInterface extends JPanel {
    private GridButtonPanel buttons;
    private GymMediatorModel mediator;
    private ArrayList<GridMenuItem> classList;
    private ArrayList<members> memberList;


    public classInterface(GymMediatorModel mediator, ArrayList<members> memberList){
        this.mediator = mediator;
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
        this.setLayout(new BorderLayout());
        ArrayList<GridMenuItem> classList = new ArrayList<GridMenuItem>();

        ArrayList<ClassModel> classes = mediator.getClasses();
        for(ClassModel aClass: classes){
         classList.add(new GridMenuItem(aClass,mediator,memberList));
        }


        buttons = new GridButtonPanel("Classes",classList,false);

        this.add(buttons, BorderLayout.CENTER);

    }


}
