package ch.h2m.edu.patternplayground.observer;

import java.util.ArrayList;

/**
 * ConcreteObservable.java
 *
 * Created on 08.11.2011, 08:08:44
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ConcreteSubject implements Subject {
    
    private ArrayList<Observer> observers = new ArrayList<>();
    private String state;
    
    @Override
    public void registerObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public Object getValue() {
        return state;
    }
    
}
