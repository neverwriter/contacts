package contacts.controller.handler.strategy.edit;

import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.contact.Person;
import contacts.view.TextPrinter;

import java.util.Locale;
import java.util.Scanner;

public class EditPersonStrategy implements EditStrategy {

    @Override
    public Contact execute(Contact contact) {
        Scanner scanner = new Scanner(System.in);

        Person contactForEdition = (Person) contact;

        TextPrinter.printSelectFieldPerson();

        String inputText = CommandReader.readCommand();

        Command fieldSelector = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

        switch (fieldSelector) {

            case NAME:
                TextPrinter.printEnterName();
                contactForEdition.setName(scanner.nextLine());
                break;

            case SURNAME:
                TextPrinter.printEnterSurname();
                contactForEdition.setSurname(scanner.nextLine());
                break;

            case NUMBER:
                TextPrinter.printEnterPhoneNumber();
                contactForEdition.setPhoneNumber(scanner.nextLine());
                break;

            case BIRTH:
                TextPrinter.printEnterBirthDate();
                contactForEdition.setBirthDate(scanner.nextLine());
                break;

            case GENDER:
                TextPrinter.printEnterGender();
                contactForEdition.setGender(scanner.nextLine());
                break;

            default:
                System.out.println("Wrong field name");
                break;

        }

        contactForEdition.setTimeOfLastEdit();

        return contactForEdition;

    }
}
