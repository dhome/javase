package ch.h2m.edu.patternplayground.decorator;

/**
 * CarryingCase.java
 *
 * Created on 08.11.2011, 12:36:30
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Backbag implements Carry {

    @Override
    public double getWeight() {
        return 0.4;
    }

    @Override
    public float getPrice() {
        return 180;
    }

    @Override
    public String getDescription() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void total() {
        //tbd
    }
    
}
