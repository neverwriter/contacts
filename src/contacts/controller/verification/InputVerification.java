package contacts.controller.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerification {

    private final static String REGEX_PHONE_NUMBER =
            "[+]?([a-z0-9][\\s-]+)?(([a-z0-9]{2,})?[\\s-]?)*([(][a-z0-9]{2,}[)])?[\\s-]?(([a-z0-9]{2,})?[\\s-]?)*|" +
                    "[+]?[a-z0-9]?" ;

    private final static String REGEX_BIRTH_DATE = "^(0?[1-9]|[12][0-9]|3[01])[/-](0?[1-9]|1[012])[/-]\\d{4}$";

    private final static String REGEX_GENDER = "[MF]";

    public static boolean isPhoneNumberValid(String phoneNumber){

        Pattern pattern = Pattern.compile(REGEX_PHONE_NUMBER, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public static boolean isBirthDateValid(String birthDate){

        Pattern pattern = Pattern.compile(REGEX_BIRTH_DATE);

        Matcher matcher = pattern.matcher(birthDate);

        return matcher.matches();
    }

    public static boolean isGenderValid(String gender){
        Pattern pattern = Pattern.compile(REGEX_GENDER);

        Matcher matcher = pattern.matcher(gender);

        return matcher.matches();
    }
}
