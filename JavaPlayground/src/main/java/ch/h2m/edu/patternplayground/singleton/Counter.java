package ch.h2m.edu.patternplayground.singleton;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Counter {
    
    private int count;

    public Counter() {
    }
    
    public int getCount() {
        return count;
    }
    
    public void plusOne() {
        count++;
    }
    
}
