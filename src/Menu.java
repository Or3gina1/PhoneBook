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
                person = new Person();
                phonebook.addPerson(person);
            } else if (action.equals("2")) {
                System.out.println("удаление пользователя по фамилии"); //скорее всего по Id
                phonebook.deleteSurname();
            } else if (action.equals("3")) {
                System.out.println("редактировать"); //уже добавленного

            } else if (action.equals("4")) {
                System.out.println("Поиск"); // нужно ли реализовывать поиск и по * и по _
                phonebook.searchByname(person);
            } else if (action.equals("5")) {
                System.out.println("Фильтрация пользователей");

            } else if (action.equals("6")) {
                System.out.println("сортировка пользователей по фамилии");
                phonebook.orderSurName();
            } else if (action.equals("7")) {
                phonebook.save();
            } else if (action.equals("8")) {
                System.out.println("Выход");
                break;
            } else System.out.println("Неправильный выбор!");
        } while (true);
        scanner.close();
    }
    }

