package contacts.controller.menu;

import contacts.controller.DataBaseFeeder;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.handler.strategy.*;
import contacts.view.TextPrinter;

import java.util.Locale;

public class Menu {

    private static final TaskHandlerContext taskHandlerContext = new TaskHandlerContext();


    public static void menu() {

        try {
//            TextPrinter.printEnterAction();
//            String inputText = CommandReader.readCommand();
//
//            Command command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));
            String inputText;
            Command command;

            boolean isRun = true;

            while (isRun) {

                TextPrinter.printNextLine();
                TextPrinter.printEnterAction();

                inputText = CommandReader.readCommand();

                command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

                switch (command) {
                    case EDIT:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskEditStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case ADD:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskAddStrategy());
                        taskHandlerContext.executeStrategy(command);
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

                    case SEARCH:
                        taskHandlerContext.setTaskHandlerStrategy(new TaskSearchStrategy());
                        taskHandlerContext.executeStrategy(command);
                        break;

                    case EXIT:
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
