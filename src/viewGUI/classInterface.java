package viewGUI;


import Model.ClassModel;
import Model.GymMediatorModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class classInterface extends JPanel {
    private GridButtonPanel buttons;
    private GymMediatorModel mediator;


    public classInterface(){
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
        ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();

        /**
        ArrayList<ClassModel> classes = mediator.getClasses();
        for(ClassModel aClass: classes){
            testList.add(new GridMenuItem(aClass,aClass.getClassName()));
        }
         **/


        testList.add(new GridMenuItem(null,"Jogging"));
        testList.add(new GridMenuItem(null,"spinning"));
        testList.add(new GridMenuItem(null,"running"));
        testList.add(new GridMenuItem(null,"boxing"));
        testList.add(new GridMenuItem(null,"weights"));
        testList.add(new GridMenuItem(null,"swimming"));
        testList.add(new GridMenuItem(null,"squash"));
        testList.add(new GridMenuItem(null,"Tennis"));
        testList.add(new GridMenuItem(null,"diving"));
        testList.add(new GridMenuItem(null,"yoga"));
        testList.add(new GridMenuItem(null,"karate"));
        testList.add(new GridMenuItem(null,"dance"));
        testList.add(new GridMenuItem(null,"Zumba"));
        testList.add(new GridMenuItem(null,"sleeping"));
        testList.add(new GridMenuItem(null,"meditation"));
        testList.add(new GridMenuItem(null,"prancing"));
        testList.add(new GridMenuItem(null,"break dancing"));
        testList.add(new GridMenuItem(null,"clasical dance"));
        testList.add(new GridMenuItem(null,"gorri"));
        testList.add(new GridMenuItem(null,"jumas"));
        testList.add(new GridMenuItem(null,"dirt"));
        for (GridMenuItem GmI: testList){
            GmI.getButton().addActionListener(new ActionListener() {
            				public void actionPerformed(ActionEvent e){
                            JPanel panel = new ClassInfoandStudents();
                            gymInterface.refresh(panel);}
            });
        }
        buttons = new GridButtonPanel("Classes",testList);
        this.add(buttons, BorderLayout.CENTER);

    }


}
