import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Phonebook {
    public List<Person> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    public void addPerson(Person person) {
//        contacts.add(person);
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите имя: ");
//        person.setName(scanner.nextLine());
//        System.out.print("Введите фамилию: ");
//        person.setSurname(scanner.nextLine());
//        System.out.print("Введите отчество: ");
//        person.setFathername(scanner.nextLine());
//        System.out.print("Введите номер телефона: ");
//        person.setPhone(scanner.nextLine());
        System.out.print("Введите дату рождения: ");
        person.setDateOfBirth(new Date(Long.parseLong(scanner.nextLine())));
        System.out.print("Ваш возраст");
        person.setAge(calculateAge(person.getDateOfBirth()));
//        System.out.print("Введите пол: ");
//        person.changeGender(Person.getGender(scanner.nextLine()));
//        System.out.print("Enter type: ");
//        person.setType(Person.getTypeByName(scanner.nextLine()));
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contacts.txt"));
            out.writeObject(this.contacts);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запросить у пользователя информацию о человеке
        // Создать новый объект Person
        // Добавить человека в телефонную книгу
    }
    private int calculateAge(Date birthdate) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(birthdate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int age = year - 1950;
        if (month < 3) {
            age -= 4;
        }
        if (month == 12 && day == 29) {
            age--;
        }
        return age;
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
            if (person.getName().equalsIgnoreCase(name) || person.getFathername().equalsIgnoreCase(name)) {
                results.add(person);
            }
        }
        return results;
    }
    public List<Person> getContacts() {
        return contacts;
    }

    public void addPerson() { // снова просит пустой метод, почему он не видит выше
    }
}