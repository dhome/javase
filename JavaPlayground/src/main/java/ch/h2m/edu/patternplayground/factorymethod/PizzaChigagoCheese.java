package ch.h2m.edu.patternplayground.factorymethod;

/**
 *
 * @author Heinz
 */
public class PizzaChigagoCheese extends Pizza {

    public PizzaChigagoCheese() {
        name = "Chigago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        
        toppings.add("Shredded Mozzarella Cheese");
    }
    
    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
    
    
}
