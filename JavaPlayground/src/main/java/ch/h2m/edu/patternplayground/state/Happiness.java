package ch.h2m.edu.patternplayground.state;

/**
 *
 * @author Heinz
 */
public class Happiness implements State {

    private Mood mood;
    
    public Happiness(Mood mood) {
        this.mood = mood;
    }

    @Override
    public void handle() {
        System.out.println("Judihuiiii");
    }

    @Override
    public void compliment() {
        System.out.println("I'm already happy!");
    }

    @Override
    public void animadvert() {
        mood.setCurrentMood(mood.getNeutral());
    }
    
}
