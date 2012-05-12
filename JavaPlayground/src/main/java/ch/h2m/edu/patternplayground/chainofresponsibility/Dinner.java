package ch.h2m.edu.patternplayground.chainofresponsibility;

/**
 * Dinner.java
 *
 * Created on 09.11.2011, 10:56:45
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Dinner extends Meal {

    public Dinner() {
        super();
    }
    
    @Override
    public void eat() {
        if (getHourOfDate() > 17 && getHourOfDate() < 20) {
            System.out.println("Eating Dinner");
        } else {
            next.eat();
        }
    }
}
