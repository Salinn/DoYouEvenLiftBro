package viewGUI;

import java.util.ArrayList;

class Caretaker {
    private ArrayList<Memento> savedStates = new ArrayList<Memento>();

    public void addMemento(Memento m) { savedStates.add(m); }
    public Memento get(int index) { return savedStates.get(index); }
}