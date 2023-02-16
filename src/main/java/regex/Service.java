package regex;

import java.util.ArrayList;
import java.util.List;

public class Service {
    DataGenerate dtGen = new DataGenerate();
    DataBase dataBase = new DataBase();
    CardInString cardInString = new CardInString();
    List<String> listCardString = new ArrayList<>();
    int countRecords;

    public Service(int countRecords) {
        this.countRecords = countRecords;
    }

    public void createDataBaseCards() {
        for (int i = 0; i < countRecords; i++) {
            dataBase.add(new Card(dtGen.generateAccount(), dtGen.generateFirstName(), dtGen.generateLastName(), dtGen.generateCVV(), dtGen.generateMonth(), dtGen.generateYear()));
        }
    }

    public void printDataBase() {
        for (Card card: dataBase.getDataBaseCard()) {
            card.printCard();
        }
    }

    public void createListCardInString() {
        dataBase.getDataBaseCard().forEach(card -> listCardString.add(cardInString.transCardToString(card)));
    }
}
