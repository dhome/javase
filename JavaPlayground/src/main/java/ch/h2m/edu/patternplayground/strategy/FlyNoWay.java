package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName());
    }
    
}
