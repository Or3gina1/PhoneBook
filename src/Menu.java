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
    public Person person;

    public Menu() {
        phonebook = new Phonebook();
        scanner = new Scanner(System.in);
        person = new Person();
    }

    public void start() throws ParseException {
        String action;
        do {
            System.out.println("\n1 - Добавить пользователя"); // сделано
            System.out.println("2 - Удалить пользователя "); //не сделано
            System.out.println("3 - Редактирование контактов"); // не сделано
            System.out.println("4 - Поиск контактов"); // не сделано
            System.out.println("5 - Фильтрация контактов"); // не сделано
            System.out.println("6 - Сортировка контактов"); //не сделано
            System.out.println("7 - сохранить в файл"); // сделано
            System.out.println("8 - выход"); // сделано

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
                System.out.println("Поиск");
                searchMenu();
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

    public void searchMenu() throws ParseException {
        System.out.println("\n==Меню поиска==");
        System.out.println("==1 Поиск по имени==");
        System.out.println("==2 Найти по фамилии==");
        System.out.println("==3 Найти по Отчеству==");
        System.out.println("==4 Поиск по номеру телефона==");
        System.out.println("==5 Поиск по типу телефона==");
        System.out.println("==6 Поиск по возрасту==");
        System.out.println("==7 Поиск по полу==");
        System.out.println("==8 Просмотреть контакты");
        System.out.println("==9 Вернуться назад==");
        phonebook.searchLogic();
    }
}

