import java.util.Date;
import java.util.Random;
enum Gender {
    Муж, Жен
}

enum Phonetype {
    MOBILE(0), HOME(1), FAX(2);

    private final int value;

    Phonetype (int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
public class Person {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Phonetype getPhonetype() {
        return phonetype;
    }
    public void setPhonetype(Phonetype phonetype) {
        this.phonetype = phonetype;
    }

    private int id;
    private String name;
    private String surname;
    private String fathername;
    private String phone;
    private Date dateOfBirth;
    private int age;
    private Gender gender;
    private Phonetype phonetype;

    public Person(){

    }
    public Person(int id, String name, String surname, String fathername, String phone, Date dateOfBirth, int age, Gender gender, Phonetype phonetype) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.phonetype = phonetype;
    }
    public String toString() {
        return "========================="+'\n'+
                " Абонент " +
                " id => " + id + '\n'+
                " Фамилия => " + surname + '\n' +
                " Имя => " + name + '\n' +
                " Отчество => " + fathername + '\n' +
                " Номер телефона => " + phone +
                " Тип телефона => " + phonetype + '\n'+
                " Дата рождения =>" + dateOfBirth + '\n'+
                " Возраст =>" + age + '\n'+
                " пол =>" + gender + '\n' +
                "========================================";
    }
}
