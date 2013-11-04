package viewGUI;
import Model.ClassModel;
import Model.GymMediatorModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddStudent extends JPanel {
    private JButton addStudent;
    private JTextField studentId;
    private JLabel id;
    private GymMediatorModel mediator;
    private ClassModel className;

    private JPanel gridPanel;


    public AddStudent(GymMediatorModel mediator, ClassModel className){
        this.mediator = mediator;
        this.className = className;
        addStudent = new JButton("Add");;
        studentId = new JTextField();
        id = new JLabel("Add Student ID");

        gridPanel = new JPanel();

        gridPanel.setLayout(new GridLayout(1,1));
        this.setLayout(new BorderLayout());

        gridPanel.add(id);
        gridPanel.add(studentId);
        this.add(gridPanel, BorderLayout.NORTH);
        this.add(addStudent, BorderLayout.SOUTH);
        getButton();

    }

    public void getButton(){
        addStudent.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mediator.addStudentToClass(studentId.getText(), className);
                        JPanel panel = new ClassInfoandStudents(className,mediator);
                        gymInterface.refresh(panel);
                    }
                });
    }



}
