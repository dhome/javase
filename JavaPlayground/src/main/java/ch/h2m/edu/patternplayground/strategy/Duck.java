package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public abstract class Duck {
    
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck() {
    }

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
        
    public abstract void display();
    
    public void performQuack() {
        quackBehavior.quack();
    }
    
    public void fly() {
        flyBehavior.fly();
    }
    
}
