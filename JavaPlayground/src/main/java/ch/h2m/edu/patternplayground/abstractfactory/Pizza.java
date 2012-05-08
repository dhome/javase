package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public abstract class Pizza {
    
    String name;
    Dough dough; //Teig
    Sauce sauce;
    Cheese cheese;
    
    abstract void prepare();
    
    void bake() {
        System.out.println("Bake for 25minutes at 350°C");
    }
    void cut() {
        System.out.println("Cutting the pizza in diagonal slices");
    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    
    String getName() {
        return name;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Code to print pizza";
    }
    
}
