package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.model.contact.Contact;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskInfoStrategy implements TaskHandlerStrategy {

    ContactsRepository contactsRepository = ContactsRepository.getInstance();
    TaskHandler taskHandler = TaskHandler.getInstance();

    @Override
    public void execute(Command command) {

        TextPrinter.printContactList(contactsRepository.getContactsRepository());

        Contact contactToPrint = taskHandler.getContactByItsNumber(contactsRepository);

        TextPrinter.printContact(contactToPrint);

    }
}
