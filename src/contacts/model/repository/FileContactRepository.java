package contacts.model.repository;

import contacts.config.AppConfiguration;
import contacts.model.contact.Contact;

import java.io.*;
import java.util.ArrayList;

public class FileContactRepository implements ContactRepository {

    private static FileContactRepository instance;

    private final ArrayList<Contact> fileContactRepository = new ArrayList<>();

    private FileContactRepository() {
    }

    public static FileContactRepository getInstance() {
        if (instance == null) {
            instance = new FileContactRepository();
        }
        return instance;
    }

    @Override
    public boolean removeContact(int contactNumber) {
        return false;
    }

    @Override
    public Contact getContactByNumber(int contactNumber) {
        return null;
    }

    @Override
    public void updateContactByNumber(Contact editedContact, int contactNumber) {

    }

    @Override
    public void addContact(Contact newContact) {
        fileContactRepository.add(newContact);

        try {
            serialize(fileContactRepository, AppConfiguration.getInstance().getFileContactRepositoryDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getNumberOfContacts() {
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contacts = null;

        try {
            contacts = (ArrayList<Contact>) deserialize(AppConfiguration.getInstance().getFileContactRepositoryDirectory());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean isContactListEmpty() {
        return false;
    }

    /**
     * Serialize the given object to the file
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    /**
     * Deserialize to an object from the file
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

}
