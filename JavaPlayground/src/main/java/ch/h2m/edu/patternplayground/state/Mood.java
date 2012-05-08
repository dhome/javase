package ch.h2m.edu.patternplayground.state;

/**
 *
 * @author Heinz
 */
public class Mood {
    
    State currentMood;
    
    private final State happy;
    private final State sad;
    private final State neutral;

    public Mood() {
        happy = new Happiness(this);
        sad = new Sadness(this);
        neutral = new Neutral(this);
        
        currentMood = neutral;
    }

    public State getCurrentMood() {
        return currentMood;
    }

    public void setCurrentMood(State currentMood) {
        this.currentMood = currentMood;
        currentMood.handle();
    }

    public State getHappy() {
        return happy;
    }

    public State getNeutral() {
        return neutral;
    }

    public State getSad() {
        return sad;
    }
    
    
    public void compliment() {
        currentMood.compliment();
    }   
    
    public void animadvert() {
        currentMood.animadvert();
        
    }
    
}
