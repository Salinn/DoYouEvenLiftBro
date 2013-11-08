package Model;

import java.util.ArrayList;

public class AccessToMembers {
    private ArrayList<members> memberList;

    public AccessToMembers(ArrayList<members> memberList){
        this.memberList = memberList;
    }

    public members getMember(int ID){
        for (members current : memberList){
            if (current.getId() == ID){
                return current;
            }
        }
        return null;
    }
    public members getMemberFirstName(String first_Name){
        for (members current : memberList){
            if (current.getFirstName().toUpperCase().compareTo(first_Name) == 0){
                return current;
            }
        }
        return null;
    }
    public members getMemberLastName(String last_Name){
        for (members current : memberList){
            if (current.getFirstName().toUpperCase().compareTo(last_Name) == 0){
                return current;
            }
        }
        return null;
    }
}
