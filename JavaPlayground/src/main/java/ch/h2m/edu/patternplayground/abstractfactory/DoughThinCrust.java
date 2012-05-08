package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class DoughThinCrust implements Dough {

    public DoughThinCrust() {
        System.out.println("   " + this.getClass().getSimpleName());
    }
}
