package contacts.model.contact;

import contacts.view.TextPrinter;

import java.util.Scanner;

public class OrganizationCreationDirector {

    private static OrganizationCreationDirector organizationCreationDirector;

    private OrganizationCreationDirector(){}

    public static OrganizationCreationDirector getOrganizationCreationDirector(){
        if(organizationCreationDirector == null){
            organizationCreationDirector = new OrganizationCreationDirector();
        }
        return organizationCreationDirector;
    }

    public Organization createOrganization(){
        Scanner scanner = new Scanner(System.in);

        Organization.OrganizationBuilder organizationBuilder = new Organization.OrganizationBuilder();

        TextPrinter.printEnterName();
        organizationBuilder.setName(scanner.nextLine());

        TextPrinter.printEnterAddress();
        organizationBuilder.setAddress(scanner.nextLine());

        TextPrinter.printEnterPhoneNumber();
        organizationBuilder.setPhoneNumber(scanner.nextLine());

        return organizationBuilder.build();
    }

}
