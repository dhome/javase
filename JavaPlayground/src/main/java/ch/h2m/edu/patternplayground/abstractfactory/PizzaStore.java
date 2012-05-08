package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public abstract class PizzaStore {
    
    abstract Pizza createPizza(String type);
    
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
}
