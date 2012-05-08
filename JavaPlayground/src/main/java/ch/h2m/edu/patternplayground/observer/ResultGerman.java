package ch.h2m.edu.patternplayground.observer;

/**
 * ResultGerman.java
 *
 * Created on 08.11.2011, 08:28:42
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ResultGerman extends Observer {

    public ResultGerman(Subject subject) {
        this.subj = subject;
        subj.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Es hat sich was geändert! ["
                + subj.getValue().toString() 
                + "]");
    }
    
}
