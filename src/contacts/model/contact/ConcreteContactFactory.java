package contacts.model.contact;

public class ConcreteContactFactory extends ContactFactory{

    @Override
    protected Contact createContact(String type) {

        switch (type){
            case "person":
                PersonCreationDirector personCreationDirector = PersonCreationDirector.getPersonCreationDirector();
                return personCreationDirector.createPerson();

            case "organization":
                OrganizationCreationDirector organizationCreationDirector = OrganizationCreationDirector.getOrganizationCreationDirector();
                return organizationCreationDirector.createOrganization();
        }
        return null;
    }
}
