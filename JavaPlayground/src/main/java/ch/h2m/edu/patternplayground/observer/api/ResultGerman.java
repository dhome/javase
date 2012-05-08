package ch.h2m.edu.patternplayground.observer.api;

import java.util.Observable;
import java.util.Observer;


/**
 * ResultGerman.java
 *
 * Created on 08.11.2011, 08:28:42
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ResultGerman implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("aktualisierung [Obeservable=" + o + ",Object=" + arg + "]");
    }
    
}
