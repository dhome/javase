package ch.h2m.edu.patternplayground.decorator;

/**
 * Clothes.java
 *
 * Created on 08.11.2011, 12:46:31
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Shoes extends CarryDecorator {

    public Shoes(Carry decoratedCarry) {
        super(decoratedCarry);
    }

    @Override
    public float getPrice() {
        return super.getPrice() + 80;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() 
                + itemSeparator 
                + this.getClass().getSimpleName();
    }

}
