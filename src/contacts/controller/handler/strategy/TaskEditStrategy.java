package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.controller.handler.strategy.edit.EditContext;
import contacts.controller.handler.strategy.edit.EditOrganizationStrategy;
import contacts.controller.handler.strategy.edit.EditPersonStrategy;
import contacts.model.contact.Contact;
import contacts.model.contact.Organization;
import contacts.model.contact.Person;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskEditStrategy implements TaskHandlerStrategy {

    ContactsRepository contactsRepository = ContactsRepository.getInstance();
    TaskHandler taskHandler = TaskHandler.getInstance();

    @Override
    public void execute(Command command) {

        if (contactsRepository.isContactListEmpty()) {
            TextPrinter.printNoRecords(command.getCommand());
            return;
        }

        TextPrinter.printContactList(contactsRepository.getContactsRepository());

        Contact contactForEdition = taskHandler.getContactByItsNumber(contactsRepository);

        EditContext editContext = new EditContext();

        if (Person.class == contactForEdition.getClass()) {
            editContext.setEditStrategy(new EditPersonStrategy());
        } else if (Organization.class == contactForEdition.getClass()) {
            editContext.setEditStrategy(new EditOrganizationStrategy());
        }

        editContext.executeStrategy(contactForEdition);

        contactsRepository.updateContactByNumber(contactForEdition, taskHandler.getContactNumber());

    }


}

