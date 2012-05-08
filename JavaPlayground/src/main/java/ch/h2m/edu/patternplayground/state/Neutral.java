package ch.h2m.edu.patternplayground.state;

/**
 *
 * @author Heinz
 */
public class Neutral implements State {

    private Mood mood;

    public Neutral(Mood mood) {
        this.mood = mood;
    }

    @Override
    public void handle() {
        System.out.println("mmmhhh");
    }    
    
    @Override
    public void compliment() {
        mood.setCurrentMood(mood.getHappy());
    }

    @Override
    public void animadvert() {
        mood.setCurrentMood(mood.getSad()); 
    }
    
}
