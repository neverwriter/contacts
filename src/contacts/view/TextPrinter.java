package contacts.view;

public class TextPrinter {

    private final static String ENTER_NAME = "Enter the name of person:";
    private final static String ENTER_SURNAME = "Enter the surname of person:";
    private final static String ENTER_PHONE_NUMBER = "Enter the number:";
    private final static String RECORD_CREATED = "\nA Record created!";
    private final static String PHONE_BOOK_CREATED = "A Phone Book with a single record created!";


    public static void printEnterName() {
        System.out.println(ENTER_NAME);
    }

    public static void printEnterSurname() {
        System.out.println(ENTER_SURNAME);
    }

    public static void printEnterPhoneNumber() {
        System.out.println(ENTER_PHONE_NUMBER);
    }

    public static void printRecordCreated(){
        System.out.println(RECORD_CREATED);
    }

    public static void printPhoneBookCreated(){
        System.out.println(PHONE_BOOK_CREATED);
    }
}
