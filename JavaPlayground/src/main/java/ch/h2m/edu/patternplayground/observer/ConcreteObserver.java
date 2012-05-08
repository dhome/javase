package ch.h2m.edu.patternplayground.observer;

/**
 * ConcreteObserver.java
 *
 * Created on 08.11.2011, 08:16:46z
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ConcreteObserver extends Observer{

    @Override
    public void update() {
        System.out.println("i'm called! [" + this.getClass().getName() + "]");
    }    
}
