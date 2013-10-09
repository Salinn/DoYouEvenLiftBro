import com.sun.deploy.panel.JavaPanel;

import java.awt.*;

import javax.swing.*;

public class classInterface extends JPanel {
    private JPanel leftPanel;
    private JComponent rightPanel;
    private JPanel buttonPanel;
    private JButton addClass;
    private JButton editClass;
    private JTextField searchBar;
    private JButton left;
    private JButton right;

    public classInterface(){
        addClass = new JButton(" add class ");
        editClass = new JButton(" edit class ");
        left = new JButton(" < ");
        right = new JButton(" > ");
        buttonPanel = new JPanel();

        this.setLayout(new BorderLayout(10,10));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,60,50));

        for( int i=0; i<=8; i++){
            JButton t = new JButton(" test button ");
            t.setPreferredSize(new Dimension(150,100));
            buttonPanel.add(t);
        }
        this.add(right, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.CENTER);
    }


}
