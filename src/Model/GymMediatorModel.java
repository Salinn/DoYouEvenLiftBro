package Model;

import java.util.HashMap;
import java.util.ArrayList;

public class GymMediatorModel {
    private ClassesModel classes;
    private AccessToMembers members;

    public GymMediatorModel(AccessToMembers members, ClassesModel classes){
        this.members = members;
        this.classes = classes;
    }

    public void createClass(){};

    public ArrayList<ClassModel> getClasses(){
        return classes.getAllClasses();
    }

    public void addStudentToClass(String memberID, ClassModel theClass ){

        theClass.addStudents(members.getMember(Integer.getInteger(memberID)));
    };



}


