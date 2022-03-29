package contacts.model.contact;

public class Organization extends Contact{

    private String address;

    private Organization(String name, String address, PhoneNumber phoneNumber) {
        super(name, phoneNumber);
        this.address = address;

    }

    @Override
    public String nameToString() {
        return super.name;
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
