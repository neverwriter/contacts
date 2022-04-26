package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;

public class TaskRemoveStrategy implements TaskHandlerStrategy {

    ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();

    @Override
    public void execute(Command command) {

        if (contactRepository.isContactListEmpty()) {
            TextPrinter.printNoRecords(command.getCommand());
            return;
        }

        TextPrinter.printContactList(contactRepository.getAllContacts());

        TextPrinter.printSelectRecord();
        if (contactRepository.removeContact(CommandReader.readNumberOfContact())) {
            TextPrinter.printRecordRemoved();

        } else {
            TextPrinter.printNoRecords(command.getCommand());
        }

    }


}
