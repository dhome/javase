package ch.h2m.edu.patternplayground.chainofresponsibility;

import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class MealTest {
    
    public MealTest() {
    }

    @Test
    public void hungry() {
        Meal m = new Breakfast()
                .setNext(new Lunch()
                    .setNext(new Dinner()
                        .setNext(new Abstinence()
                        )
                    )
                );
        m.eat();
    }

}
