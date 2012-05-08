/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ch.h2m.edu.patternplayground.observer;

import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ConcreteSubjectTest {
    
    public ConcreteSubjectTest() {
    }

    
    @Test
    public void observer() {
        ConcreteSubject subject = new ConcreteSubject();
        ResultGerman rg = new ResultGerman(subject);
        ResultEnglish re = new ResultEnglish(subject);
        
        subject.setState("changes");
        
    }
    
}
