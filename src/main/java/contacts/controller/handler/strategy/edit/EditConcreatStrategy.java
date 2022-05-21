package contacts.controller.handler.strategy.edit;

import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.view.TextPrinter;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class EditConcreatStrategy implements EditStrategy {

    @Override
    public Contact execute(Contact contact) {
        Scanner scanner = new Scanner(System.in);



        TextPrinter.printSelectField(contact.getEditableFields());

        String fieldName = CommandReader.readCommand();

//        Command fieldSelector = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

        TextPrinter.printEnterField(fieldName);
        try {
            contact.editField(fieldName, scanner.nextLine());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        switch (fieldSelector) {
//
//            case NAME:
//                TextPrinter.printEnterName();
//                contactForEdition.setName(scanner.nextLine());
//                break;
//
//            case SURNAME:
//                TextPrinter.printEnterSurname();
//                contactForEdition.setSurname(scanner.nextLine());
//                break;
//
//            case NUMBER:
//                TextPrinter.printEnterPhoneNumber();
//                contactForEdition.setPhoneNumber(scanner.nextLine());
//                break;
//
//            case BIRTH:
//                TextPrinter.printEnterBirthDate();
//                contactForEdition.setBirthDate(scanner.nextLine());
//                break;
//
//            case GENDER:
//                TextPrinter.printEnterGender();
//                contactForEdition.setGender(scanner.nextLine());
//                break;
//
//            default:
//                System.out.println("Wrong field name");
//                break;
//
//        }

        contact.setTimeOfLastEdit();

        return contact;

    }
}
