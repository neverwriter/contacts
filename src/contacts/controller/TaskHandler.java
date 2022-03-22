package contacts.controller;

import contacts.model.Contact;
import contacts.view.TextPrinter;

import java.util.Scanner;

public class TaskHandler {

    private static TaskHandler taskHandler;

    private TaskHandler(){}

    public static TaskHandler getTaskHandler() {

        if (taskHandler == null) {
            taskHandler = new TaskHandler();
        }

        return taskHandler;
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

        Contact newContact = contactBuilder.build();

        return newContact;
    }
}