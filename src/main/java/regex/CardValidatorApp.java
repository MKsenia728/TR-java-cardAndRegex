package regex;

import java.util.List;

public class CardValidatorApp {
    public static void main(String[] args) {

        String fileName = "outputCardData.txt";
        CardService service = new CardService(10);

        service.createDataBaseCards();
        service.printDataBase();
        service.createListCardInString();

        CardFileWriter writerToFile = new CardFileWriter();
        writerToFile.writer(fileName, service.getListCardString());
        CardFileReader readerFromFile = new CardFileReader();
        List<String> listStringCardInput = readerFromFile.reader(fileName);

        CardDataParser dataParsing = new CardDataParser();
        dataParsing.parse(listStringCardInput);
        dataParsing.listOutput.forEach(System.out::println);
    }
}
