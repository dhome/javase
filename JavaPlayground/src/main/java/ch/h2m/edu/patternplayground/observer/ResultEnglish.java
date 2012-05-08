package ch.h2m.edu.patternplayground.observer;

/**
 * ResultGerman.java
 *
 * Created on 08.11.2011, 08:28:42
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class ResultEnglish extends Observer {

    public ResultEnglish(Subject subject) {
        this.subj = subject;
        subj.registerObserver(this);
    }    
    
    @Override
    public void update() {
        System.out.println("Something has changed! ["
                + subj.getValue().toString() 
                + "]");
    }
    
}
