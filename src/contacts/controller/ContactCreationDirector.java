package contacts.controller;

import contacts.model.Contact;
import contacts.view.TextPrinter;

import java.util.Scanner;

public class ContactCreationDirector {

    private static ContactCreationDirector contactCreationDirector;

    private ContactCreationDirector(){}

    public static ContactCreationDirector getContactCreationDirector() {

        if (contactCreationDirector == null) {
            contactCreationDirector = new ContactCreationDirector();
        }

        return contactCreationDirector;
    }

    public Contact createContact() {
        Scanner scanner = new Scanner(System.in);

        Contact.ContactBuilder contactBuilder = new Contact.ContactBuilder();

        TextPrinter.printEnterName();
        contactBuilder.setName(scanner.nextLine());

        TextPrinter.printEnterSurname();
        contactBuilder.setSurname(scanner.nextLine());

        TextPrinter.printEnterPhoneNumber();
        contactBuilder.setPhoneNumber(scanner.nextLine());

        return contactBuilder.build();
    }
}