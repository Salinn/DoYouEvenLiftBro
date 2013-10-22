package Model;

import java.util.HashMap;
import java.util.ArrayList;

public class GymMediatorModel {
    private ClassesModel classes;
    //private members members;

    public GymMediatorModel(){

    }

    public void createClass(){};

    public ArrayList<ClassModel> getClasses(){
        return classes.getAllClasses();
    }

    public void addStudentToClass(String memberID, ClassModel theClass ){

        /**
         * will make a call to member holder to get member then get classes holder to give class and add to class list.
         */
        //theClass.addStudents(member);
    };

}


