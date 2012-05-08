package ch.h2m.edu.patternplayground.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite.java
 *
 * Created on 08.11.2011, 13:40:03
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class MyComposite implements MyComponent {

    private List<MyComponent> components = new ArrayList<>();
    
    
    public void add(MyComponent comp) {
        if (comp != null) {
            components.add(comp);
        }
    }
    
    public void remove(MyComponent comp) {
        components.remove(comp);
    }
    
    @Override
    public void print() {
        for (MyComponent component : components) {
            component.print();
        }
    }
    
}
