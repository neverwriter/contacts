package contacts.model.db;

import contacts.model.Contact;

import java.util.ArrayList;

public class ContactsRepository {

    private static ContactsRepository instance;

    private final ArrayList<Contact> contactsRepository = new ArrayList<>();

    private ContactsRepository() {}

    public static ContactsRepository getInstance() {
        if (instance == null) {
            instance = new ContactsRepository();
        }
        return instance;
    }

    public void addContact(Contact newContact){

        contactsRepository.add(newContact);

    }
}
