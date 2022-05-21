package contacts.config;

import contacts.model.repository.ContactRepository;

/**
 * Main configuration class as Singleton
 *
 * contactRepository - contains specified on program startup repository type.
 *
 * @author PatrykLewczuk
 */
public class AppConfiguration {

    private static AppConfiguration appConfigurationInstance;

    private ContactRepository contactRepository;

    private String fileContactRepositoryDirectory;

    /** Variable which controls if debug level logs are visible in console */
    private final boolean debugLoggingEnable = false;

    private AppConfiguration() {}

    public static AppConfiguration getInstance() {
        if (appConfigurationInstance == null) {
            appConfigurationInstance = new AppConfiguration();
        }
        return appConfigurationInstance;
    }

    //Getters and setters.
    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public String getFileContactRepositoryDirectory() {
        return fileContactRepositoryDirectory;
    }

    public void setFileContactRepositoryDirectory(String fileContactRepositoryDirectory) {
        this.fileContactRepositoryDirectory = fileContactRepositoryDirectory;
    }

    public boolean isDebugLoggingEnable() {
        return debugLoggingEnable;
    }
}
