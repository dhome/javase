package ch.h2m.edu.patternplayground.state;

/**
 *
 * @author Heinz
 */
public class Sadness implements State {

    private Mood mood;

    public Sadness(Mood mood) {
        this.mood = mood;
    }
    
    @Override
    public void handle() {
        System.out.println("schlucht's");
    }

    @Override
    public void compliment() {
        mood.setCurrentMood(mood.getNeutral());
    }

    @Override
    public void animadvert() {
        System.out.println("I'm already sad!");
    }
    
}
