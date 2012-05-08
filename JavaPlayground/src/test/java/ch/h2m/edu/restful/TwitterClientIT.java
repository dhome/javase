/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ch.h2m.edu.restful;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class TwitterClientIT {
    
    public TwitterClientIT() {
    }
  
    @Test
    public void getTweets() {
        TwitterClient client = new TwitterClient();
        client.updateUserTimeline();
        List<Tweet> tweets = client.getTweets(); 
        assertFalse(tweets.isEmpty());
    }
}
