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

    static Menu option = new Menu();
    Scanner scan = new Scanner(System.in);
//    int = option;

    public void addPerson(Person person) throws ParseException {
        contacts.add(person);
        Scanner scanner = new Scanner(System.in);
        person.setId((new Random()).nextInt(100));
        System.out.print("Введите Фамилию: ");
        person.setSurname(scanner.nextLine());
        System.out.print("Введите Имя: ");
        person.setName(scanner.nextLine());
        System.out.print("Введите отчество: ");
        person.setFathername(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        person.setPhone(scanner.nextLine());
        System.out.println("Введите тип номера телефона: MOBILE-0,HOME-1, FAX-2");
        int valueForTypePhone = scan.nextInt();
        person.setPhonetype(Phonetype.getPhoneType(valueForTypePhone));
        System.out.print("Введите дату рождения: формата дд.мм.гггг ");
        person.setDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse(scanner.nextLine()));
        person.setAge(calculateAge(person.getDateOfBirth()));
        System.out.println("Ваш возраст  " + calculateAge(person.getDateOfBirth()));
        System.out.println("Введите пол: Жен-0, Муж-1");
        int valueForGender = scanner.nextInt();
        person.setGender(Gender.getGenderType(valueForGender));
    }

    public void save() {
        try (FileOutputStream fileWriter = new FileOutputStream("contacts.txt")) {
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.append(contacts.toString());
            writer.close();
            fileWriter.close();
            System.out.println("Данные сохранены в файл contacts.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateAge(Date birthdate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String birthdateStr = dateFormat.format(birthdate);
        LocalDate birthdateLocal = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdateLocal, currentDate);
        int age = period.getYears();
        return age;
    }

    public void editPerson(Person oldPerson, Person newPerson) {
        int index = contacts.indexOf(oldPerson);
        if (index >= 0) {
            contacts.set(index, newPerson);
        }
    }
    public void searchLogic() throws ParseException {
        int select = scan.nextInt();
        switch (select) {
            case 1:
                searchByname();// поиск по имени
                option.searchMenu();
            case 2:
                searchBySurName();// поиск фамилии по фамилии
                option.searchMenu();
            case 3:
                searchByFatherName();// поиск по Отчеству
                option.searchMenu();
            case 4:
                searchByPhoneNumber();// поиск по номеру телефона
                option.searchMenu();
            case 5:
                searchByPhoneType();// поиск по Типу телефона
                option.searchMenu();
            case 6:
                searchByAge();// поиск по Возрасту
                option.searchMenu();
            case 7:
                searchByGender();// поиск по полу
                option.searchMenu();
            case 8:
                showAll();// Возврат в предыдущее меню
            case 9:
                option.start();
                break;
            default:
                System.out.println("Неверный выбор. Введите значение от 1 до 9: ");
        }
    }
    public void searchByname() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        List<Person> foundPerson = contacts.stream()
                                           .filter(p -> p.getName()
                                           .equals(name))
                                           .collect(Collectors.toList());
        for (Person person: foundPerson){
            System.out.println(person.toString());
        }
    }
    public void searchBySurName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String SurName = scanner.nextLine();
        List<Person> foundPerson = contacts.stream()
                .filter(p -> p.getSurname()
                        .equals(SurName))
                .collect(Collectors.toList());
        for (Person person: foundPerson){
            System.out.println(person.toString());
        }
    }
    public void searchByFatherName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Отчество: ");
        String FatherName = scanner.nextLine();
        List<Person> foundPerson = contacts.stream()
                .filter(p -> p.getFathername()
                        .equals(FatherName))
                .collect(Collectors.toList());
        for (Person person: foundPerson){
            System.out.println(person.toString());
        }
    }
    public void searchByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона: ");
        String PhoneNumber = scanner.nextLine();
        List<Person> foundPerson = contacts.stream()
                                           .filter(p -> p.getPhone()
                                           .equals(PhoneNumber))
                                           .collect(Collectors.toList());
        for (Person person: foundPerson){
            System.out.println(person.toString());
        }
    }
    public void searchByPhoneType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String PhoneType = scanner.nextLine();
        List<Person> foundPerson = contacts.stream()
                                           .filter(p -> p.getPhonetype()
                                           .equals(PhoneType))
                                           .collect(Collectors.toList());
        for (Person person: foundPerson){
            System.out.println(person.toString());
        }
    }
    public void searchByAge() {
        Scanner scanner = new Scanner(System.in);
        int ageMin;
        int ageMax;
        System.out.println("Введите минимальный возраст от: ");
        ageMin = scanner.nextInt();
        System.out.println("Введите максимальный возраст до: ");
        ageMax = scanner.nextInt();
        List<Person> foundPerson = contacts.stream()
                                           .filter(p -> p.getAge() >= ageMin && p.getAge() <= ageMax)
                                           .collect(Collectors.toList());
        for (Person person : foundPerson) {
            System.out.println(person.toString());
        }
    }
    public void searchByGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пол, (мужчина - м) (женщина - ж)");
        List<Person> foundPerson = contacts.stream()
                .filter(p -> p.getGender().equals(scanner.nextLine()))
                .collect(Collectors.toList());
        for (Person person : foundPerson) {
            System.out.println(person.toString());
        }
    }
    public void deleteSurname() throws ParseException {
        System.out.println("Введите фамилию человека, контактные данные которого вы хотите удалить:");
        Scanner scanner = new Scanner(System.in);
        String Surname = scanner.nextLine();
        boolean Remove = false;
        System.out.println("1");
        for (Person person : contacts) {
            System.out.println("2");
            if (person.getSurname()
                    .equals(Surname)) {
                contacts.remove(person);
                System.out.println("Данные о контакте  успешно удалены.");
                break;
            }
        }
        System.out.println("3");
        if (Remove == true) {
            System.out.println("Человек с таким такой фамилией не найден.");
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
                System.out.println("Отчество: " + person.getFathername());
                System.out.println("Номер телефона: " + person.getPhone());
                System.out.println("Тип телефона телефона: " + person.getPhonetype());
                System.out.println("Дата рождения: " + person.getDateOfBirth());
                System.out.println("Возраст: " + person.getAge());
                System.out.println("Пол: " + person.getGender());

            });
        } else {
            System.out.println("Справочник пустой.");
        }
    }
}

