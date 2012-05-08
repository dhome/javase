package ch.h2m.edu.patternplayground.observer.api;

import java.util.Observable;

/**
 * APIConcreteSubject.java
 *
 * Created on 08.11.2011, 10:42:03
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ConcreteSubject extends Observable {
    
    private String state;
    
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        this.setChanged();
        this.notifyObservers(state);
    }
}
