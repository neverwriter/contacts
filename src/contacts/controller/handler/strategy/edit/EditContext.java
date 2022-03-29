package contacts.controller.handler.strategy.edit;

import contacts.model.contact.Contact;

public class EditContext {

    private EditStrategy editStrategy;

    public void setEditStrategy(EditStrategy editStrategy) {
        this.editStrategy = editStrategy;
    }

    public Contact executeStrategy(Contact contactForEdition) {
         return editStrategy.execute(contactForEdition);
    }
}
