package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.contact.ConcreteContactFactory;
import contacts.model.contact.ContactFactory;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskAddStrategy implements TaskHandlerStrategy{

    ContactsRepository contactsRepository = ContactsRepository.getInstance();

    @Override
    public void execute(Command command) {

        ContactFactory contactFactory = new ConcreteContactFactory();

        TextPrinter.printEnterTypeOfContact();

        String inputContactType = CommandReader.readCommand();

        contactsRepository.addContact(contactFactory.getContact(inputContactType));

        TextPrinter.printRecordCreated();
    }
}
