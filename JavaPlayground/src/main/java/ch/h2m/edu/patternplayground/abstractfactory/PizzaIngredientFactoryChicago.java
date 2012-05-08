package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class PizzaIngredientFactoryChicago implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new DoughThickCrust();
    }

    @Override
    public Sauce createSauce() {
        return new SaucePlumTomato();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseMozzarella();
    }

}
