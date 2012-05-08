package ch.h2m.edu.patternplayground.factorymethod;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heinz
 */
public abstract class Pizza {
    
    String name;
    String dough; //Teig
    String sauce;
    List<String> toppings = new ArrayList<>();  //Garnierung
    
    void prepare() {
        System.out.println("Preparing " + name );
        System.out.println("Tossing dough");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }
    void bake() {
        System.out.println("Bake for 25minutes at 350°C");
    }
    void cut() {
        System.out.println("Cutting the pizza in diagonal slices");
    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
    
}
