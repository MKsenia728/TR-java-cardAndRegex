package regex;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        DataGenerate dtGen = new DataGenerate();
        DataBase dataBase = new DataBase();
        String fileName = "outputCardData.txt";
//        generate data and create dataBase
        for (int i = 0; i < 10; i++) {
            dataBase.add(new Card(dtGen.generateAccount(), dtGen.generateFirstName(), dtGen.generateLastName(), dtGen.generateCVV(), dtGen.generateMonth(), dtGen.generateYear()));
        }
        List<Card> listCard = dataBase.getDataBaseCard();
        for (Card card: listCard) {
            card.printCard();
        }
//        translate to string and write to file
        CardInString cardInString = new CardInString();
        List<String> listStringCartOutput = new ArrayList<>();
        listCard.forEach(card -> listStringCartOutput.add(cardInString.setCardInString(card)));
        WriterToFile writerToFile = new WriterToFile();
        writerToFile.writer(fileName, listStringCartOutput);
//        read from file to list
        ReaderFromFile readerFromFile = new ReaderFromFile();
        List<String> listStringCardInput = readerFromFile.reader(fileName);

        DataParsing dataParsing = new DataParsing();
        dataParsing.parse(listStringCardInput);
        dataParsing.listOutput.forEach(System.out::println);
    }
}
