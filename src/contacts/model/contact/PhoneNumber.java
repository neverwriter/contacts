package contacts.model.contact;

import contacts.controller.verification.InputVerification;
import contacts.view.TextPrinter;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        if(InputVerification.isPhoneNumberValid(phoneNumber)){
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
            TextPrinter.printPhoneNumberWrong();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
