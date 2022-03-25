package contacts.controller;

import contacts.model.Contact;
import contacts.model.db.ContactsRepository;

public class DataBaseFeeder {

    public static void feedDataBase(){

        ContactsRepository contactsRepository = ContactsRepository.getInstance();

        Contact.ContactBuilder contactBuilder = new Contact.ContactBuilder();

        Contact newContact = contactBuilder.setName("Patryk")
                .setSurname("Lewczuk")
                .setPhoneNumber("+4 600-600-800").build();

        contactsRepository.addContact(newContact);

        Contact newContact1 = contactBuilder.setName("Michal")
                .setSurname("Kowal")
                .setPhoneNumber("+4 600-520-800").build();

        contactsRepository.addContact(newContact1);
    }
}
