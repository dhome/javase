package ch.h2m.edu.patternplayground.decorator;

/**
 * Carry.java
 *
 * Created on 08.11.2011, 10:56:56
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public interface Carry {
    
    public double getWeight();
    public float getPrice();
    public String getDescription();
    
    public void total();
    
}
