package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super(
                new FlyNoWay(), 
                new QuackSquezze()
                );
    }

    @Override
    public void display() {
        System.out.println("DISPLAY: " + getClass().getSimpleName());
    }
    
}
