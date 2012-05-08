package ch.h2m.edu.patternplayground.decorator;

/**
 * Clothes.java
 *
 * Created on 08.11.2011, 12:46:31
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Books extends CarryDecorator {

    public Books(Carry decoratedCarry) {
        super(decoratedCarry);
    }

    @Override
    public float getPrice() {
        return super.getPrice() + 20;
    }

    @Override
    public double getWeight() {
        return super.getWeight() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() 
                + itemSeparator 
                + this.getClass().getSimpleName();
    }

}
