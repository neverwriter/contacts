package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.model.contact.Contact;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;

public class TaskInfoStrategy implements TaskHandlerStrategy {

    ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();
    TaskHandler taskHandler = TaskHandler.getInstance();

    @Override
    public void execute(Command command) {

        TextPrinter.printContactList(contactRepository.getAllContacts());

        Contact contactToPrint = taskHandler.getContactByItsNumber(contactRepository);

        TextPrinter.printContact(contactToPrint);

    }
}
