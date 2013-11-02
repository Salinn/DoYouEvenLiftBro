package Model;

import java.util.ArrayList;

public class AccessToMembers {
    private ArrayList<members> memberList;

    public AccessToMembers(ArrayList<members> memberList){
        this.memberList = memberList;
    }

    private members getMember(int ID){
        for (members current : memberList){
            if (current.getId() == ID){
                return current;
            }
        }
        return null;
    }
}
