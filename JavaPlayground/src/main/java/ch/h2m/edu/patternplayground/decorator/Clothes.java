package ch.h2m.edu.patternplayground.decorator;

/**
 * Clothes.java
 *
 * Created on 08.11.2011, 12:46:31
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Clothes extends CarryDecorator {

    public Clothes(Carry decoratedCarry) {
        super(decoratedCarry);
    }

    @Override
    public float getPrice() {
        return super.getPrice() + 50;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() 
                + itemSeparator 
                + this.getClass().getSimpleName();
    }

}
