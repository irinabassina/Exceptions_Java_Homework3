package kz.bassina;

public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private String birthDate;
    private char gender;
    private String phoneNumber;

    public Person(String firstName, String secondName, String lastName, String birthDate, char gender, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return this.getLastName() + " " + this.getFirstName() + " " + this.getSecondName()
                + " " + this.getBirthDate() + " " + this.getPhoneNumber() + " " + this.getGender();
    }
}
