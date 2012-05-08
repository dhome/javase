package ch.h2m.edu.patternplayground.strategy;

import org.junit.Test;


/**
 *
 * @author Heinz
 */
public class DuckTest {
        
    @Test
    public void LakeDuck() {
        Duck duck = new LakeDuck();
        duck.display();
        duck.fly();
        duck.performQuack();
        System.out.println("============");
        
    }
    @Test
    public void RubberDuck() {
        Duck duck = new RubberDuck();
        duck.display();
        duck.fly();
        duck.performQuack();
        System.out.println("============");
    }
}
