package regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RawCardDataTest {
    RawCardData cardInString = new RawCardData();
    Card card = new Card(1111222233334444l, "Ivan","Ivanov", 123,1,25);
    String expectedCardString = "1111222233334444Ivan_Ivanov1230125\n";
    @Test
    void transCardToStringTest() {
        Assertions.assertEquals(expectedCardString, cardInString.transCardToString(card), "Checking translate card to string");
    }
}