package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public interface PizzaIngredientFactory {
    
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    
}
