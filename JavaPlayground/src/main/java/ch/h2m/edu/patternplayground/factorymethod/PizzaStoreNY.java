package ch.h2m.edu.patternplayground.factorymethod;

/**
 *
 * @author Heinz
 */
public class PizzaStoreNY extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new PizzaNYCheese();
            case "pepperoni":
                return new PizzaNYPepperoni();
            default:
                return null;
        }
    }
    
}
