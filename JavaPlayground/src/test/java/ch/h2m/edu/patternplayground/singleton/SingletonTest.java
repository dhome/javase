/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ch.h2m.edu.patternplayground.singleton;

import org.junit.*;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class SingletonTest {
    
    public SingletonTest() {
    }

    @Test
    public void standardSingleton() {
        SingletonHolder sh1 = SingletonHolder.getInstance();
        sh1.plusOne();
        sh1.plusOne();
        
        SingletonHolder sh2 = SingletonHolder.getInstance();
        System.out.println("SingletonHolder [sh2=" + sh2.getCount() + "]");
        System.out.println("SingletonHolder [sh1=" + sh1.getCount() + "]");
    }
    
    @Test
    public void holderSingleton() {
        SingletonStandard ss1 = SingletonStandard.getInstance();
        ss1.plusOne();
        ss1.plusOne();
        
        SingletonStandard ss2 = SingletonStandard.getInstance();
        System.out.println("SingletonStandard [ss2=" + ss2.getCount() + "]");
        System.out.println("SingletonStandard [ss1=" + ss1.getCount() + "]");
    }
}
