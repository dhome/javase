package ch.h2m.edu.patternplayground.factorymethod;

/**
 *
 * @author Heinz
 */
public class PizzaStoreChicago extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new PizzaChigagoCheese();
            case "pepperoni":
                return new PizzaChigagoPepperoni();
            default:
                return null;
        }
    }
    
}
