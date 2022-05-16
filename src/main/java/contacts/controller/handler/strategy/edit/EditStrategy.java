package contacts.controller.handler.strategy.edit;

import contacts.model.contact.Contact;

public interface EditStrategy {

    Contact execute(Contact contactForEdition);
}
