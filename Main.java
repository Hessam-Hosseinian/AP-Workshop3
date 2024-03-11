import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            } else if (command.startsWith("contacts -a")) {

                String[] parts = command.split(" ");
                String firstName = parts[3];
                String lastName = parts[4];
                firstName = firstName.replace(">", "");
                // System.out.println(firstName);
                lastName = lastName.replace("<", "");
                // System.out.println(parts[4]);

                System.out.println("Please enter contact`s group");
                String group = scanner.next();
                System.out.println("Please enter contact`s email");
                String email = scanner.next();
                System.out.println("Please enter contact`s country code");
                String countryCode = scanner.next();
                System.out.println("Please enter contact`s phone number");
                String phoneNumber = scanner.next();
                System.out.println("Please enter contact`s zip code");
                String zipCode = scanner.next();
                System.out.println("Please enter contact`s zip country");
                String country = scanner.next();
                System.out.println("Please enter contact`s zip city");
                String city = scanner.next();

                Contact contact = new Contact(group, email, firstName, lastName,
                        new PhoneNumber(countryCode, phoneNumber), new Address(zipCode, country, city));

                boolean result = phoneBook.addContact(contact);

                if (result) {
                    System.out.println("Contact saved!");
                } else {
                    System.out.println("Contact already exists!");
                }
            } else if (command.startsWith("contacts -r")) {

                String[] parts = command.split(" ");
                String firstName = parts[3];
                String lastName = parts[4];
                firstName = firstName.replace(">", "");
                // System.out.println(firstName);
                lastName = lastName.replace("<", "");
                // System.out.println(parts[4]);
                boolean result = phoneBook.deleteContact(firstName, lastName);

                if (result) {
                    System.out.println("Contact removed successfully!");
                } else {
                    System.out.println("Contact not found!");
                }
            } else if (command.startsWith("show -g")) {

                String[] parts = command.split(" ");
                String groupName = parts[2];
                // System.out.println(groupName);
                groupName = groupName.replace("<", "");

                ArrayList<Contact> groupContacts = phoneBook.findContacts(groupName);

                if (groupContacts != null) {
                    for (Contact contact : groupContacts) {
                        System.out.println(contact.toString());
                    }
                } else {
                    System.out.println("No contacts found in the specified group.");
                }
            } else if (command.startsWith("show -c")) {

                String[] parts = command.split(" ");
                String firstName = parts[3];
                String lastName = parts[4];
                firstName = firstName.replace(">", "");
                // System.out.println(firstName);
                lastName = lastName.replace("<", "");
                // System.out.println(parts[4]);

                Contact contact = phoneBook.findContact(firstName, lastName);

                if (contact != null) {
                    System.out.println(contact.toString());
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (command.equals("show")) {
                phoneBook.printContacts();
            }
        }
    }
}
