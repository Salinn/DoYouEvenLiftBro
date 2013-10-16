package viewGUI;

import javax.swing.*;
import java.util.*;

public class Memento {
    private JPanel state;
    public Memento(JPanel state) { this.state = state; }
    public JPanel getState() { return state; }
}