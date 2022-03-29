package contacts.controller.handler.strategy;

import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.db.ContactsRepository;
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

    public Contact getContactByItsNumber(ContactsRepository contactsRepository) {
        TextPrinter.printSelectRecord();

        this.contactNumber = CommandReader.readNumberOfContact();

        if (contactsRepository.getContactsRepository().size() >= contactNumber) {
            return contactsRepository.getContactByNumber(contactNumber);
        }
 return null;
    }
}