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

        Contact newContact = new Contact();

        TextPrinter.printEnterName();

        newContact.setName(scanner.nextLine());

        TextPrinter.printEnterSurname();

        newContact.setSurname(scanner.nextLine());

        TextPrinter.printEnterPhoneNumber();

        newContact.setPhoneNumber(scanner.nextLine());

        return newContact;
    }
}