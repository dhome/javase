package ch.h2m.edu.patternplayground.decorator;

/**
 * Clothes.java
 *
 * Created on 08.11.2011, 12:46:31
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Laptop extends CarryDecorator {

    public Laptop(Carry decoratedCarry) {
        super(decoratedCarry);
    }

    @Override
    public float getPrice() {
        return super.getPrice() + 800;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + 1.3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() 
                + itemSeparator 
                + this.getClass().getSimpleName();
    }

}
