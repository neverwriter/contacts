package contacts.model.contact;

import contacts.controller.verification.InputVerification;
import contacts.view.TextPrinter;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Person extends Contact implements Serializable {

    private String surname;
    private String birthDate;
    private String gender;


    private Person(String name, String surname, PhoneNumber phoneNumber, String birthDate, String gender) {
        super(name, phoneNumber);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }


    public void setName(String name) {
        super.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumberString) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber(phoneNumberString);
        super.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) {
        if(InputVerification.isBirthDateValid(birthDate)){
            this.birthDate = birthDate;
        } else {
            TextPrinter.printBirthDateWrong();
            this.birthDate = "[no data]";
        }
    }

    public void setGender(String gender) {
        if(InputVerification.isGenderValid(gender)){
            this.gender = gender;
        } else {
            TextPrinter.printGenderWrong();
            this.gender = "[no data]";
        }
    }

    @Override
    public String nameToString() {

        return String.format("%s %s",super.name, surname);
    }

    @Override
    public String toString() {
        return "Name: " + super.name +
                "\nSurname: " + surname +
                "\nBirth date: " + birthDate +
                "\nGender: " + gender +
                "\nNumber: " + super.phoneNumber.getPhoneNumber() +
                "\nTime created: " + super.timeOfCreation.withSecond(0).withNano(0) +
                "\nTime last edit: " + super.timeOfLastEdit.withSecond(0).withNano(0);
    }

    @Override
    public List<String> getEditableFields() {
        List<String> editableList=new ArrayList<>();
        editableList.add("name");
        editableList.add("surname");
        editableList.add("birthDate");
        editableList.add("phoneNumber");
        editableList.add("gender");
        return editableList;
    }

    @Override
    public void editField(String fieldName, String fieldValue) throws InvocationTargetException, IllegalAccessException {
        Method[] methods= getClass().getMethods();
        String methodName="set"+fieldName.substring(0,1).toUpperCase(Locale.ROOT)+fieldName.substring(1);
        for(Method method:methods){
            if(method.getName().equals(methodName)){
                method.invoke(this,fieldValue);
                return;
            }
        }
    }

    public static class PersonBuilder {

        private String name;
        private String surname;
        private PhoneNumber phoneNumber;
        private String birthDate;
        private String gender;


        public PersonBuilder() {}

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setPhoneNumber(String phoneNumberString) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setPhoneNumber(phoneNumberString);

            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder setBirthDate(String birthDate){
            if(InputVerification.isBirthDateValid(birthDate)){
                this.birthDate = birthDate;
            } else {
                TextPrinter.printBirthDateWrong();
                this.birthDate = "[no data]";
            }

            return this;
        }

        public PersonBuilder setGender(String gender){
            if(InputVerification.isGenderValid(gender)){
                this.gender = gender;
            } else {
                TextPrinter.printGenderWrong();
                this.gender = "[no data]";
            }

            return this;
        }


        public Person build() {
            return new Person(name, surname, phoneNumber, birthDate, gender);
        }
    }
}
