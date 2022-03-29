package contacts.view;

import contacts.model.contact.Contact;

import java.util.ArrayList;
import java.util.Locale;

public class TextPrinter {

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
    private final static String ENTER_ACTION = "Enter action (add, remove, edit, count, info, exit): ";
    private final static String SELECT_RECORD = "Select a record: ";
    private final static String RECORD_REMOVED = "The record removed!";
    private final static String NO_RECORDS = "No records to ";
    private final static String SELECT_FIELD_PERSON = "Select a field (name, surname, birth, gender, number): ";
    private final static String SELECT_FIELD_ORGANIZATION = "Select a field (name, address, number): ";
    private final static String ENTER_TYP_OF_CONTACT = "Enter the type (person, organization): ";

    public static void printEnterName() {
        System.out.print(ENTER_NAME);
    }

    public static void printEnterSurname() {
        System.out.print(ENTER_SURNAME);
    }

    public static void printEnterPhoneNumber() {
        System.out.print(ENTER_PHONE_NUMBER);
    }

    public static void printEnterAddress() {System.out.print(ENTER_ADDRESS);}

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

    public static void printRecordCreated(){
        System.out.println(RECORD_CREATED);
    }

    public static void printPhoneNumberWrong(){
        System.out.println(PHONE_NUMBER_WRONG);
    }

    public static void printEnterAction() {
        System.out.print(ENTER_ACTION);
    }

    public static void printContactList(ArrayList<Contact> contacts){

        int counter = 1;

        for (Contact contact: contacts) {

            System.out.printf("%d. %s\n",counter, contact.nameToString());

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

    public static void printCountOfRecords(int numberOfRecords){
        System.out.printf("The Phone Book has %d records.\n", numberOfRecords);
    }

    public static void printSelectFieldPerson(){
        System.out.print(SELECT_FIELD_PERSON);
    }

    public static void printSelectFieldOrganization(){
        System.out.print(SELECT_FIELD_ORGANIZATION);
    }

    public static void printEnterTypeOfContact() {
        System.out.print(ENTER_TYP_OF_CONTACT);
    }

    public static void printNextLine() {
        System.out.print("\n\n");
    }
}
