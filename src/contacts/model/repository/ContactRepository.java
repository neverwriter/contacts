package contacts.model.repository;

import contacts.model.contact.Contact;

import java.util.ArrayList;

/**
 * Repository interface
 */
public interface ContactRepository {

boolean removeContact(int contactNumber);

Contact getContactByNumber(int contactNumber);

void updateContactByNumber(Contact editedContact, int contactNumber);

void addContact(Contact newContact);

int getNumberOfContacts();

ArrayList<Contact> getAllContacts();

boolean isContactListEmpty();
}
