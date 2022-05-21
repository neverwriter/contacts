package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.controller.menu.RecordMenu;
import contacts.model.contact.Contact;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO javadoc
 */
public class TaskSearchStrategy implements TaskHandlerStrategy {

    private static final ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();

    private static final TaskHandler taskHandler = TaskHandler.getInstance();

    private static final Logger logger = LogManager.getLogger(TaskSearchStrategy.class);

    private static final String SEARCH_EXPRESSION_REGEX = ".*%s.*";

    private Map<Integer, Integer> contactIdMap = new HashMap<>();

    @Override
    public void execute(Command command) {

        boolean isSearchAgain = false;

        do {
            TextPrinter.printEnterSearchQuery();

            String searchQuery = CommandReader.readCommand();

            ArrayList<Contact> contacts = contactRepository.getAllContacts();

            Map<Integer, Contact> searchResults = searchInContacts(contacts, searchQuery);

            if (searchResults.size() == 0) {
                logger.error("Repository is empty!");
                return;
            }

            TextPrinter.printFoundSearchResults(searchResults.size());
            TextPrinter.printContactMap(searchResults);

            isSearchAgain = searchAction(searchResults);

        } while (isSearchAgain);
    }

    private Map<Integer, Contact> searchInContacts(ArrayList<Contact> contacts, String searchQuery) {

        Map<Integer, Contact> searchResults = new HashMap<>();
        contactIdMap.clear();
        int counter = 1;

        for (Contact contact : contacts) {

            if (isPatternMatches(contact.getAppendedAllFields(), searchQuery)) {
                searchResults.put(contacts.indexOf(contact), contact);
                contactIdMap.put(counter, contacts.indexOf(contact));
                counter++;
            }


        }

        return searchResults;
    }

    private boolean isPatternMatches(String appendedContact, String searchQuery) {

        Pattern pattern = Pattern.compile(String.format(SEARCH_EXPRESSION_REGEX, searchQuery), Pattern.CASE_INSENSITIVE);

        if (AppConfiguration.getInstance().isDebugLoggingEnable()) {
            logger.debug(String.format(SEARCH_EXPRESSION_REGEX, searchQuery));
        }

        Matcher matcher = pattern.matcher(appendedContact);

        return matcher.matches();
    }

    private boolean searchAction(Map<Integer, Contact> searchResult) {

        String inputText;
        Command command;

        TextPrinter.printNextLine();
        TextPrinter.printEnterSearchAction();

        inputText = CommandReader.readCommand();

        if (taskHandler.isNumeric(inputText)) {

            try {
                int number = Integer.parseInt(inputText);
                int contactId = contactIdMap.get(number);

                TextPrinter.printContact(searchResult.get(contactId));

                RecordMenu.recordMenu(contactId);

            } catch (Exception exception) {
                logger.error("The exception: [" + exception.getMessage() + "] was thrown.");
            }
            return false;
        }

        command = Command.valueOf(inputText.toUpperCase(Locale.ROOT));

        switch (command) {

            case BACK:
                return false;

            case AGAIN:
                return true;

            default:
                System.out.println("Unknown command");
                return false;
        }


    }



}
