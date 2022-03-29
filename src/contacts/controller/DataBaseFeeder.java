package contacts.controller;

import contacts.model.contact.Contact;
import contacts.model.contact.Organization;
import contacts.model.contact.Person;
import contacts.model.db.ContactsRepository;

public class DataBaseFeeder {

    public static void feedDataBase(){
        ContactsRepository contactsRepository = ContactsRepository.getInstance();

        Person.PersonBuilder personBuilder = new Person.PersonBuilder();

        personBuilder.setName("Patryk");

        personBuilder.setSurname("Lewczuk");

        personBuilder.setBirthDate("08-04-1992");

        personBuilder.setGender("M");

        personBuilder.setPhoneNumber("+4 123 456 789");

        Contact contact = personBuilder.build();

        contactsRepository.addContact(contact);

        Organization.OrganizationBuilder organizationBuilder = new Organization.OrganizationBuilder();

        organizationBuilder.setName("Pizza Hut");

        organizationBuilder.setAddress("Wall st. 1");

        organizationBuilder.setPhoneNumber("+4 856 235 846");

        Contact contact1 = organizationBuilder.build();

        contactsRepository.addContact(contact1);

    }
}
