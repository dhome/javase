package ch.h2m.edu.platform;

import java.util.Enumeration;
import java.util.Properties;

/**
 * JavaProperties.java
 *
 * Created on 14.11.2011, 10:55:14
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class JavaProperties {

    public JavaProperties() {
    }
    
    public void printJavaSystemProperties() {
        Properties p = System.getProperties();
        Enumeration<Object> keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) p.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
