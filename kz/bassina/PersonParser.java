package kz.bassina;

import java.text.ParseException;

public class PersonParser {

    public Person parseLine(String personLine) throws ParseException {
        if (personLine == null || personLine.isEmpty()) {
            throw new ParseException("Вы ввели пустую строку", 0);
        }
        String[] parts = personLine.trim().split(" ");
        if (parts.length != 6) {
            throw new ParseException("Вы ввели неверное количество персональных данных, разделенных пробелом", 0);
        }

        String lastName = parts[0];
        if (!isValidName(lastName)) {
            throw new ParseException("Введена некорректная фамилия", 0);
        }
        String firstName = parts[1];
        if (!isValidName(firstName)) {
            throw new ParseException("Введено некорректное имя", 0);
        }
        String secondName = parts[2];
        if (!isValidName(secondName)) {
            throw new ParseException("Введено некорректное отчество", 0);
        }
        String birthDate = parts[3];
        if (!isValidDate(birthDate)) {
            throw new ParseException("Введена некорректная дата рождения", 0);
        }
        String phoneNumber = parts[4];
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new ParseException("Введен некорректный номер телефона", 0);
        }
        String gender = parts[5];
        if (!isValidGender(gender)) {
            throw new ParseException("Введен некорректно пол человека", 0);
        }

        return new Person(firstName, secondName, lastName, birthDate,
                gender.charAt(0), phoneNumber);
    }

    private static boolean isValidName(String name) {
        return name.matches("^(\\w+)|(\\p{L}+)$");
    }

    private static boolean isValidDate(String date) {
        // строка формата dd.mm.yyyy,
        return date.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\d+$");

    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }
}
