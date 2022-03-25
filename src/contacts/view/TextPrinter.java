package contacts.view;

import contacts.model.Contact;

import java.util.ArrayList;
import java.util.Locale;

public class TextPrinter {

    private final static String ENTER_NAME = "Enter the name of person: ";
    private final static String ENTER_SURNAME = "Enter the surname of person: ";
    private final static String ENTER_PHONE_NUMBER = "Enter the number: ";
    private final static String RECORD_CREATED = "The record added.";
    private final static String PHONE_BOOK_CREATED = "A Phone Book with a single record created!";
    private final static String ENTER_ACTION= "Enter action (add, remove, edit, count, list, exit): ";
    private final static String SELECT_RECORD = "Select a record: ";
    private final static String RECORD_REMOVED = "The record removed!";
    private final static String NO_RECORDS = "No records to ";

    public static void printEnterName() {
        System.out.print(ENTER_NAME);
    }

    public static void printEnterSurname() {
        System.out.print(ENTER_SURNAME);
    }

    public static void printEnterPhoneNumber() {
        System.out.print(ENTER_PHONE_NUMBER);
    }

    public static void printRecordCreated(){
        System.out.println(RECORD_CREATED);
    }

    public static void printPhoneBookCreated(){
        System.out.println(PHONE_BOOK_CREATED);
    }

    public static void printEnterAction() {
        System.out.print(ENTER_ACTION);
    }

    public static void printContactList(ArrayList<Contact> contacts){

        int counter = 1;

        for (Contact contact: contacts) {

            System.out.printf("%d. %s\n",counter, contact.toString());
            counter++;
        }

    }

    public static void printContact(Contact contact) {
        System.out.println(contact.toString());
    }

    public static void printSelectRecord(){
        System.out.print(SELECT_RECORD);
    }

    public static void printRecordRemoved(){
        System.out.println(RECORD_REMOVED);
    }

    public static void printNoRecords(String commandType){
        System.out.printf("%s%s!\n", NO_RECORDS, commandType.toLowerCase(Locale.ROOT));
    }
}
