package ch.h2m.edu.postfinance;

import org.junit.BeforeClass;
import java.lang.reflect.Method;
import javax.ws.rs.core.MultivaluedMap;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.util.Calendar;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tdmarti
 */
public class PostFinanceTest {
    
    PostFinance postFinance;
    NcResponse ncRepsonse;
    static String payId;
    static String expiredDate;
    static String orderID;
    
    String amount = "1250";
    String currency = "CHF";
    String cardNo = "4111111111111111";
    String cvc = "999";
    String brand = "VISA";
    String com = "JUnit Testbestellung";
    String cn = "Heinz Marti";
    String email = "heinz.marti@hslu.ch";
    String operation = "SAL";
    
    public PostFinanceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        int monthInt = Calendar.getInstance().get(Calendar.MONTH)+1;
        String month = (monthInt < 10) ? "0" + monthInt : "" + monthInt;
        int yearInt = Calendar.getInstance().get(Calendar.YEAR) + 1;
        String year = (yearInt+"").substring(2);
        expiredDate = month + "/" + year;
        orderID = (new Random().nextInt(8999)+1000)+"";
    }
     

    @Before
    public void setUp() {
        postFinance = new PostFinance();
//        postFinance.PSPID = "HSLUiCompany";
//        postFinance.USERID = "enappstudents";
//        postFinance.PSWD = "Mb%*3Kt9BU";
//        postFinance.CONTENT_TYPE = "application/x-www-form-urlencoded";
//        postFinance.PSPURL_REQUEST = "https://e-payment.postfinance.ch/ncol/test/orderdirect.asp";
//        postFinance.PSPURL_QUERY = "https://e-payment.postfinance.ch/ncol/test/querydirect.asp";
//        postFinance.PSPURL_MAINTENANCE = "https://e-payment.postfinance.ch/ncol/test/maintenancedirect.asp";
//        postFinance.SHA1PWDIN = "hslu!comp@ny.websh0p";        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPSPProcedure() throws Exception {
        invoicingPSP();
        maintenancePSP();
        testQueryPSP();
    }
    
    private void invoicingPSP() throws Exception {
        ncRepsonse = postFinance.invoicingPSP(amount, orderID, currency, cardNo, cvc, expiredDate, brand, com, cn, email);
        assertNotNull(ncRepsonse);
        assertTrue(ncRepsonse.getNcError().equals("0"));
        payId = ncRepsonse.getPayId();
        assertFalse(payId.isEmpty());
    }
    
    private void maintenancePSP() throws Exception {
        assertFalse(payId == null || payId.isEmpty());
        ncRepsonse = postFinance.maintenancePSP(
                payId, "", "DES");
        assertTrue(
                ncRepsonse.getNcStatus().equals("0") ||     // gelöscht
                ncRepsonse.getNcError().equals("50001127")  //doppelte Anfrage
                );
    }
    private void testQueryPSP() throws Exception {
        assertFalse(payId == null || payId.isEmpty());
        ncRepsonse = postFinance.queryPSP(payId, "", "");
        assertTrue(ncRepsonse.getStatus().equals("61"));
    }

    @Test
    public void shaMultiValueMap() throws Exception {
        MultivaluedMap method = new MultivaluedMapImpl();
        method.putSingle("PSPID", postFinance.PSPID);
        method.putSingle("USERID", postFinance.USERID);
        method.putSingle("PSWD", postFinance.PSWD);
        method.putSingle("OPERATION", "RES");

        String complement =
                "OPERATION="  + "RES"                 + postFinance.SHA1PWDIN +
                "PSPID="      + postFinance.PSPID     + postFinance.SHA1PWDIN +
                "PSWD="       + postFinance.PSWD      + postFinance.SHA1PWDIN +
                "USERID="     + postFinance.USERID    + postFinance.SHA1PWDIN +
                "";
        
        Object result = null;
        // Call a private Methode!
        final Method[] methods =
                postFinance.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {
            if (methods[i].getName().equals("sha1Sgnature")) {
                methods[i].setAccessible(true);
                result = methods[i].invoke(postFinance, method);
            }
        }
        assertNotNull(result);
        complement = postFinance.createSHA1(complement);
        assertTrue(complement.equals(result));        
    }
}
