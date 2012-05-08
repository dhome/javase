package ch.h2m.edu.patternplayground.observer.api;

import java.util.Observer;
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
        ConcreteSubject subj = new ConcreteSubject();
        Observer english = new ResultEnglish();
        Observer german = new ResultGerman();
        
        subj.addObserver(english);
        subj.addObserver(german);
        
        subj.setState("API Observer");
        
    }
}
