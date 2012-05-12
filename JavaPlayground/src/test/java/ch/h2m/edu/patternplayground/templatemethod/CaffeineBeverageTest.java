package ch.h2m.edu.patternplayground.templatemethod;

import org.junit.*;

/**
 *
 * @author Heinz
 */
public class CaffeineBeverageTest {
    
    public CaffeineBeverageTest() {
    }

    @Test
    public void createCoffee() {
        System.out.println("Create Coffee------");
        CaffeineBeverage cb = new Coffee();
        cb.prepareRecipe();
    }
    @Test
    public void createCoffeeWithoutCondiments() {
        System.out.println("");
        System.out.println("Create Coffee without Contiments ------");
        CaffeineBeverage cb = new CoffeeWithHook(false);
        cb.prepareRecipe();
    }

    @Test
    public void createTea() {
        System.out.println("");
        System.out.println("Create Tea------");
        CaffeineBeverage cb = new Tea();
        cb.prepareRecipe();
    }
   
}
