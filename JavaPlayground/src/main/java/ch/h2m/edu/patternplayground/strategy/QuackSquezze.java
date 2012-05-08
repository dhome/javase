package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public class QuackSquezze implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(getClass().getSimpleName());
    }
    
}
