package regex;

import lombok.Getter;

@Getter
public class CardInString {

    public String setCardInString(Card card) {
        String month = (card.getMonth()/10==1) ? String.valueOf(card.getMonth()) : "0" + card.getMonth();
        return card.getAccount() +
                card.getFirstName() +
                "_" +
                card.getLastName() +
                card.getCvv() +
                month +
                card.getYear() +
                "\n";
    }
}
