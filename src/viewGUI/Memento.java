package viewGUI;

import javax.swing.*;

import java.awt.Component;
import java.util.*;

public class Memento {
    private JPanel state;
    public Memento(JPanel state) { 
    	this.state = copy(state); }
    public JPanel getState() { return state; }
    
    private static JPanel copy(JPanel state){
    	JPanel panel = new JPanel(state.getLayout());
    	for(int i = 0; i < state.getComponentCount(); i++){
    		Component comp = state.getComponent(i);
    		panel.add(comp);
    	}
    	return panel;
    }
}