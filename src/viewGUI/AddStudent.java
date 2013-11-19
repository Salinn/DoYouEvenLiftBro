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
        addStudent = new JButton("Add");
        addStudent.setFont(new Font("Sans Serif", Font.BOLD, 40));
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
                    	try{
                        String id = studentId.getText();
                        mediator.addStudentToClass(id, className);
                        JPanel panel = new ClassInfoandStudents(className,mediator);
                        gymInterface.refresh(panel);
                    	} catch (NullPointerException exception) {
                    		showErrorMessage();
                    	} catch (NumberFormatException exception) {
                    		showErrorMessage();
                    	}
                    }
                });
    }
    
    private void showErrorMessage(){
    	JOptionPane.showMessageDialog(studentId,
                "Please enter a valid 4 digit member ID.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }



}
