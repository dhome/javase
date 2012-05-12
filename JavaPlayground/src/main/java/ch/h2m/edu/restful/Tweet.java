package ch.h2m.edu.restful;

/**
 * Tweet.java
 *
 * Created on 24.11.2011, 11:13:37
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class Tweet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public Tweet(String id, String text, String createAt) {
        this.id = id;
        this.text = text;
        //TODO: Parse as a Date
        this.createAt = createAt;
    }
    
    private String id;
    private String text;
    private String createAt;

    public String getCreateAt() {
        return createAt;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() 
                + "[id=" + id
                + ", text=" + text
                + ", createAt="+createAt
                + "]";
    }
   
}

