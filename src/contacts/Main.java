package contacts;

import contacts.controller.TaskHandler;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class Main {
    public static void main(String[] args) {

        TaskHandler taskHandler = TaskHandler.getTaskHandler();
        ContactsRepository contactsRepository = ContactsRepository.getInstance();

        contactsRepository.addContact(taskHandler.createContact());

        TextPrinter.printRecordCreated();
        TextPrinter.printPhoneBookCreated();
    }
}
