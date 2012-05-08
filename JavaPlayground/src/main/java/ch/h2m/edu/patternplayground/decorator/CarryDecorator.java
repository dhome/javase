package ch.h2m.edu.patternplayground.decorator;

/**
 * CarryDecorator.java
 *
 * Created on 08.11.2011, 12:39:04
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public abstract class CarryDecorator implements Carry {
    
    protected final Carry decoratedCarry;
    protected String itemSeparator = ", ";

    public CarryDecorator(Carry decoratedCarry) {
        this.decoratedCarry = decoratedCarry;
    }
    
    @Override
    public double getWeight() {
        return decoratedCarry.getWeight();
    }

    @Override
    public float getPrice() {
        return decoratedCarry.getPrice();
    }

    @Override
    public String getDescription() {
        return decoratedCarry.getDescription();
    }

    @Override
    public void total() {
        decoratedCarry.total();
    }
    
}
