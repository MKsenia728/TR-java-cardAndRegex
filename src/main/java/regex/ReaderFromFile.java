package regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {
    public List<String> reader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            System.out.println("File " + fileName + " is read successful");
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
