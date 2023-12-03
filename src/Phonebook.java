import java.io.*;
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
        contacts.add(person);
        Scanner scanner = new Scanner(System.in);
        person.setId((new Random()).nextInt(100));
        System.out.print("Введите Фамилию: ");
        person.setName(scanner.nextLine());
        System.out.print("Введите Имя: ");
        person.setSurname(scanner.nextLine());
//        System.out.print("Введите отчество: ");
//        person.setFathername(scanner.nextLine());
//        System.out.print("Введите номер телефона: ");
//        person.setPhone(scanner.nextLine());
//        System.out.print("Введите дату рождения: формата дд.мм.гггг ");
//        person.setDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse(scanner.nextLine()));
//        person.setAge(calculateAge(person.getDateOfBirth()));
//        System.out.println("Ваш возраст  " + calculateAge(person.getDateOfBirth()));

//        System.out.print("Введите пол: ");
//        person.changeGender(Person.getGender(scanner.nextLine()));
//        System.out.print("Enter type: ");
//        person.setType(Person.getTypeByName(scanner.nextLine()));
    }

//    public void save(Person person) {
//        try (FileWriter writer = new FileWriter("contacts.txt")) {
//                writer.write(person.getId() + "\n");
//                writer.write(person.getName() + "\n");
//                writer.write(person.getSurname() + "\n");
//                writer.write(person.getFathername() + "\n");
//                writer.write(person.getPhone() + "\n");
//                writer.write(person.getDateOfBirth() + "\n");
//                writer.write(person.getAge() + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        public void save() {
        try (FileOutputStream fileWriter = new FileOutputStream("contacts.txt")) {
            PrintWriter writer = new PrintWriter(fileWriter);
//            writer.write("");
            writer.append(contacts.toString());
            writer.close();
            fileWriter.close();
            System.out.println("Данные сохранены в файл contacts.txt");
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
    public void searchByname(Person person) {
        System.out.println("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        Optional<Person> foundPerson =contacts.stream()
        .filter(p->p.getName().equals(scanner.nextLine()))
                .findFirst();

        if (foundPerson.isPresent()){
            System.out.println("С таким именем найден контакт");
            System.out.println("Id "+foundPerson.get().getId());
            System.out.println("Фамилия "+foundPerson.get().getSurname());
            System.out.println("Имя "+foundPerson.get().getName());
            System.out.println("Отчество "+foundPerson.get().getFathername());
            System.out.println("Номер телефона "+foundPerson.get().getPhone());
            System.out.println("Дата рождения "+foundPerson.get().getDateOfBirth());
            System.out.println("Возраст "+foundPerson.get().getAge());
//            System.out.println("Пол "+foundPerson.get().getAge());
        }else {
            System.out.println("контакта с таким именем не существует");
        }
    }
    public void deleteSurname() throws ParseException {
        System.out.println("Введите фамилию человека, чьи данные хотите удалить:");
        Scanner scanner = new Scanner(System.in);
        for (Person person : contacts) {
            if (person.getSurname().equals(scanner.nextLine())) {
                contacts.remove(person);
                System.out.println("Данные у контакте  успешно удалены.");
                break;
            } else {
                System.out.println("Человек с таким такой фамилией не найден.");
            }
        }
    }
    public void deleteAll() throws ParseException {
        contacts.clear();
        System.out.println("Все данные удалены.");
    }
    public void orderSurName() {// поиск по фамилии так как она реже имеет совпадение)
        contacts.sort(Comparator.comparing(Person::getSurname));
        System.out.println("Результаты отсортированы по имени:");
        showAll();
    }
    public void showAll() {
        System.out.println("Общий список телефонный книги");
        if (contacts != null) {
            contacts.forEach((person) -> {
                System.out.println("Id: " + person.getId());
                System.out.println("Фамилия: " + person.getSurname());
                System.out.println("Имя: " + person.getName());
                System.out.println("Номер телефона: " + person.getPhone());
                System.out.println("Дата рождения: " + person.getDateOfBirth());
                System.out.println("Возраст: " + person.getAge());
                System.out.println("----------------------------------");
            });
        } else {
            System.out.println("Справочник пустой.");
        }
    }
}

