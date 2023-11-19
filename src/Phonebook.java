import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    public List<Person> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    public void addPerson(Person person) {
        contacts.add(person);
    }

    public void deletePerson(Person person) {
        contacts.remove(person);
    }

    public void editPerson(Person oldPerson, Person newPerson) {
        int index = contacts.indexOf(oldPerson);
        if (index >= 0) {
            contacts.set(index, newPerson);
        }
    }
    public List<Person> searchByName(String name) {
        List<Person> results = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)) {
                results.add(person);
            }
        }
        return results;
    }
    public List<Person> getContacts() {
        return contacts;
    }
}