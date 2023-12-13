package kz.bassina;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonFileWriter {

    public void writeToFile(Person person) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(person.getLastName() + ".txt ", true));
        writer.write(person.toString());
        writer.newLine();
        writer.close();
    }
}
