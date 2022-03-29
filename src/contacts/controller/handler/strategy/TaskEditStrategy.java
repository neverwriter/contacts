package contacts.controller.handler.strategy;

import contacts.controller.command.Command;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

public class TaskEditStrategy implements TaskHandlerStrategy {

    ContactsRepository contactsRepository = ContactsRepository.getInstance();

    @Override
    public void execute(Command command) {

        if (contactsRepository.isContactListEmpty()) {
            TextPrinter.printNoRecords(command.getCommand());
            return;
        }

        TextPrinter.printContactList(contactsRepository.getContactsRepository());

        TextPrinter.printSelectRecord();

//        int contactNumber = CommandReader.readNumberOfContact();
//
//        if (contactsRepository.getContactsRepository().size() >= contactNumber) {
//            Contact contactForEdition = contactsRepository.getContactByNumber(contactNumber);
//            Scanner scanner = new Scanner(System.in);
//
//            TextPrinter.printSelectField();
//
//            String inputText = CommandReader.readCommand();
//
//            Command fieldSelector = Command.valueOf(inputText.toUpperCase(Locale.ROOT));
//
//            switch (fieldSelector){
//
//                case NAME:
//                    TextPrinter.printEnterName();
//                    contactForEdition.setName(scanner.nextLine());
//                    break;
//
//                case SURNAME:
//                    TextPrinter.printEnterSurname();
//                    contactForEdition.setSurname(scanner.nextLine());
//                    break;
//
//                case NUMBER:
//                    TextPrinter.printEnterPhoneNumber();
//                    contactForEdition.setPhoneNumber(scanner.nextLine());
//                    break;
//
//                default:
//                    System.out.println("Wrong field name");
//                    break;
//
//            }
//
//            contactsRepository.updateContactByNumber(contactForEdition, contactNumber);

//        }


    }

}
