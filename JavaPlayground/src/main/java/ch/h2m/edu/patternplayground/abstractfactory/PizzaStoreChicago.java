package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class PizzaStoreChicago extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryChicago();
        
        switch (type) {
            case "cheese":
                pizza = new PizzaCheese(ingredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
                break;
            default:
                //tbd;
        }
        return pizza;
    }
    
}
