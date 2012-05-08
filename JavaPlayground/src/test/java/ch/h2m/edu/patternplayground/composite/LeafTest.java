package ch.h2m.edu.patternplayground.composite;

import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class LeafTest {
    
    public LeafTest() {
    }

    @Test
    public void composite() {
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        
        MyComposite treeComp = new MyComposite();
        MyComposite elementComp = new MyComposite();
        elementComp.add(leaf2);
        
        treeComp.add(leaf1);
        treeComp.add(elementComp);
        
        treeComp.print();
    }
}
