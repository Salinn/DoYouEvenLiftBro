package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassModel {
    private String className;
    private String classTime;
    private String classDays;
    private String classLocation;
    private Integer classCapacity;
    private HashMap<Integer,members> students;

    public ClassModel(String className, String classTime, String classDays,
                      Integer classCapacity, String classLocation){
        this.classCapacity = classCapacity;
        this.classDays = classDays;
        this.classLocation = classLocation;
        this.className = className;
        this.classTime = classTime;
        students = new HashMap<Integer, members>();

    }

    public void addStudents(members student){
       students.put(student.getId(),student);
    }

    public members getStudent(String id){
       return students.get(id)  ;
    }

    public ArrayList<members> getAllStudents(){
        ArrayList<members> temp = new ArrayList<members>();
        for (members m: students.values()){
            temp.add(m);
        }
        return temp;
    }


    public String getClassName(){return this.className;}
    public String getClassTime(){return this.classTime;}
    public String getClassDays(){return this.classDays;}
    public String getClassLocation(){return this.classLocation;}
    public String getClassCapacity(){
        return "" + students.size() + "/" + this.classCapacity;}

    public void setClassName(String name){this.className = name;}
    public void setClassTime(String time){this.classTime = time;}
    public void setClassDays(String days){this.classDays = days;}
    public void setClassLocation(String location){this.classLocation = location;}
    public void setClassCapacity(Integer capacity){this.classCapacity = capacity;}

}
