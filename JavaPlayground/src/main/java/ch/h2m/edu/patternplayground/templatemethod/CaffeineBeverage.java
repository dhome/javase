package ch.h2m.edu.patternplayground.templatemethod;

/**
 *
 * @author Heinz
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void pourInCup() {
        System.out.println("pour in cup");
    }

    void boilWater() {
        System.out.println("boiling Water");
    }

    abstract void brew();
    abstract void addCondiments();

    /**
     * Hook Method.
     * Can be overwritten by SubClasses
     * @return 
     */
    boolean customerWantsCondiments() {
        return true;
    }
    
}
