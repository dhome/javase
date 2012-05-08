package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class PizzaStoreNY extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new PizzaIngredientFactoryNY();
        
        switch (type) {
            case "cheese":
                pizza = new PizzaCheese(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            default:
                //tbd;
        }
        return pizza;
    }
    
}
