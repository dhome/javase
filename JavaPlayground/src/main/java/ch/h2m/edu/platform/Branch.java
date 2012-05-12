package ch.h2m.edu.platform;

    
/**
 *
 * @author tdmarti
 */
public class Branch {

    public Branch() {
    }
    
    public boolean ifcheckUnequal(String value1, String value2) {
        //hahaha ;-)
        return (value1 == null ? value2 != null : !value1.equals(value2));
    }
    
    public boolean nullcheck(String bla) {
        return ("bla".equals(bla));
    }
    
}
