import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getFirstName(), contact.getLastName()) != null) {

            return false;
        }

        contacts.add(contact);
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        Contact contact = findContact(firstName, lastName);

        if (contact != null) {
            contacts.remove(contact);
            return true;
        }

        return false;
    }

    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }

        return null;
    }

    public ArrayList<Contact> findContacts(String group) {
        ArrayList<Contact> matchingContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getGroup().equals(group)) {
                matchingContacts.add(contact);
            }
        }

        if (matchingContacts.size() > 0) {
            return matchingContacts;
        } else {

            return null;
        }
    }

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("no contact");

        }
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

}
