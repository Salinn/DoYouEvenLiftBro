import java.awt.*;

import javax.swing.*;

public class memberInterface {
    //The private variables used by different parts of the class
    private JPanel memberPanel;
    private JPanel bottumLayout;
    private JTextField searchFeild;
    private JButton add;
    private JButton remove;
    private JTable table;
    private Font setFont;

    public memberInterface(){
        //Creates the panel to be passed back and makes it a border layout
        memberPanel = new JPanel();
        memberPanel.setLayout(new BorderLayout(15,15));

        //Creates the font that the rest of the program will use
        setFont = new Font("SansSerif", Font.BOLD, 40);

        //Gets the layout of different parts of the boarder layout
        bottumLayout = initSouth(setFont);
        table = initCenter(setFont);

        //Adds the different layouts to the boarder layout
        memberPanel.add(bottumLayout, BorderLayout.SOUTH);
        memberPanel.add(table,BorderLayout.CENTER);
    }

    private JPanel initSouth(Font setFont){
        //Creates the Southern Layout using a FlowLayout
        bottumLayout = new JPanel();
        bottumLayout.setLayout(new FlowLayout());

        //Creates an Add button and sets its font
        add = new JButton(" + ");
        add.setFont(setFont);

        //Creates an Edit button and set its font
        remove = new JButton(" - ");
        remove.setFont(setFont);

        //Creates a search feild and sets the width and font
        searchFeild = new JTextField("",23);
        searchFeild.setFont(setFont);

        //Adds the 2 buttons and text feild to the flow layout
        bottumLayout.add(searchFeild);
        bottumLayout.add(add);
        bottumLayout.add(remove);

        return bottumLayout;
    }
    private JTable initCenter(Font setFont){
        //This is just data to populate the table to show what it would look like
        String[] columnNames = {"First Name","Last Name","ID"};
        Object[][] data = { {"Paul", "Darragh", new Integer(1234)},
                            {"Joe", "Smith", new Integer(4321)},
                            {"Paul", "Darragh", new Integer(1234)},
                            {"Joe", "Smith", new Integer(4321)},
                            {"Paul", "Darragh", new Integer(1234)},
                            {"Joe", "Smith", new Integer(4321)},
                            {"Paul", "Darragh", new Integer(1234)},
                            {"Joe", "Smith", new Integer(4321)}};

        //Creates a table of all of the customers and sets the font
        table = new JTable(data, columnNames);
        table.setFont(setFont);

        return table;
    }
    public JPanel getPanel(){
        //Returns the panel
        return memberPanel;
    }

}
