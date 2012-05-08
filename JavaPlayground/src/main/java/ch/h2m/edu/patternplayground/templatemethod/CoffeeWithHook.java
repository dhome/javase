package ch.h2m.edu.patternplayground.templatemethod;

/**
 *
 * @author Heinz
 */
public class CoffeeWithHook extends CaffeineBeverage {

    private boolean condiments;
    
    public CoffeeWithHook(boolean condiments) {
        this.condiments = condiments;
    }
    
    

    @Override
    void brew() {
        System.out.println("brew coffee grinds");
    }

    @Override
    void addCondiments() {
        System.out.println("addSugarAndMilk");
    }

    @Override
    boolean customerWantsCondiments() {
        return condiments;
    }
    
    
}
