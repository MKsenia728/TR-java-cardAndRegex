package regex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class CardFileWriter {

    public void writer(String fileName, String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(str);
            System.out.println("File " + fileName + " is written successful");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    public void writer(String fileName, List<String> ls) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String str: ls) {
                writer.write(str);
            }
            System.out.println("File " + fileName + " is written successful");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
