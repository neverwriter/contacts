package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskCountStrategy implements TaskHandlerStrategy {

    ContactsRepository contactsRepository = ContactsRepository.getInstance();

    @Override
    public void execute(Command command) {

        TextPrinter.printCountOfRecords(contactsRepository.getContactsRepository().size());
    }
}
