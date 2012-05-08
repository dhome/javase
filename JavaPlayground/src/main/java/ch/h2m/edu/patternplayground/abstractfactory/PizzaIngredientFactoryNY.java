package ch.h2m.edu.patternplayground.abstractfactory;

/**
 *
 * @author Heinz
 */
public class PizzaIngredientFactoryNY implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new DoughThinCrust();
    }

    @Override
    public Sauce createSauce() {
        return new SauceMarinara();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseReggiano();
    }

}
