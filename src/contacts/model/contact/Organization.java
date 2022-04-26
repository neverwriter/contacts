package contacts.model.contact;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Organization extends Contact implements Serializable {

    private String address;

    private Organization(String name, String address, PhoneNumber phoneNumber) {
        super(name, phoneNumber);
        this.address = address;

    }

    public void setName(String name) {
        super.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumberString) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber(phoneNumberString);
        super.phoneNumber = phoneNumber;
    }

    @Override
    public List<String> getEditableFields() {
        List<String> editableList=new ArrayList<>();
        editableList.add("name");
        editableList.add("address");
        editableList.add("phoneNumber");
        return editableList;
    }

    @Override
    public String nameToString() {
        return super.name;
    }

    @Override
    public void editField(String fieldName, String fieldValue) throws InvocationTargetException, IllegalAccessException {
        Method[] methods= getClass().getMethods();
        String methodName="set"+fieldName.substring(0,1).toUpperCase(Locale.ROOT)+fieldName.substring(1);
        for(Method method:methods){
            if(method.toString().equals(methodName)){
                method.invoke(this,fieldValue);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Organization name: " + super.name +
                "\nAddress: " + address +
                "\nNumber: " + super.phoneNumber.getPhoneNumber() +
                "\nTime created: " + super.timeOfCreation.withSecond(0).withNano(0) +
                "\nTime last edit: " + super.timeOfLastEdit.withSecond(0).withNano(0);
    }

    public static class OrganizationBuilder{

        private String name;
        private String address;
        private PhoneNumber phoneNumber;

        public OrganizationBuilder(){}

        public OrganizationBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public OrganizationBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public OrganizationBuilder setPhoneNumber(String phoneNumberString) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setPhoneNumber(phoneNumberString);

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Organization build() {return new Organization(name, address, phoneNumber);}
    }
}
