package ch.h2m.edu.patternplayground.observer;

/**
 * Observer.java
 *
 * Created on 08.11.2011, 08:07:00
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public abstract class Observer {

    protected Subject subj;
    
    public abstract void update();    

}
