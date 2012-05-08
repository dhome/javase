package ch.h2m.edu.patternplayground.composite;

/**
 * Leaf.java
 *
 * Created on 08.11.2011, 13:44:35
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Leaf implements MyComponent {
    
    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }
    
    
}
