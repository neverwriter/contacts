package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.menu.RecordMenu;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class TaskInfoStrategy implements TaskHandlerStrategy {

    private static final Logger logger = LogManager.getLogger(TaskInfoStrategy.class);

    private static final ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();
    private static final TaskHandler taskHandler = TaskHandler.getInstance();

    @Override
    public void execute(Command command) {

        TextPrinter.printContactList(contactRepository.getAllContacts());

        listAction();

    }

    private void listAction(){
        String inputText;
        Command command;

        TextPrinter.printNextLine();
        TextPrinter.printEnterListAction();

        inputText = CommandReader.readCommand();

        if (taskHandler.isNumeric(inputText)) {

            try {
                int contactNumber = Integer.parseInt(inputText) -1;

                TextPrinter.printContact(taskHandler.getContactByItsNumber(contactNumber));

                RecordMenu.recordMenu(contactNumber);

            } catch (Exception exception) {
                logger.error("The exception: [" + exception.getMessage() + "] was thrown.");
            }
            return;
        }

        command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

        if (command == Command.BACK) {
            return;
        }
        System.out.println("Unknown command");
        return;
    }
}
