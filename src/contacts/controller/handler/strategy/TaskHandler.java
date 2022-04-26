package contacts.controller.handler.strategy;

import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.repository.ContactRepository;
import contacts.model.repository.InMemoryContactRepository;
import contacts.view.TextPrinter;

public class TaskHandler {

    private static TaskHandler instance;

    private int contactNumber;

    private TaskHandler() {}

    public static TaskHandler getInstance() {
        if (instance == null) {
            instance = new TaskHandler();
        }
        return instance;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public Contact getContactByItsNumber(ContactRepository contactRepository) {
        TextPrinter.printSelectRecord();

        this.contactNumber = CommandReader.readNumberOfContact();

        if (contactRepository.getNumberOfContacts() >= contactNumber) {
            return contactRepository.getContactByNumber(contactNumber);
        }
 return null;
    }
}