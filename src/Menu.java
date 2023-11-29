import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Menu {
    private Phonebook phonebook;
    private Scanner scanner;

//    public Person (){
//
//    };
    public Person person;

    public Menu() {
        phonebook = new Phonebook();
        scanner = new Scanner(System.in);
        person = new Person();// нужно ли так делать или иначе?
    }

    public void start() throws ParseException {
        String action;
        do {
            System.out.println("\n1 - Добавить пользователя"); // не сделано
            System.out.println("2 - Удалить пользователя "); //не сделано
            System.out.println("3 - Редактирование"); // не сделано
            System.out.println("4 - Поиск *"); // не сделано
            System.out.println("5 - Фильтрация пользователей"); // не сделано
            System.out.println("6 - сортировка пользователей"); //не сделано
            System.out.println("7 - сохранить в файл"); // не сделано
            System.out.println("8 - выход"); // не сделано

            action = scanner.nextLine();
            if (action.equals("1")) {
                phonebook.addPerson(person);
            } else if (action.equals("2")) {
                System.out.println("удаление пользователя по какому то парамеру"); //скорее всего по Id
//                phonebook.deletePerson(person);
            } else if (action.equals("3")) {
                System.out.println("редактировать"); //уже добавленного

            } else if (action.equals("4")) {
                System.out.println("Поиск"); // нужно ли реализовывать поиск и по * и по _
                phonebook.search(person);
            } else if (action.equals("5")) {
                System.out.println("Фильтрация пользователей"); //постараться сделать через стрим

            } else if (action.equals("6")) {
                System.out.println("сортировка пользователей"); //постараться сделать через стрим

            } else if (action.equals("7")) {
                phonebook.save(person);
            } else if (action.equals("8")) {
                System.out.println("Выход");
                break;
            } else System.out.println("Неправильный выбор!");
        } while (true);
        scanner.close();
    }
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

