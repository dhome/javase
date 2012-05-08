package ch.h2m.edu.patternplayground.templatemethod;

/**
 *
 * @author Heinz
 */
public class Coffee extends CaffeineBeverage {
    
    @Override
    void brew() {
        System.out.println("brew coffee grinds");
    }

    @Override
    void addCondiments() {
        System.out.println("addSugarAndMilk");
    }
    
}
