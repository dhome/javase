package ch.h2m.edu.platform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegularExpression.java
 *
 * Created on 17.11.2011, 13:02:43
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class RegularExpression {

    private Pattern pattern;
    private Matcher matcher;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    
    
    /**
     * (		# Start of group
     * (?=.*\d)		#   must contains one digit from 0-9
     * (?=.*[a-z])	#   must contains one lowercase characters
     * (?=.*[A-Z])	#   must contains one uppercase characters
     * (?=.*[@#$%])	#   must contains one special symbols in the list "@#$%"
     *      .		#     match anything with previous condition checking
     *        {6,20}	#        length at least 6 characters and maximum of 20	
     * )		# End of group
     */    
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String IMAGE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    private static final String DATE_PATTERN = //(dd/mm/yyyy)
            "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((18|19|20)\\d\\d)";
    private static final String CREDITCARD_PATTERN = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9]"
            + "[0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|"
            + "(?:2131|1800|35\\d{3})\\d{11})$";

    public RegularExpression() {        
    }

    public boolean validateUserName(final String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
    /**
     * Use a complex password.
     * match 6 to 20 characters string with at least one digit, one upper case 
     * letter, one lower case letter and one special symbol (@#$%). This 
     * regular expression pattern is very useful to implement a strong and 
     * complex password.
     * @return 
     */
    public boolean validatePassword(final String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    public boolean validateEmail(final String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateImage(final String image) {
        pattern = Pattern.compile(IMAGE_PATTERN);
        matcher = pattern.matcher(image);
        return matcher.matches();
    }
    
    public boolean validateCreditCard(final String creditCardNo) {
        pattern = Pattern.compile(CREDITCARD_PATTERN);
        matcher = pattern.matcher(creditCardNo);
        return matcher.matches();
    }

    public boolean validateDate(final String date) {
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(date);
        if (matcher.matches()) {
            matcher.reset();
            if (matcher.find()) {
                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31")
                        && (month.equals("4") || month.equals("6") || month.equals("9")
                        || month.equals("11") || month.equals("04") || month.equals("06")
                        || month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if (year % 4 == 0) {
                        if (day.equals("30") || day.equals("31")) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        if (day.equals("29") || day.equals("30") || day.equals("31")) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
