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


    public classInterface(GymMediatorModel mediator){
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
        ArrayList<GridMenuItem> testList = new ArrayList<GridMenuItem>();

        /**
        ArrayList<ClassModel> classes = mediator.getClasses();
        for(ClassModel aClass: classes){
            testList.add(new GridMenuItem(aClass,mediator));
        }
         **/

        ClassModel running00 = new ClassModel("Running00","1pm-2pm","M-W-F","20/30","1233");
        ClassModel running01 = new ClassModel("Running01","2pm-3pm","M-W-F","10/30","1233");
        ClassModel running02 = new ClassModel("Running02","4pm-5pm","T-Th","24/30","1233");
        ClassModel swimming00 = new ClassModel("Swimming00","1pm-3pm","M-W-F","24/35","1235");
        ClassModel swimming01 = new ClassModel("Swimming01","4pm-6pm","T-Th","12/15","1235");
        ClassModel spinning00 = new ClassModel("Spinning00","5pm-7pm","M-W-F","20/67","1236");
        ClassModel spinning01 = new ClassModel("Spinning01","1pm-2pm","T-Th","20/67","1773");
        ClassModel jogging00 = new ClassModel("Jogging00","1pm-2pm","M-W-F","20/67","1211");
        ClassModel jogging01 = new ClassModel("Jogging01","6pm-7pm","T-Th","20/100","1266");
        ClassModel karate00 = new ClassModel("Karate00","1pm-2pm","M-W-F","20/30","1209");
        ClassModel karate01 = new ClassModel("Karate01","8am-9am","T-Th","20/30","1234");

        testList.add(new GridMenuItem(running00,mediator));
        testList.add(new GridMenuItem(running01,mediator));
        testList.add(new GridMenuItem(running02,mediator));
        testList.add(new GridMenuItem(swimming00,mediator));
        testList.add(new GridMenuItem(swimming01,mediator));
        testList.add(new GridMenuItem(spinning00,mediator));
        testList.add(new GridMenuItem(spinning01,mediator));
        testList.add(new GridMenuItem(jogging00,mediator));
        testList.add(new GridMenuItem(jogging01,mediator));
        testList.add(new GridMenuItem(karate00,mediator));
        testList.add(new GridMenuItem(karate01,mediator));

        this.add(buttons, BorderLayout.CENTER);

    }


}
