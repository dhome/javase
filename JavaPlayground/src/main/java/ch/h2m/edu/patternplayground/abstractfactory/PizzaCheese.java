package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class PizzaCheese extends Pizza {
    
    PizzaIngredientFactory ingredientFactory;

    public PizzaCheese(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
    
}
