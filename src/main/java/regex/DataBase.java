package regex;

import regex.exceptions.NoSuchElement;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<Card> dataBaseCard;

    public DataBase() {
        this.dataBaseCard = new ArrayList<>();
    }
    public int size() {
        return dataBaseCard.size();
    }

    public boolean isEmpty() {
        return dataBaseCard.size() == 0;
    }

    public void add(Card card) {

        dataBaseCard.add(card);

    }

    public void remove(Card card) throws NoSuchElement {
        if (!dataBaseCard.contains(card)) {
            throw new NoSuchElement("There no such element");
        }
        dataBaseCard.remove(card);
    }

    public void clear() {
        dataBaseCard.clear();
    }

    public List<Card> getDataBaseCard() {
        return dataBaseCard;
    }
}
