package contacts.model.contact;

public class ConcreteContactFactory extends ContactFactory{

    @Override
    protected Contact createContact(String type) {

        switch (type){
            case "person":
                PersonCreationDirector personCreationDirector = PersonCreationDirector.getPersonCreationDirector();
                return personCreationDirector.createPerson();
        }
        return null;
    }
}
