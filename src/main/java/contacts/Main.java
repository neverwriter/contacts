package contacts;

import contacts.config.AppConfiguration;
import contacts.controller.menu.Menu;
import contacts.model.repository.ContactRepository;
import contacts.model.repository.FileContactRepository;


/**
 * Application to organize contacts
 *
 * @author Patryk Lewczuk
 */
public class Main {
    public static void main(String[] args) {

        AppConfiguration appConfiguration = AppConfiguration.getInstance();
        ContactRepository contactRepository = FileContactRepository.getInstance();

        appConfiguration.setContactRepository(contactRepository);
        appConfiguration.setFileContactRepositoryDirectory("contactRepository.txt");

        Menu.menu();

    }
}
