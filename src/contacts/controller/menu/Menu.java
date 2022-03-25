package contacts.controller.menu;

import contacts.controller.DataBaseFeeder;
import contacts.controller.ContactCreationDirector;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.handler.strategy.TaskCountStrategy;
import contacts.controller.handler.strategy.TaskHandlerContext;
import contacts.controller.handler.strategy.TaskRemoveStrategy;
import contacts.model.db.ContactsRepository;
import contacts.view.TextPrinter;

import java.util.Locale;

public class Menu {

     private static final TaskHandlerContext taskHandlerContext = new TaskHandlerContext();


    public static void menu() {
        ContactCreationDirector contactCreationDirector = ContactCreationDirector.getContactCreationDirector();
        ContactsRepository contactsRepository = ContactsRepository.getInstance();

        try {
            TextPrinter.printEnterAction();
            String inputText = CommandReader.readCommand();

            Command command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

            while (!command.equals(Command.EXIT)) {

                switch (command) {
                    case EDIT:
                        System.out.println("edit");
                        break;

                    case ADD:

                        contactsRepository.addContact(contactCreationDirector.createContact());
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

                    case LIST:
                        TextPrinter.printContactList(contactsRepository.getContactsRepository());
                        break;

                    case FEED:
                        DataBaseFeeder.feedDataBase();
                        break;

                    default:
                        System.out.println("Unknown command");
                }

                TextPrinter.printEnterAction();

                inputText = CommandReader.readCommand();

                command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));
            }

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
