package ch.h2m.edu.postfinance;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @since 29.07.2010
 * @author Res Gilgen
 * @author Heinz Marti
 */
public class PostFinance {
    
    String SHA1PWDIN = "hslu!comp@ny.websh0p";
    String PSPID = "HSLUiCompany";
    String USERID = "enappstudents";
    String PSWD = "Mb%*3Kt9BU";
    String CONTENT_TYPE = "application/x-www-form-urlencoded";
    String PSPURL_REQUEST = "https://e-payment.postfinance.ch/ncol/test/orderdirect.asp";
    String PSPURL_QUERY = "https://e-payment.postfinance.ch/ncol/test/querydirect.asp";
    String PSPURL_MAINTENANCE = "https://e-payment.postfinance.ch/ncol/test/maintenancedirect.asp";
    
    
    /**
     * Call the payment service provider with an order and store the result in
     * history. This method would be used for DirectLink.
     *
     * @param amount
     * Amount of the transaction. When the amount is sent as input,
     * it has to be multiplied by 100 to avoid decimal separator
     * problems. In general, the acquirer accepts up to 2 decimals,
     * depending on the currency. Sent: 12995; Returned: 129.95
     * <br/>
     * @param orderID
     * Your order number (merchant reference). This reference is
     * generally used by the merchant to look up his transaction in
     * the back office. For online, 3-tiers mode, the system also
     * uses this reference to check if a payment is not requested
     * twice for the same order. On request of the merchant the
     * period of this check can be shortened or the check can be
     * disabled. <br/>If the acquirer is technically able to process the
     * transaction, and if there's no special configuration in the
     * account, this orderID will be sent to the acquirer as
     * reference (ref2) for the transaction. In this case the
     * merchant will receive this ref2 field on his account
     * statements, helping him reconcile his transactions. Although
     * our system can accept up to 30 characters, the norm for most
     * acquirers is 10 or 12. The exact accepted length and data
     * validation format depend on the acquirer/bank.If the orderID
     * does not comply to the ref2 rules set by the acquirer, we'll
     * send our PAYID as ref2 to the acquirer instead. Avoid using
     * spaces or special characters in the orderID.
     * <br/>
     * @param currency
     * Currency of the transaction. Currency of the amount in
     * alphabetic ISO code as can be found on <a href="
     * http://www.iso.org/iso/en
     * /prods-services/popstds/currencycodeslist.html">currencycodelist</a> 
     * The possible currencies on our platform are: <br/>
     * AED, ANG, ARS, AUD, AWG, BGN,
     * BRL, BYR, CAD, CHF, CNY, CZK, DKK, EEK, EGP, EUR, GBP, GEL,
     * HKD, HRK, HUF, ILS, ISK, JPY, KRW, LTL, LVL, MAD, MXN, NOK,
     * NZD, PLN, RON, RUB, SEK, SGD, SKK, THB, TRY, UAH, USD, XAF,
     * XOF, XPF and ZAR. <br/><br/>If a merchant wants to accept payments in a
     * currency that is not in our list, he can ask us to add the
     * currency. The currencies a merchant can accept payments in
     * depend on the contract with his acquirer. If the merchant
     * wants to accept a currency that is not supported by his
     * acquirer, we can set a dynamic currency conversion on our side
     * (this is a paying option).
     * <br/>
     * @param cardNo
     * Card number or account number. The rules on how our system has
     * to mask credit card numbers - in any output, display or email
     * - are set by PCI.<br/> For VISA, VISA PC, MASTERCARD, MASTERCARD PC
     * and MASTERCARD PC CM CIC the 4 last digits will be visible.<br/><br/>
     * For all other brands/payment methods the part that is masked
     * depends on the length of the card number or account number: If
     * the number is longer than 15 digits: the 6 first and 2 last
     * digits are visible, with xxxxxxxx (8x) in the middle. <br/><br/>If the
     * number is from 12 to 15 digits long: the first 4 and last 2
     * digits are visible, with xxxxxx (6x) in the middle. <br/>If the
     * number is from 8 to 11 digits long: the first 2 and last 2
     * digits are visible, with xxxx (4x) in the middle. <br/>If the
     * number is from 4 to 7 digits long: the first and last digit is
     * visible, with xx (2x) in the middle. <br/>If the number is less
     * than 4 digits long, the whole number will be masked. <br/><br/>
     * The account number will never be visible for offline bank
     * transfer and Payment on Delivery. <br/>
     * The account number for Direct Debits transactions will be
     * masked when the transaction is in status 4 – order stored, if
     * the buyer has to send a signed fax to confirm the payment.
     * <br/>
     * @param cvc
     * Card Validation Code. This verification code is an
     * authentication code uniquely linked to the card number, but is
     * not part of the card number itself. Depending on the brand,
     * this code has a different name (CVC2 or Card Validation Code
     * for MasterCard, CVV2 or Card Verification Value for VISA, CID
     * or Card Identification Number for American Express). However,
     * the code is generally referred to as "CVC". Depending on the
     * card brand, the verification code will be a 3 or 4 digit code
     * on the front or rear of the card, an issue number, a start
     * date or a date of birth:<br/>
     *
     * VISA and MasterCard: 3 digit code on the rear of the card on
     * the signature strip (after the full customer account number or
     * after the last 4 digits of the customer account number).<br/>
     *
     * American Express: 4 digit code above the account number on the
     * front of the card.<br/>
     *
     * Switch/Solo: issue number (from 1 to 12) or the start date
     * (MM/YY).<br/>
     *
     * Aurora, Aurore and Cofinoga: birth date (DD/MM/YYYY or
     * DDMMYYYY).
     * <br/>
     * @param ed
     * Expiry date. This date must not be in the past, compared to
     * the date the transaction is processed in our system. When
     * there is no expiry date available (e.g. for bank transfers)
     * the value 9999 is used.<br/>
     * Example: "12/09".
     * <br/>
     * @param brand
     * Brand of a credit/debit/purchasing card. You can consult a
     * list of BRAND values on the Payment Methods
     * Processing/Procedure page If you send the BRAND field without
     * sending a value in the PM field (‘CreditCard' or ‘Purchasing
     * Card'), the BRAND value will not be taken into account.
     * <br/>
     * @param com
     * Order description The com field is sometimes transmitted to
     * the acquirer (depending on the acquirer), in order to be shown
     * on the account statements of the merchant or the customer.
     * <br/>
     * @param cn
     * Card holder (customer) name. Special characters are allowed,
     * but quotes must be avoided. Most acquirers don't check the
     * customer name since names can be written in different ways.
     * <br/>
     * @param email
     * Customer's email address.
     * <br/>
     * @return Response object. Each Attribute is a field
     * @throws HttpException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public NcResponse invoicingPSP(String amount, String orderID, String currency,
            String cardNo, String cvc, String ed, String brand, String com,
            String cn, String email)
            throws IOException, NoSuchAlgorithmException, JAXBException {
        MultivaluedMap method = new MultivaluedMapImpl();
        method.add("PSPID", PSPID);
        method.add("USERID", USERID);
        method.add("PSWD", PSWD);
        method.add("ORDERID", orderID);
        method.add("AMOUNT", amount);
        method.add("CURRENCY", currency);

        method.add("CARDNO", cardNo);
        method.add("ED", ed);
        method.add("CVC", cvc);

        method.add("BRAND", brand);
        method.add("COM", com);
        method.add("CN", cn);
        method.add("EMAIL", email);
        method.add("OPERATION", "RES");

        String sha1Signature = sha1Sgnature(method);

        method.add("SHASign", sha1Signature);

        return callPSP(PSPURL_REQUEST, method);
    }

    /**
     * Call the Postfinance Payment System
     * @param url Service URL
     * @param method Post Parameter
     * @return NcResponse from Postfinance
     * @throws JAXBException Response from Postfinance do not match with Object NcResponse
     */
    private NcResponse callPSP(String url, MultivaluedMap method) throws JAXBException {
        NcResponse response = null;
        String xmlResponse = null;
        
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse clientResponse = webResource.type(CONTENT_TYPE)
                .post(ClientResponse.class, method);

        int status = clientResponse.getStatus();
        if (ClientResponse.Status.OK.getStatusCode() == status) {
            xmlResponse = clientResponse.getEntity(String.class);
            response = parseResponse(xmlResponse);
        } else {
//            logger.log(Level.SEVERE, "ClientResponse status not OK\n Status={0}", status);
        }
        return response;
    }

    /**
     * Payment status check
     *
     * payId <strong>or</strong> orderId is required
     *
     * @param payId Payid from Post
     * @param orderId webshop orderId
     * @param PayIdSub SubId from Payment. payid from a sub transaction on the same payment
     * @return NcResponse from Postfinance
     * @throws JAXBException Response from Postfinance do not match with Object NcResponse
     * @throws Exception payId nor orderId are not set
     */
    public NcResponse queryPSP(String payId, String orderId, String PayIdSub) throws JAXBException, Exception {
        if (orderId.isEmpty() && payId.isEmpty()) {
            throw new Exception("set at least orderId or payId");
        }
        MultivaluedMap method = new MultivaluedMapImpl();
        method.add("PSPID", PSPID);
        method.add("USERID", USERID);
        method.add("PSWD", PSWD);
        if (!orderId.isEmpty()) {
            method.add("ORDERID", orderId);
        }
        if (!payId.isEmpty()) {
            method.add("PAYID", payId);
            if (!PayIdSub.isEmpty()) {
                method.add("PAYIDSUB", PayIdSub);
            }
        }
        String sha1Signature = sha1Sgnature(method);
        method.add("SHASign", sha1Signature);
        return callPSP(PSPURL_QUERY, method);
    }

    /**
     * Process single payment by the postfinance
     *
     * payId <strong>or</strong> orderId is required
     *
     * @param payId Payid from Post
     * @param orderId webshop orderId
     * @param operation which is a kind of MAINTENANCE_OPERATION
     * @return NcResponse from Postfinance
     * @throws JAXBException Response from Postfinance do not match with Object NcResponse
     * @throws Exception payId nor orderId are not set
     */
    public NcResponse maintenancePSP(String payId, String orderId, String operation) throws JAXBException, Exception {
        if (orderId.isEmpty() && payId.isEmpty()) {
            throw new Exception("set at least orderId or payId");
        }

        MultivaluedMap method = new MultivaluedMapImpl();
        method.add("PSPID", PSPID);
        method.add("USERID", USERID);
        method.add("PSWD", PSWD);
        if (!orderId.isEmpty()) {
            method.add("ORDERID", orderId);
        }
        if (!payId.isEmpty()) {
            method.add("PAYID", payId);
        }
        method.add("OPERATION", operation + "");

        String sha1Signature = sha1Sgnature(method);
        method.add("SHASign", sha1Signature);
        return callPSP(PSPURL_MAINTENANCE, method);
    }

    /**
     * Signs the POST-Parameters.
     *
     * sha1Signature, if "Each parameter followed by the pass phrase"
     * activated in the post finance portal.
     *
     * @see https://e-payment.postfinance.ch/ncol/PostFinance_DirectLink_EN.pdf
     *
     * @param method MultivaluedMap sended to Post Finance
     * @return SHA1 encoded and sorted String of the MulitvaluedMap
     *                (key+"="+value+Util.SHA1PWDIN)
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private String sha1Sgnature(final MultivaluedMap method)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String encoded = "";
        StringBuilder buf = new StringBuilder();
        SortedSet<String> sortedSet = new TreeSet<String>(method.keySet());
        for (String s : sortedSet) {
            buf.append(s)
                    .append("=")
                    .append(((List<String>) method.get(s)).get(0))
                    .append(SHA1PWDIN);
        }
        encoded = createSHA1(buf.toString());
        return encoded;
    }
    /**
     * Parse a string to an object.
     *
     * Parse the received xml based string from post finance to a NcResponse
     * Object.
     *
     * @param response xml reponse String
     * @return The object that represents the xml-postback.
     * @throws Unmarshaller execption. The String is not valid
     */
    private NcResponse parseResponse(String response) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(NcResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (NcResponse) unmarshaller.unmarshal(new StringReader(response));
    }
    
        /**
     * Create an SHA1 value with 8859_1 encoding.
     *
     * @param s String to encoding
     * @return encoded string
     * @throws UnsupportedEncodingException ecoding 8859_1
     * @throws NoSuchAlgorithmException algorithmus SHA1
     */
    public String createSHA1(final String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] theTextToDigestAsBytes = (s).getBytes("8859_1" /* encoding */);
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(theTextToDigestAsBytes);
        byte[] digest = md.digest();
        StringBuilder bul = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            bul.append(
                   Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1)
                    );
        }
        return bul.toString();
    }
    
    
}

