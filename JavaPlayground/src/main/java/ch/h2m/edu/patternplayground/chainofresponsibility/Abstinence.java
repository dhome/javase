package ch.h2m.edu.patternplayground.chainofresponsibility;

/**
 * Dinner.java
 *
 * Created on 09.11.2011, 10:56:45
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Abstinence extends Meal {

    public Abstinence() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("Don't Eat!");
    }
   
}
