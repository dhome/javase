package ch.h2m.edu.restful;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * TwitterClient.java
 *
 * Created on 24.11.2011, 11:12:45
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class TwitterClient {
    
    private static final String ACCESS_OAUTH_TOKEN = "153711594-AsOLmpFqnrhmH47eYbpvknaShhwftYHFxLQZ6dTZ";
    private static final String ACCESS_OAUTH_TOKEN_SECRET = "EzJ770sdkU9IcUVSnYW4t2KetdmC4R4Q05uKuXe3h4";
    private static final String BASE_URI = "http://api.twitter.com";
    
    private List<Tweet> tweets;

    public TwitterClient() {
        tweets = new ArrayList<>();
    }
    
    public void initCache(){
        this.tweets = new ArrayList<Tweet>();
        updateUserTimeline();
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
    
    public void updateUserTimeline() {
        tweets.clear();
        Client client = Client.create();

        // Set the OAuth parameters
        OAuthParameters params = new OAuthParameters()
                .signatureMethod("HMAC-SHA1")
                .version("1.0")
                .token(ACCESS_OAUTH_TOKEN);
        
        OAuthSecrets secrets = new OAuthSecrets()
                .tokenSecret(ACCESS_OAUTH_TOKEN_SECRET);
        
        // Create the OAuth client filter
        OAuthClientFilter oauthFilter =
                new OAuthClientFilter(client.getProviders(), params, secrets);

        // Create a resource to be used to make Twitter API calls
        String resourcePath = "1/statuses/user_timeline.json";
        WebResource resource = client.resource(BASE_URI).path(resourcePath).queryParam("count", "5");
                
        // Add the filter to the resource
        resource.addFilter(oauthFilter);
                
        // Parse the JSON array
        JSONArray jsonArray = resource.get(JSONArray.class);
        
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                tweets.add(new Tweet(
                        jsonObject.getString("id"),
                        jsonObject.getString("text"),
                        jsonObject.getString("created_at")
                        ));
            }
        } catch (JSONException ex) {
//            logger.severe(ex.getMessage());
        }
    }    
    
    
}
