package contacts.controller.handler.strategy;

import contacts.config.AppConfiguration;
import contacts.controller.command.Command;
import contacts.controller.command.CommandReader;
import contacts.model.contact.Contact;
import contacts.model.repository.ContactRepository;
import contacts.view.TextPrinter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * TODO javadoc
 */
public class TaskSearchStrategy implements TaskHandlerStrategy {

    ContactRepository contactRepository = AppConfiguration.getInstance().getContactRepository();

    private static Logger logger = LogManager.getLogger(TaskSearchStrategy.class);

    private static final String SEARCH_EXPRESSION_REGEX = ".*%s.*";

    @Override
    public void execute(Command command) {

        TextPrinter.printEnterSearchQuery();

        String searchQuery = CommandReader.readCommand();

        ArrayList<Contact> contacts = contactRepository.getAllContacts();

        ArrayList<Contact> searchResults = searchInContacts(contacts, searchQuery);

        if (searchResults != null) {

            TextPrinter.printFoundSearchResults(searchResults.size());
            TextPrinter.printContactList(searchResults);

        } else {
            logger.debug("Repository is empty!");
        }
    }

    private ArrayList<Contact> searchInContacts(ArrayList<Contact> contacts, String searchQuery) {

        return null;
    }


}
