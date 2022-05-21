package contacts.model.repository;

import contacts.model.contact.Contact;

import java.util.ArrayList;

public class InMemoryContactRepository implements ContactRepository {

    private static InMemoryContactRepository instance;

    private final ArrayList<Contact> inMemoryContactRepository = new ArrayList<>();

    private InMemoryContactRepository() {}

    public static InMemoryContactRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryContactRepository();
        }
        return instance;
    }

    @Override
    public void addContact(Contact newContact){

        inMemoryContactRepository.add(newContact);

    }

    @Override
    public int getNumberOfContacts() {
        return inMemoryContactRepository.size();
    }

    @Override
    public boolean isContactListEmpty(){
        return inMemoryContactRepository.isEmpty();
    }

    @Override
    public boolean removeContact(int contactNumber){
        if(isContactListEmpty()){
            return false;
        } else {

            inMemoryContactRepository.remove(contactNumber-1);
            return true;
        }

    }

    @Override
    public Contact getContactByNumber(int contactNumber){
        return inMemoryContactRepository.get(contactNumber);
    }

    @Override
    public void updateContactByNumber(Contact editedContact, int contactNumber){
        inMemoryContactRepository.set(contactNumber, editedContact);
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return inMemoryContactRepository;
    }
}
