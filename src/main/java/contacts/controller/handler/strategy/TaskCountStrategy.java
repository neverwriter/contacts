package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;

public class TaskCountStrategy implements TaskHandlerStrategy {

    ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();

    @Override
    public void execute(Command command) {

        TextPrinter.printCountOfRecords(contactRepository.getNumberOfContacts());
    }
}
