package kz.bassina;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class HomeworkMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersonParser personParser = new PersonParser();
        PersonFileWriter personFileWriter = new PersonFileWriter();

        while (true) {
            System.out.println("Введите персональные данные одной строкой вида: " +
                    "Фамилия Имя Отчество дата_рождения номер_телефона пол, " +
                    "где параметры разделены одним пробелом, " +
                    "дата рождения - строка формата dd.mm.yyyy, " +
                    "номер телефона - целое беззнаковое число без форматирования, " +
                    "пол - символ латиницей f или m.");
            System.out.println("Введите слово exit, если хотите выйти из программы");

            String nextLine = scanner.nextLine();

            if ("exit".equalsIgnoreCase(nextLine)) {
                return;
            }

            try {
                Person person = personParser.parseLine(nextLine);
                personFileWriter.writeToFile(person);
                System.out.println("Данные успешно записаны в файл " + person.getLastName() + ".txt" + "\n");
            } catch (ParseException e) {
                System.out.println("Не удалось создать запись о персональных данных. Причина: " + e.getMessage() + "\n");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл. " + e.getMessage() + "\n");
            }
        }
    }
}
