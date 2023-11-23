import java.util.Date;
import java.util.Random;
enum Gender {
    MALE, FEMALE
}

enum Phonetype {
    MOBILE, HOME, FAX
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

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
    public void getGender (Gender gender){
        this.gender =gender;

    }
    public void changeGender(Gender gender){
        this.gender = gender;
    }

    private int id;
    private String name;
    private String surname;
    private String fathername;
    private String phone;
    private Date dateOfBirth;
    private int age;
    private Gender gender;
    private String phoneType;
    public Person(){ // Пустой конструктор запилил

    }

    public Person(int id, String name, String surname, String fathername, String phone, int age, Date dateOfBirth) {
        this.id =(new Random()).nextInt(100);
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
//        this.gender = gender;
//        this.phoneType = phoneType;
    }
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fathername='" + fathername + '\'' +// для чего мы это делаем ? чтобы потом выводить в файл?
                ", phone='" + phone + '\'' +
                ", birthdate=" + dateOfBirth +
                ", age=" + age +
                ", gender=" + gender +
                ", phonetype=" + phoneType +
                '}';
    }
}
