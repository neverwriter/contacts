package contacts.controller.menu;

import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.handler.strategy.TaskHandler;
import contacts.controller.handler.strategy.TaskHandlerContext;
import contacts.controller.handler.strategy.TaskRemoveStrategy;
import contacts.controller.handler.strategy.edit.EditConcreatStrategy;
import contacts.controller.handler.strategy.edit.EditContext;
import contacts.view.TextPrinter;

import java.util.Locale;

public class RecordMenu {

    private static final TaskHandlerContext taskHandlerContext = new TaskHandlerContext();

    private static final TaskHandler taskHandler = TaskHandler.getInstance();

    public static void recordMenu(int recordNumber){

        try {

            String inputText;
            Command command;

            boolean isRun = true;

            while (isRun) {

                TextPrinter.printNextLine();
                TextPrinter.printEnterRecordAction();

                inputText = CommandReader.readCommand();

                command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

                switch (command) {
                    case EDIT:

                        EditContext editContext = new EditContext();

                        editContext.setEditStrategy(new EditConcreatStrategy());

                        taskHandler.updateContactByItsNumber(
                                editContext.executeStrategy(
                                        taskHandler.getContactByItsNumber(recordNumber)),
                                recordNumber);

                        TextPrinter.printSave();

                        TextPrinter.printContact(taskHandler.getContactByItsNumber(recordNumber));

                        break;

                    case DELETE:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskRemoveStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case MENU:
                        isRun = false;
//                        TextPrinter.printNextLine();
                        break;
                    default:
                        System.out.println("Unknown command");
                }


            }


        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
