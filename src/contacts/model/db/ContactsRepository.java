package contacts.model.db;

import contacts.model.contact.Contact;

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

    public ArrayList<Contact> getContactsRepository() {
        return contactsRepository;
    }

    public void addContact(Contact newContact){

        contactsRepository.add(newContact);

    }

    public boolean isContactListEmpty(){
        return contactsRepository.isEmpty();
    }

    public boolean removeContact(int contactNumber){
        if(isContactListEmpty()){
            return false;
        } else {

            contactsRepository.remove(contactNumber-1);
            return true;
        }

    }

    public Contact getContactByNumber(int contactNumber){
        return contactsRepository.get(contactNumber-1);
    }

    public void updateContactByNumber(Contact editedContact, int contactNumber){
        contactsRepository.set(contactNumber-1, editedContact);
    }
}