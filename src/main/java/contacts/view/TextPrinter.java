package contacts.view;

import contacts.model.contact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Class to print text in console
 *
 * @author Patryk Lewczuk
 */

public class TextPrinter {

    private final static String ENTER = "Enter %s: ";
    private final static String ENTER_SEARCH_QUERY = "Enter search query: ";
    private final static String ENTER_NAME = "Enter the name: ";
    private final static String ENTER_SURNAME = "Enter the surname: ";
    private final static String ENTER_PHONE_NUMBER = "Enter the number: ";
    private final static String ENTER_ADDRESS = "Enter the address: ";
    private final static String ENTER_BIRTH_DATE = "Enter the birth date: ";
    private final static String BIRTH_DATE_WRONG = "Bad birth date!";
    private final static String ENTER_GENDER = "Enter the gender (M, F): ";
    private final static String GENDER_WRONG = "Bad gender!";
    private final static String RECORD_CREATED = "The record added.";
    private final static String PHONE_NUMBER_WRONG = "Wrong number format!";
    private final static String ENTER_ACTION = "[menu] Enter action (add, list, search, count, exit): ";
    private final static String ENTER_SEARCH_ACTION = "[search] Enter action ([number], back, again): ";
    private final static String ENTER_LIST_ACTION = "[list] Enter action ([number], back): ";
    private final static String SELECT_RECORD = "Select a record: ";
    private final static String SAVED = "Saved";
    private final static String RECORD_REMOVED = "The record removed!";
    private final static String NO_RECORDS = "No records to ";
    private final static String SELECT_FIELD_PREFIX = "Select a field (";
    private final static String SELECT_FIELD_SUFFIX = "): ";
    private final static String ENTER_TYP_OF_CONTACT = "Enter the type (person, organization): ";
    private final static String SEARCH_RESULT = "Found %d results: \n";
    private static final String ENTER_RECORD_ACTION = "[record] Enter action (edit, delete, menu): ";

    public static void printEnterField(String fieldName) {
        System.out.printf(ENTER, fieldName);
    }

    public static void printEnterName() {
        System.out.print(ENTER_NAME);
    }

    public static void printEnterSurname() {
        System.out.print(ENTER_SURNAME);
    }

    public static void printEnterPhoneNumber() {
        System.out.print(ENTER_PHONE_NUMBER);
    }

    public static void printEnterAddress() {
        System.out.print(ENTER_ADDRESS);
    }

    public static void printEnterBirthDate() {
        System.out.print(ENTER_BIRTH_DATE);
    }

    public static void printBirthDateWrong() {
        System.out.println(BIRTH_DATE_WRONG);
    }

    public static void printEnterGender() {
        System.out.print(ENTER_GENDER);
    }

    public static void printGenderWrong() {
        System.out.println(GENDER_WRONG);
    }

    public static void printRecordCreated() {
        System.out.println(RECORD_CREATED);
    }

    public static void printPhoneNumberWrong() {
        System.out.println(PHONE_NUMBER_WRONG);
    }

    public static void printEnterAction() {
        System.out.print(ENTER_ACTION);
    }

    public static void printContactList(ArrayList<Contact> contacts) {

        int counter = 1;

        for (Contact contact : contacts) {

            System.out.printf("%d. %s\n", counter, contact.nameToString());

            counter++;
        }

    }

    public static void printContactMap(Map<Integer,Contact> contactMap) {

        int counter = 1;

        for (Map.Entry<Integer, Contact> entry : contactMap.entrySet()) {

            System.out.printf("%d. %s\n", counter, entry.getValue().nameToString());

            counter++;
        }
    }

    public static void printContact(Contact contact) {
        System.out.println(contact.toString());
    }

    public static void printSelectRecord() {
        System.out.print(SELECT_RECORD);
    }

    public static void printRecordRemoved() {
        System.out.println(RECORD_REMOVED);
    }

    public static void printNoRecords(String commandType) {
        System.out.printf("%s%s!\n", NO_RECORDS, commandType.toLowerCase(Locale.ROOT));
    }

    public static void printCountOfRecords(int numberOfRecords) {
        System.out.printf("The Phone Book has %d records.\n", numberOfRecords);
    }

    public static void printSelectField(List<String> fields) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(SELECT_FIELD_PREFIX);

        for (String fieldName : fields) {

            stringBuilder.append(fieldName).append(", ");

        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        stringBuilder.append(SELECT_FIELD_SUFFIX);

        System.out.print(stringBuilder.toString());
    }

    public static void printEnterTypeOfContact() {
        System.out.print(ENTER_TYP_OF_CONTACT);
    }

    public static void printNextLine() {
        System.out.print("\n\n");
    }

    public static void printEnterSearchQuery() {
        System.out.print(ENTER_SEARCH_QUERY);
    }

    public static void printFoundSearchResults(int numberOfResults) {System.out.printf(SEARCH_RESULT, numberOfResults);}

    public static void printEnterSearchAction() {
        System.out.print(ENTER_SEARCH_ACTION);
    }

    public static void printEnterRecordAction() {
        System.out.print(ENTER_RECORD_ACTION);
    }

    public static void printEnterListAction() {
        System.out.print(ENTER_LIST_ACTION);
    }

    public static void printSave() {
        System.out.println(SAVED);
    }
}