package Model;

import java.util.ArrayList;

public class ClassModel {
    private String className;
    private String classTime;
    private String classDays;
    private String classLocation;
    private String classCapacity;
    private ArrayList<members> students;

    public ClassModel(String className, String classTime, String classDays,
                      String classCapacity, String classLocation){
        this.classCapacity = classCapacity;
        this.classDays = classDays;
        this.classLocation = classLocation;
        this.className = className;
        this.classTime = classTime;

    }

    public void addStudents(members student){
       students.add(student);
    }

    public members getStudent(String id){
       return null  ;
    }

    public String getClassName(){return this.className;}
    public String getClassTime(){return this.classTime;}
    public String getClassDays(){return this.classDays;}
    public String getClassLocation(){return this.classLocation;}
    public String getClassCapacity(){return this.classCapacity;}

    public void setClassName(String name){this.className = name;}
    public void setClassTime(String time){ this.classTime = time;}
    public void setClassDays(String days){this.classDays = days;}
    public void setClassLocation(String location){this.classLocation = location;}
    public void setClassCapacity(String capacity){this.classCapacity = capacity;}

}
