package ch.h2m.edu.patternplayground.observer;

/**
 * Observer.java
 *
 * Created on 08.11.2011, 08:07:00
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public interface Subject {

  public void registerObserver(Observer obsrNewObserver);
  public void unregisterObserver(Observer obsrToRemove);
  public void notifyObservers();
  public Object getValue();
    
}
