import java.awt.*;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Menu {
    private Phonebook phonebook;
    private Scanner scanner;

    public Menu() {
        phonebook = new Phonebook();
        scanner = new Scanner(System.in);
    }

    public void start() {
        String action;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Добавить пользователя"); // не сделано
            System.out.println("2 - Удалить пользователя "); //не сделано
            System.out.println("3 - Редактирование"); // не сделано
            System.out.println("4 - Поиск *"); // не сделано
            System.out.println("5 - Фильтрация пользователей"); // не сделано
            System.out.println("6 - сортировка пользователей"); //не сделано
            System.out.println("7 - сохранить в файл"); // не сделано
            System.out.println("8 - выход"); // не сделано

            action = scanner.nextLine();
            if (action.equals("1")) {
                addPerson();
            } else if (action.equals("2")) {
                System.out.println("удаление пользователя по какому то парамеру"); //скорее всего по Id

            } else if (action.equals("3")) {
                System.out.println("редактировать"); //уже добавленного

            } else if (action.equals("4")) {
                System.out.println("Поиск"); // нужно ли реализовывать поиск и по * и по _

            } else if (action.equals("5")) {
                System.out.println("Фильтрация пользователей"); //постараться сделать через стрим

            } else if (action.equals("6")) {
                System.out.println("сортировка пользователей"); //постараться сделать через стрим

            } else if (action.equals("7")) {
                System.out.println("сохранение всей информации в файл. указать расширение");

            } else if (action.equals("8")) {
                System.out.println("Выход");
                break;
            } else System.out.println("Неправильный выбор!");
        } while (true);
        scanner.close();
    }

    private void addPerson() { //почему он просит пустой метод ?
    }


    private void addPerson (Person person) {
        System.out.print("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        person.setFirstName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        person.setMiddleName(scanner.nextLine());
        System.out.print("Введите отчество: ");
        person.setLastName(scanner.nextLine());
        System.out.print("Введите номер телефона: ");
        person.setPhone(scanner.nextInt());
        System.out.print("Введите дату рождения: ");
        person.setDateOfBirth(new Date(Long.parseLong(scanner.nextLine())));
        System.out.print("Введите возраст");
        person.setAge(calculateAge(person.getDateOfBirth()));
//        System.out.print("Введите пол: ");
//        person.setGender(Person.(scanner.nextLine()));
//        System.out.print("Enter type: ");
//        person.setType(Person.getTypeByName(scanner.nextLine()));
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contacts.txt"));
            out.writeObject(this.phonebook);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // Запросить у пользователя информацию о человеке
        // Создать новый объект Person
        // Добавить человека в телефонную книгу


    private void deletePerson() {
        // Запросить у пользователя информацию о человеке (например, ID, имя)
        // Найти человека в телефонной книге
        // Удалить человека из телефонной книги
    }

    private void editPerson() {
        // Запросить у пользователя информацию о человеке (например, ID, имя)
        // Найти человека в телефонной книге
        // Запросить у пользователя новую информацию
        // Создать новый объект Person с новой информацией
        // Обновление информации о человеке в телефонной книге
    }

    private void searchByName() {
        // Запросить у пользователя имя для поиска
        // Вызов метода SearchByName телефонной книги
        // Отображение результатов поиска
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
//    public void save() {
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("contacts.txt"));
//            List<Person> contactsFromFile = (List<Person>) in.readObject();
//            in.close();
//            this.phonebook = contactsFromFile;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

