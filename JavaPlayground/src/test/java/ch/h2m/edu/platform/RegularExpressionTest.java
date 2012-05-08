package ch.h2m.edu.platform;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class RegularExpressionTest {
    
    public RegularExpressionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void validateUserName() {
        List<String> usernamesValid = Arrays.asList("tdmarti", "hallo");
        List<String> usernamesInValid = Arrays.asList("", "@asbdf", "s¨!bdf", "looooooooooooooooooooooooooooooooooooo");
        RegularExpression instance = new RegularExpression();
        for (String string : usernamesValid) {
            assertTrue(instance.validateUserName(string));
        }
        for (String string : usernamesInValid) {
            assertFalse(instance.validateUserName(string));
        }
    }

    @Test
    public void validatePassword() {        
        List<String> pwdValid = Arrays.asList("&7sdf!@A", "aChar#9");
        List<String> pwdsInValid = Arrays.asList("", "dsklsöfalksfA", "einfach");
        RegularExpression instance = new RegularExpression();        
        for (String string : pwdValid) {
            assertTrue(instance.validatePassword(string));
        }
        for (String string : pwdsInValid) {
            assertFalse(instance.validatePassword(string));
        }
    }
    
    @Test
    public void validateEmail() {        
        List<String> eMailValid = Arrays.asList("heinz@h2m.ch", "dasisteine.sehr_lange@addrese.li");
        List<String> eMailInValid = Arrays.asList("h@h2m", "Aber?@sf.com", "@sadfd", "");
        RegularExpression instance = new RegularExpression();        
        for (String string : eMailValid) {
            assertTrue(instance.validateEmail(string));
        }
        for (String string : eMailInValid) {
            assertFalse(instance.validateEmail(string));
        }
    }
    
    @Test
    public void validateDate() {        
        List<String> dateValid = Arrays.asList("08/01/1985", "31/12/2010", "01/01/2000", "1/1/2001", "29/02/1804", "29/02/2080");
        List<String> dateInValid = Arrays.asList("12/13/2011", "12/12", "", "2000", "29/02/2001");
        RegularExpression instance = new RegularExpression();        
        for (String string : dateValid) {
            assertTrue(instance.validateDate(string));
        }
        for (String string : dateInValid) {
            assertFalse(instance.validateDate(string));
        }
    }
    
    @Test
    public void validateCreditCard() {        
        List<String> ccValid = Arrays.asList("4111111111111111", "5399999999999999", "36255695580017");
        List<String> ccInValid = Arrays.asList("41111111111", "129999999999999", "2000", "12345657891234432546");
        RegularExpression instance = new RegularExpression();        
        for (String string : ccValid) {
            assertTrue(instance.validateCreditCard(string));
        }
        for (String string : ccInValid) {
            assertFalse(instance.validateCreditCard(string));
        }
    }
}
