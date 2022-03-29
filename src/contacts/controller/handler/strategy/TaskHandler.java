package contacts.controller.handler.strategy;

import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskHandler {

    private static TaskHandler instance;

    private TaskHandler() {}

    public static TaskHandler getInstance() {
        if (instance == null) {
            instance = new TaskHandler();
        }
        return instance;
    }

    public Contact getContactByItsNumber(ContactsRepository contactsRepository) {
        TextPrinter.printSelectRecord();

        int contactNumber = CommandReader.readNumberOfContact();

        if (contactsRepository.getContactsRepository().size() >= contactNumber) {
            return contactsRepository.getContactByNumber(contactNumber);
        }
 return null;
    }
}