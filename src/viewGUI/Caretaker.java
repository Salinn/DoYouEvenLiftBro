package viewGUI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class Caretaker {
	
	private static Caretaker instance = null;
	
    private LinkedList<Memento> savedStates = new LinkedList<Memento>();
    
    //Private create the caretaker.  Use getInstance to get the instance of it
    private Caretaker(){}
    
    public static Caretaker getInstance(){
    	if(instance == null){
    		instance = new Caretaker();
    		return Caretaker.instance;
    	} else {
    		return Caretaker.instance;
    	}
    }

    public void addMemento(Memento m) { 
    	if(savedStates.size()<6){
    		savedStates.add(m); 
    	} else {
    		savedStates.remove();
    		savedStates.add(m);
    	}
    	
    }
    
    public Memento restore() {
    	Memento m;
    	try{
    	m = savedStates.removeLast();
    	System.out.println("Removed Size: " +savedStates.size());
    	} catch (NoSuchElementException e){
    		m = null;
    	}
    	return m; 
    }
}