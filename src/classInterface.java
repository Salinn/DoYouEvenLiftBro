import com.sun.deploy.panel.JavaPanel;

import java.awt.*;

import javax.swing.*;

public class classInterface extends JPanel {
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JButton addClass;
    private JButton editClass;
    private JTextField searchBar;
    private JButton left;
    private JButton right;

    public classInterface(){
        addClass = new JButton(" add ");
        editClass = new JButton(" edit ");
        left = new JButton(" < ");
        right = new JButton(" > ");
        buttonPanel = new JavaPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        for( int i=0; i<5; i++){
            JButton t = new JButton(" test ");
            buttonPanel.add(t);
        }
        this.setLayout(new BorderLayout(10,10));
        this.add(right, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.CENTER);
    }


}
