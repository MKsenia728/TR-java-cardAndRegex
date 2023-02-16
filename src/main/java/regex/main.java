package regex;

import java.util.List;

public class main {
    public static void main(String[] args) {

        String fileName = "outputCardData.txt";
        Service service = new Service(10);

        service.createDataBaseCards();
        service.printDataBase();
        service.createListCardInString();

        WriterToFile writerToFile = new WriterToFile();
        writerToFile.writer(fileName, service.listCardString);
        ReaderFromFile readerFromFile = new ReaderFromFile();
        List<String> listStringCardInput = readerFromFile.reader(fileName);

        DataParsing dataParsing = new DataParsing();
        dataParsing.parse(listStringCardInput);
        dataParsing.listOutput.forEach(System.out::println);
    }
}
