package viewGUI;
import Model.ClassModel;
import Model.GymMediatorModel;
import Model.members;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AddStudent extends JPanel {
    private JButton addStudent;
    private JTextField studentId;
    private JLabel id;
    private GymMediatorModel mediator;
    private ClassModel className;
    private ArrayList<members> memberList;

    private JPanel gridPanel;


    public AddStudent(final GymMediatorModel mediator, final ClassModel className, final ArrayList<members> memberList){
        this.mediator = mediator;
        this.className = className;
        this.memberList = memberList;
        addStudent = new JButton("Add Student");
        JButton search = new JButton("Search For Student");
        addStudent.setFont(new Font("Sans Serif", Font.BOLD, 40));
        search.setFont(new Font("Sans Serif", Font.BOLD, 40));
        studentId = new JTextField();
        studentId.setFont(new Font("Sana Serif", Font.BOLD, 40));
        id = new JLabel("Add Student ID");
        id.setFont(new Font("Sans Serif", Font.BOLD, 40));

        gridPanel = new JPanel();
        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout());
        temp.add(search);
        temp.add(addStudent);

        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String id = studentId.getText();
                    mediator.addStudentToClass(id, className);
                    JPanel panel = new ClassInfoandStudents(className,mediator,memberList);
                    gymInterface.refresh(panel);
                } catch (NullPointerException exception) {
                    showErrorMessage();
                } catch (NumberFormatException exception) {
                    showErrorMessage();
                }
            }
        });
        search.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
            gymInterface.refresh(new MembersSearch(mediator,className,memberList,""));
        }});


        gridPanel.setLayout(new GridLayout(1, 1));
        this.setLayout(new BorderLayout());

        gridPanel.add(id);
        gridPanel.add(studentId);
        this.add(gridPanel, BorderLayout.NORTH);
        this.add(temp, BorderLayout.SOUTH);
    }

    private void showErrorMessage(){
    	JOptionPane.showMessageDialog(studentId,
                "Please enter a valid 4 digit member ID.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }



}
