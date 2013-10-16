package viewGUI;

import javax.swing.*;

public class Originator {
    private JPanel state;
   /* lots of memory consumptive private data that is not necessary to define the
    * state and should thus not be saved. Hence the small memento object. */

    public void set(JPanel state) {
        this.state = state;
    }
    public JPanel getState(){
        return state;
    }
    public Memento save() {
        return new Memento(state);
    }
    public void restoreFromMemento(Memento m) {
        state = m.getState();
    }
}