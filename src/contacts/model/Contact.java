package contacts.model;

import contacts.controller.verification.InputVerification;
import contacts.view.TextPrinter;

public class Contact {

    private String name;
    private String surname;
    private String phoneNumber;


    private Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + phoneNumber;
    }

    public static class ContactBuilder{

        private String name;
        private String surname;
        private String phoneNumber;

        public ContactBuilder(){}

        public ContactBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ContactBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ContactBuilder setPhoneNumber(String phoneNumber) {
            if(InputVerification.isPhoneNumberValid(phoneNumber)){
                this.phoneNumber = phoneNumber;
            } else {
                this.phoneNumber = "[no number]";
                TextPrinter.printPhoneNumberWrong();
            }
            return this;
        }



        public Contact build(){
            return new Contact(name, surname, phoneNumber);
        }
    }
}
