package contacts.model.contact;

import contacts.view.TextPrinter;

import java.util.Scanner;

public class PersonCreationDirector {

    private static PersonCreationDirector personCreationDirector;

    private PersonCreationDirector(){}

    public static PersonCreationDirector getPersonCreationDirector(){
     if(personCreationDirector == null){
         personCreationDirector = new PersonCreationDirector();
     }
     return personCreationDirector;
    }

    public Person createPerson(){
        Scanner scanner = new Scanner(System.in);

        Person.PersonBuilder personBuilder = new Person.PersonBuilder();

        TextPrinter.printEnterName();
        personBuilder.setName(scanner.nextLine());

        TextPrinter.printEnterSurname();
        personBuilder.setSurname(scanner.nextLine());

        TextPrinter.printEnterPhoneNumber();
        personBuilder.setPhoneNumber(scanner.nextLine());

        return personBuilder.build();
    }
}
