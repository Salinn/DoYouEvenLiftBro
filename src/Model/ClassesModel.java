package Model;

import java.util.ArrayList;

public class ClassesModel {

    private ArrayList<ClassModel> classes;

    public ClassesModel(){
        classes = new ArrayList<ClassModel>();
    }

    public ClassModel createClass(String className, String classTime, String classDays, String classCapacity, String classLocation){
        ClassModel aClass = new ClassModel(className,classTime,classDays,classCapacity,classLocation);
        return aClass;
    }

    public void addClass(ClassModel aClass){
        classes.add(aClass);
    }

}
