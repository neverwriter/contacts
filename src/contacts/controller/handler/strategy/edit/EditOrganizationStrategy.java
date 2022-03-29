package contacts.controller.handler.strategy.edit;

import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.contact.Organization;
import contacts.view.TextPrinter;

import java.util.Locale;
import java.util.Scanner;

public class EditOrganizationStrategy implements EditStrategy{

    @Override
    public Contact execute(Contact contact) {
        Scanner scanner = new Scanner(System.in);

        Organization contactForEdition = (Organization) contact;

        TextPrinter.printSelectFieldOrganization();

        String inputText = CommandReader.readCommand();

        Command fieldSelector = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

        switch (fieldSelector) {

            case NAME:
                TextPrinter.printEnterName();
                contactForEdition.setName(scanner.nextLine());
                break;

            case ADDRESS:
                TextPrinter.printEnterSurname();
                contactForEdition.setAddress(scanner.nextLine());
                break;

            case NUMBER:
                TextPrinter.printEnterPhoneNumber();
                contactForEdition.setPhoneNumber(scanner.nextLine());
                break;

            default:
                System.out.println("Wrong field name");
                break;

        }

        contactForEdition.setTimeOfLastEdit();

        return contactForEdition;
    }
}
