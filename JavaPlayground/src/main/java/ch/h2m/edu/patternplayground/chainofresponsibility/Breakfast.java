package ch.h2m.edu.patternplayground.chainofresponsibility;


/**
 * Breakfast.java
 *
 * Created on 09.11.2011, 10:56:08
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Breakfast extends Meal {

    public Breakfast() {
        super();
    }
    
    
    @Override
    public void eat() {
        if (getHourOfDate() > 6 && getHourOfDate() < 8) {
            System.out.println("Eating breakfast");
        } else {
            next.eat();
        }
    }
    
}
