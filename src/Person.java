import java.util.Date;
import java.util.Random;

public class Person {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int phone;
    private Date dateOfBirth;
    private int age;
    private String gender;
    private String phoneType;

    public Person(int id, String firstName, String middleName, String lastName, int phone, Date dateOfBirth, int age, String gender, String phoneType) {
        this.id =(new Random()).nextInt(100);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.phoneType = phoneType;
    }
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + middleName + '\'' +
                ", fathername='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + dateOfBirth +
                ", age=" + age +
                ", gender=" + gender +
                ", phonetype=" + phoneType +
                '}';
    }
}
    enum Gender {
        MALE, FEMALE
    }

    enum Type {
        MOBILE, HOME, FAX
    }
