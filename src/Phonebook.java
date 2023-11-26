import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Phonebook {
    public List<Person> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    public void addPerson(Person person) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        person.setName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        person.setSurname(scanner.nextLine());
        System.out.print("Введите отчество: ");
        person.setFathername(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        person.setPhone(scanner.nextLine());
        System.out.print("Введите дату рождения: формата дд.мм.гггг ");
        person.setDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse(scanner.nextLine()));
        person.setAge(calculateAge(person.getDateOfBirth()));
        System.out.println("Ваш возраст  " + calculateAge(person.getDateOfBirth()));
//        System.out.print("Введите пол: ");
//        person.changeGender(Person.getGender(scanner.nextLine()));
//        System.out.print("Enter type: ");
//        person.setType(Person.getTypeByName(scanner.nextLine()));
    }

    public void save(Person person) {
        System.out.println(person.toString());
        try (FileWriter writer = new FileWriter("contacts.txt")) {
                writer.write(person.getId() + "\n");
                writer.write(person.getName() + "\n");
                writer.write(person.getSurname() + "\n");
                writer.write(person.getFathername() + "\n");
                writer.write(person.getPhone() + "\n");
                writer.write(person.getDateOfBirth() + "\n");
                writer.write(person.getAge() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запросить у пользователя информацию о человеке
    // Создать новый объект Person
    // Добавить человека в телефонную книгу

    private int calculateAge(Date birthdate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String birthdateStr = dateFormat.format(birthdate);
        LocalDate birthdateLocal = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdateLocal, currentDate);
        int age = period.getYears();
        return age;
    }
//    public List<Person> deletePerson(id) {
//        contacts.remove(id);
//    }
    public void editPerson(Person oldPerson, Person newPerson) {
        int index = contacts.indexOf(oldPerson);
        if (index >= 0) {
            contacts.set(index, newPerson);
        }
    }
    public void search(Person person) { // в каждый метод
        List<Person> foundContacts = contacts.stream()
                .filter(contact -> contact.getName().equals("****"))//нужно ли добавлять сюда все поля?
                .filter(contact -> contact.getName().startsWith("****"))
                .collect(Collectors.toList());

        if (foundContacts.isEmpty()) {
            System.out.println("Контакт не найден.");
        } else {
            foundContacts.forEach(System.out::println);
        }
    }

}

