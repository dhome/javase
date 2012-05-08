package ch.h2m.edu.patternplayground.abstractfactory;

import org.junit.Test;

/**
 *
 * @author Heinz
 */
public class PizzaStoreTest {
    
    public PizzaStoreTest() {
    }

    @Test
    public void orderNYCheesePizza() {
        PizzaStore pizzaStore = new PizzaStoreNY();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
    
    @Test
    public void orderChicagoCheesePizza() {
        PizzaStore pizzaStore = new PizzaStoreChicago();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
}
