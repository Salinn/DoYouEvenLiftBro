package viewGUI;

import Model.members;
import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;

public class MemberTableModel extends AbstractTableModel{
    private ArrayList<members> memberList;

    public MemberTableModel(ArrayList<members> memberList){
        this.memberList = memberList;
    }
    public int getRowCount() {
        return memberList.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "First Name";
                break;
            case 1:
                name = "Last Name";
                break;
            case 2:
                name = "ID";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            	break;
            case 1:
            	break;
            case 2:
                type = Integer.class;
                break;
        }
        return type;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        members member = memberList.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = member.getFirstName();
                break;
            case 1:
                value = member.getLastName();
                break;
            case 2:
                value = member.getId();
                break;
        }
        return value;
    }
}

