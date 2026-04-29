package regex;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private final CardDataGenerator dtGen;
    private final CardRepository dataBase;
    private final RawCardData cardInString;
    private final List<String> listCardString = new ArrayList<>();
    private final int countRecords;

    public CardService(int countRecords) {
        this.countRecords = countRecords;
        dtGen = new CardDataGenerator();
        dataBase = new CardRepository();
        cardInString = new RawCardData();
    }

    public CardService(
            int countRecords,
            CardDataGenerator dtGen,
            CardRepository dataBase,
            RawCardData cardInString
    ) {
        this.countRecords = countRecords;
        this.dtGen = dtGen;
        this.dataBase = dataBase;
        this.cardInString = cardInString;
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

    public List<String> getListCardString() {
        return listCardString;
    }

}
