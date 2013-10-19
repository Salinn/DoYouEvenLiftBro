package viewGUI;

import java.util.ArrayList;
import java.util.LinkedList;

class Caretaker {
    private LinkedList<Memento> savedStates = new LinkedList<Memento>();

    public void addMemento(Memento m) { savedStates.add(m); }
    public Memento get(int index) { return savedStates.get(index); }
}