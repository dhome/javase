package ch.h2m.edu.patternplayground.chainofresponsibility;

import java.util.Calendar;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public abstract class Meal {

    public Meal() {
    }
    
    protected  Meal next;
    
    protected int getHourOfDate() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }
    
    protected Meal setNext(Meal meal){
        next = meal;
        return this;
    }
    
    abstract void eat();
    
}
