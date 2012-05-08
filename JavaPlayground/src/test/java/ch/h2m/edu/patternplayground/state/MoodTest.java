package ch.h2m.edu.patternplayground.state;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Heinz
 */
public class MoodTest {
    
    public MoodTest() {
    }

    @Test
    public void riseMood() {
        System.out.println("---riseMood");
        Mood m = new Mood();
        m.compliment();
        m.compliment();
    }

    @Test
    public void getDownMood() {
        System.out.println("---getDownMood");
        Mood m = new Mood();
        m.animadvert();
        m.animadvert(); 
    }

    @Test
    public void moodyday() {
        System.out.println("---moodyday");
        Mood m = new Mood();
        m.animadvert();
        m.compliment();
        m.compliment();
        m.animadvert(); 
        m.animadvert();
        m.compliment(); 
    }

    
}
