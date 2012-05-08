package ch.h2m.edu.patternplayground.decorator;

import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class CarryTest {
    
    public CarryTest() {
    }

    /**
     * Test of getWeight method, of class Carry.
     */
    @Test
    public void backBag() {
        Carry backback = new Backbag();
        backback = new Books(backback);
        backback = new Clothes(backback);
        backback = new Laptop(backback);
        System.out.println(backback.getDescription());
        System.out.println("price=" + backback.getPrice());
        System.out.println("weight=" + backback.getWeight());
    }
    
    @Test
    public void carryingCase() {
        Carry carryingCase = new CarryingCase();
        carryingCase = new Books(carryingCase);
        carryingCase = new Clothes(carryingCase);
        carryingCase = new Laptop(carryingCase);
        carryingCase = new Shoes(carryingCase);
        System.out.println(carryingCase.getDescription());
        System.out.println("price=" + carryingCase.getPrice());
        System.out.println("weight=" + carryingCase.getWeight());
    }
}
