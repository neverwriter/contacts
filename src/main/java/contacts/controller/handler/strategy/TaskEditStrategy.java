package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.controller.handler.strategy.edit.EditContext;
import contacts.controller.handler.strategy.edit.EditOrganizationStrategy;
import contacts.controller.handler.strategy.edit.EditPersonStrategy;
import contacts.model.contact.Contact;
import contacts.model.contact.Organization;
import contacts.model.contact.Person;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;

public class TaskEditStrategy implements TaskHandlerStrategy {

    ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();
    TaskHandler taskHandler = TaskHandler.getInstance();

    @Override
    public void execute(Command command) {

        if (contactRepository.isContactListEmpty()) {
            TextPrinter.printNoRecords(command.getCommand());
            return;
        }

        TextPrinter.printContactList(contactRepository.getAllContacts());

        Contact contactForEdition = taskHandler.getContactByItsNumber(contactRepository);

        EditContext editContext = new EditContext();

        if (Person.class == contactForEdition.getClass()) {
            editContext.setEditStrategy(new EditPersonStrategy());
        } else if (Organization.class == contactForEdition.getClass()) {
            editContext.setEditStrategy(new EditOrganizationStrategy());
        }

        editContext.executeStrategy(contactForEdition);

        contactRepository.updateContactByNumber(contactForEdition, taskHandler.getContactNumber());

    }


}

