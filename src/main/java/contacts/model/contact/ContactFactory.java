package contacts.model.contact;

public abstract class ContactFactory {

    protected abstract Contact createContact(String type);

    public Contact getContact(String type){
        Contact contact = createContact(type);

        if(contact == null){
            System.out.println("Object contact not created");
            return null;
        }

        return contact;
    }

}
