package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassesModel {

    private HashMap<String,ClassModel> theClasses;

    public ClassesModel(){
        theClasses = new HashMap<String,ClassModel>();
    }

    public ClassModel createClass(String className, String classTime, String classDays, String classCapacity, String classLocation){
        ClassModel aClass = new ClassModel(className,classTime,classDays,classCapacity,classLocation);
        return aClass;
    }

    public void addClass(String name, ClassModel aClass){
        theClasses.put(name,aClass);
    }

    public ClassModel findClass(String className){
        return theClasses.get(className);
    }

    public ArrayList<ClassModel> getAllClasses(){
        ArrayList<ClassModel> temp = new ArrayList<ClassModel>();
        for (ClassModel a: theClasses.values()){
            temp.add(a);
        }
        return temp;
    }


}
