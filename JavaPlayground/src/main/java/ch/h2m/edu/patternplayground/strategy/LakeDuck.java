package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public class LakeDuck extends Duck {

    public LakeDuck() {
        super(
                new FlyWithWings(), 
                new Quack()
                );
    }

    @Override
    public void display() {
        System.out.println("DISPLAY: " + getClass().getSimpleName());
    }
    
}
