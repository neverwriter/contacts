package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.model.contact.Contact;
import contacts.model.repository.ContactRepository;

public class TaskHandler {

    private static TaskHandler instance;


    private static final ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();

    private TaskHandler() {}

    public static TaskHandler getInstance() {
        if (instance == null) {
            instance = new TaskHandler();
        }
        return instance;
    }

    public Contact getContactByItsNumber(int contactNumber) {


        if (contactRepository.getNumberOfContacts() >= contactNumber) {
            return contactRepository.getContactByNumber(contactNumber);
        }

        return null;
    }

    public void updateContactByItsNumber(Contact contactForEdition, int contactNumber){
        contactRepository.updateContactByNumber(contactForEdition, contactNumber);
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}