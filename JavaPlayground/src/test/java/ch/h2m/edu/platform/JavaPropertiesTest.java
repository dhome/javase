package ch.h2m.edu.platform;

import org.junit.Test;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class JavaPropertiesTest {
    
    public JavaPropertiesTest() {
    }

    @Test
    public void testPrintJavaSystemProperties() {
        JavaProperties instance = new JavaProperties();
        instance.printJavaSystemProperties();
    }
}
