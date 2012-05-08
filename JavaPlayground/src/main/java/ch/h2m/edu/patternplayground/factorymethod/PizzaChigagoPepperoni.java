package ch.h2m.edu.patternplayground.factorymethod;

/**
 *
 * @author Heinz
 */
public class PizzaChigagoPepperoni extends Pizza {

    public PizzaChigagoPepperoni() {
        name = "Chigago Style Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        
        toppings.add("Shredded Pepperoni");
    }
    
    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
