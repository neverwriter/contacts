package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskRemoveStrategy implements TaskHandlerStrategy {

    ContactsRepository contactsRepository = ContactsRepository.getInstance();

    @Override
    public void execute(Command command) {

        if (contactsRepository.isContactListEmpty()) {
            TextPrinter.printNoRecords(command.getCommand());
            return;
        }

        TextPrinter.printContactList(contactsRepository.getContactsRepository());

        TextPrinter.printSelectRecord();
        if (contactsRepository.removeContact(CommandReader.readNumberOfContact())) {
            TextPrinter.printRecordRemoved();

        } else {
            TextPrinter.printNoRecords(command.getCommand());
        }

    }


}
