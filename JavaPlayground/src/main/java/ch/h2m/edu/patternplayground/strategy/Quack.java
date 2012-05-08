/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ch.h2m.edu.patternplayground.strategy;

/**
 *
 * @author Heinz
 */
public class Quack implements QuackBehavior {
    
    @Override
    public void quack() {
        System.out.println(getClass().getSimpleName());
    }
    
}
