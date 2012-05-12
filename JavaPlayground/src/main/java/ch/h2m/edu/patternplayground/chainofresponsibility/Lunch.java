package ch.h2m.edu.patternplayground.chainofresponsibility;

/**
 * Dinner.java
 *
 * Created on 09.11.2011, 10:56:45
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Lunch extends Meal {

    public Lunch() {
        super();
    }
        
    @Override
    public void eat() {
        if (getHourOfDate() > 11 && getHourOfDate() < 13) {
            System.out.println("Eating Lunch");
        } else {
            next.eat();
        }
    }
    
}
