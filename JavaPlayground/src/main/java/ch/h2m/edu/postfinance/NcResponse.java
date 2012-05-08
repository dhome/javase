package ch.h2m.edu.postfinance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class matching to the Post Finance response of direct link.
 * <br/>
 * This class can be parsed by JAXB.
 * Code usage example<br/>
 * <code>
 * JAXBContext jc = JAXBContext.newInstance(NcResponse.class);<br/>
 * Unmarshaller unmarshaller = jc.createUnmarshaller();<br/>
 * return (NcResponse) unmarshaller.unmarshal(postfinanceanswer);<br/>
 * </code>
 *
 * @author Heinz Marti
 */
@XmlRootElement(name = "ncresponse")
public class NcResponse implements java.io.Serializable {
    
    public static final long serialVersionUID = -9156009141486776833L;

    /**
     * Unique order reference (merchant reference).
     */
    @XmlAttribute(name = "orderID")
    private String orderID;

    /**
     * Payment reference in the Post Finance system.
     */
    @XmlAttribute(name = "PAYID")
    private String payId;

    /**
     * First digit of NCERROR.
     */
    @XmlAttribute(name = "NCSTATUS")
    private String ncStatus;

    /**
     * Error code.
     */
    @XmlAttribute(name = "NCERROR")
    private String ncError;

    /**
     * Explanation of the error code.
     */
    @XmlAttribute(name = "NCERRORPLUS")
    private String ncErrorPlus;

    /**
     * Acceptance code returned by acquirer.
     */
    @XmlAttribute(name = "ACCEPTANCE")
    private String acceptance;

    /**
     * Transaction status.
     */
    @XmlAttribute(name = "STATUS")
    private String status;

    /**
     * Originating country of the IP address.
     * In ISO 3166-1-alpha-2 code values (<a href="http://www.iso.org/iso/
     *        en/prods-services/iso3166ma/02iso-3166-code-lists/
     * list-en1.html">list-en1</a>). If this parameter is not available,
     * "99" will be returned in the response. <br/>
     * There are 4 specific IP codes which refer to IP addresses for which the
     * country of origin is uncertain: <br/>
     * <ul>
     * <li>A1: Anonymous proxy. Anonymous proxies are Internet access providers
     * that allow Internet users to hide their IP address.</li>
     * <li>AP: Asian Pacific region</li>
     * <li>EU: European network</li>
     * <li>A2: Satellite providers</li>
     *</ul>
     * <br/>
     * The IP check is based on externally provided IP listings, so there is a
     * slight risk since we rely on the correctness of this list. The check
     * gives positive results in 94% of all cases.
     */
    @XmlAttribute(name = "IPCTY")
    private String ipcty;

    /**
     * Country where the card was issued.
     * In ISO 3166-1-alpha-2 code values
     * (<a href="http://www.iso.org/iso/en/prods-services/iso3166ma/
     *       02iso-3166-code-lists/list-en1.html">list-en1</a>).
     * If this parameter is not available, "99" will be returned
     * in the response.<br/>
     * This credit card country check is based on externally provided listings,
     * so there is a slight risk since we rely on the correctness of this list.
     * The check gives positive results in 94% of all cases.
     */
    @XmlAttribute(name = "CCCTY")
    private String ccty;

    /**
     * Electronic Commerce Indicator.
     * You can configure a default ECI value in the
     * "Global transaction parameters" tab, "Default ECI value" section of 
     * the Technical Information page. When you send an ECI value in the 
     * request, this will overwrite the default ECI value.:<br/>
     * Possible (numeric) values:
     * <br/>
     * 0 - Swiped<br/>
     * 1 - Manually keyed (MOTO) (card not present)<br/>
     * 2 - Recurring (from MOTO)<br/>
     * 3 - Instalment payments<br/>
     * 4 - Manually keyed, card present<br/>
     * 7 - E-commerce with SSL encryptio<br/>
     */
    @XmlAttribute(name = "ECI")
    private String eci;

    /**
     * Card Verification Code. Depending on the card brand, the verification
     * code will be a 3- or 4-digit code on the front or rear of the card, an
     * issue number, a start date or a date of birth (for more information,
     * please refer to <a href="https://e-payment.postfinance.ch/ncol/
     * card_verification_code1.asp">card_verification_code1</a>)
     */
    @XmlAttribute(name = "CVCCheck")
    private String cvcCheck;
    
    /**
     * Result of the automatic address verification.
     * This verification is currently only available for:
     * <ul>
     * <li>American Express (only if both address and CVC are transmitted)</li>
     * <li>English acquirers (only for VISA and MasterCard)</li>
     * </ul>
     *
     * Possible values: <br/>
     * <ul>
     * <li> <b>KO</b>: The address has been sent but the acquirer has given a
     * negative response for the address check, i.e. the address is wrong. </li>
     * <li> <b>OK</b>: The address has been sent and the acquirer has returned a
     * positive response for the address check, i.e. the address is correct OR
     * The acquirer sent an authorization code but did not return a specific
     * response for the address check.</li>
     * <li><b>NO</b>: All other cases. For instance, no address transmitted; the
     * acquirer has replied that an address check was not possible; the acquirer
     * declined the authorization but did not provide a specific result for the
     * address check, ... </li>
     * </ul>
     */
    @XmlAttribute(name = "AAVCheck")
    private String aavCheck;

    /**
     * Virtual Card type.
     * Virtual cards are in general virtual, single-use credit card numbers,
     * which can only be used on one predefined online shop and expire within 
     * one or two months. This type of card is more secure, but limits the type
     * of financial operations allowed. On transactions performed with a
     * virtual creditcard it is not possible to renew authorizations, perform
     * partial payments or recurring payments, etc.<br/>
     * Possible values:
     * <ul>
     * <li><b>ECB</b>: For E Carte Bleue</li>
     * <li><b>ICN</b>: For Internet City Number</li>
     * <li><b>NO</b>: All other cases. For instance, the card is not a
     * virtual card, the card is a type of virtual card not known to us.</li>
     * </ul>
     */
    @XmlAttribute(name = "VC")
    private String vc;

    /**
     * Order amount.
     * <strong>not</strong> multiplied by 100.
     */
    @XmlAttribute(name = "amount")
    private String amount;

    /**
     * Order currency.
     */
    @XmlAttribute(name = "currency")
    private String currency;

    /**
     * Payment method.
     */
    @XmlAttribute(name = "PM")
    private String paymentMethod;

    /**
     * Card brand.
     * It can contain similar information for other payment methods.
     */
    @XmlAttribute(name = "BRAND")
    private String brand;

    
    @Override
    public final String toString() {
        return "orderID=\"" + orderID + "\"&PAYID=\"" + payId
                + "\"&NCSTATUS=\"" + ncStatus + "\"&NCERROR=\"" + ncError
                + "\"&NCERRORPLUS=\"" + ncErrorPlus + "\"&ACCEPTANCE=\""
                + acceptance + "\"&STATUS=\"" + status + "\"&IPCTY=\"" + ipcty
                + "\"&CCTY=\"" + ccty + "\"&ECI=\"" + eci + "\"&CVCCheck=\""
                + cvcCheck + "\"&AAVCheck=\"" + aavCheck + "\"&VC=\"" + vc
                + "\"&amount=\"" + amount + "\"&currency=\"" + currency
                + "\"&PM=\"" + paymentMethod + "\"&BRAND=\"" + brand + "\"";
    }

    public String getOrderID() {
        return orderID;
    }

    public String getPayId() {
        return payId;
    }

    public String getNcStatus() {
        return ncStatus;
    }

    public String getNcError() {
        return ncError;
    }

    public String getNcErrorPlus() {
        return ncErrorPlus;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public String getStatus() {
        return status;
    }

    public String getIpcty() {
        return ipcty;
    }

    public String getCcty() {
        return ccty;
    }

    public String getEci() {
        return eci;
    }

    public String getCvcCheck() {
        return cvcCheck;
    }

    public String getAavCheck() {
        return aavCheck;
    }

    public String getVc() {
        return vc;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getBrand() {
        return brand;
    }
}
