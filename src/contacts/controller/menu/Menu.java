package contacts.controller.menu;

import contacts.controller.DataBaseFeeder;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.handler.strategy.*;
import contacts.model.contact.ConcreteContactFactory;
import contacts.model.contact.ContactFactory;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

import java.util.Locale;

public class Menu {

    private static final TaskHandlerContext taskHandlerContext = new TaskHandlerContext();


    public static void menu() {

        ContactsRepository contactsRepository = ContactsRepository.getInstance();

        try {
            TextPrinter.printEnterAction();
            String inputText = CommandReader.readCommand();

            Command command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

            while (!command.equals(Command.EXIT)) {

                switch (command) {
                    case EDIT:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskEditStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case ADD:
                        ContactFactory contactFactory = new ConcreteContactFactory();
                        TextPrinter.printEnterTypeOfContact();
                        String inputContactType = CommandReader.readCommand();
                        contactsRepository.addContact(contactFactory.getContact(inputContactType));
                        TextPrinter.printRecordCreated();

                        break;

                    case REMOVE:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskRemoveStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case COUNT:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskCountStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case INFO:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskInfoStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case FEED:
                        DataBaseFeeder.feedDataBase();
                        break;

                    default:
                        System.out.println("Unknown command");
                }

                TextPrinter.printNextLine();
                TextPrinter.printEnterAction();

                inputText = CommandReader.readCommand();

                command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));
            }

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
