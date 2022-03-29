package contacts.model.contact;

import java.time.LocalDateTime;

public abstract class Contact {

    protected String name;
    protected PhoneNumber phoneNumber;
    protected LocalDateTime timeOfCreation;
    protected LocalDateTime timeOfLastEdit;


    protected Contact(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeOfCreation = LocalDateTime.now();
        this.timeOfLastEdit = LocalDateTime.now();
    }

    public abstract String nameToString();
}
