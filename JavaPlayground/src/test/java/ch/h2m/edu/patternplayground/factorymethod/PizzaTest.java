package ch.h2m.edu.patternplayground.factorymethod;

import org.junit.Test;

/**
 *
 * @author Heinz
 */
public class PizzaTest {
    
    @Test
    public void bakeNYPizzaCheese() {
        PizzaStore nyStore = new PizzaStoreNY();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
    
    @Test
    public void bakeNYPizzaPepperoni() {
        PizzaStore nyStore = new PizzaStoreNY();
        Pizza pizza = nyStore.orderPizza("pepperoni");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
    
    @Test
    public void bakeChicagoPizzaCheese() {
        PizzaStore chicagoStore = new PizzaStoreChicago();
        Pizza pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
    
    @Test
    public void bakeChicagoPizzaPepperoni() {
        PizzaStore chicagoStore = new PizzaStoreChicago();
        Pizza pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("Pizza Tester ordered a " + pizza.getName());
        System.out.println("=========================================");
    }
}
