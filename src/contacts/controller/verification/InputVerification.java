package contacts.controller.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerification {

    private final static String REGEX_PHONE_NUMBER =
            "([+]?[a-z0-9][\\s-]+)?[(][a-z0-9\\s-]{2,}[)][\\s-]?([a-z0-9\\s-]{2,})?|" +
            "([+]?[a-z0-9][\\s-]+)?([a-z0-9\\s-]{2,})?[\\s-]?[(]([a-z0-9\\s-]{2,})[)]|" +
                    "([+]?[a-z0-9][\\s-]+)?[a-z0-9\\s-]{2,}[\\s-]?([a-z0-9\\s-]{2,})?";


    public static boolean isPhoneNumberValid(String phoneNumber){

        Pattern pattern = Pattern.compile(REGEX_PHONE_NUMBER, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
