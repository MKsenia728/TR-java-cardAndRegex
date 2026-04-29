package regex;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CardServiceTest {

    @Test
    void testCreateDataBaseCards() {
        CardRepository dataBase = Mockito.mock(CardRepository.class);
        CardDataGenerator dataGenerate = Mockito.mock(CardDataGenerator.class);
        RawCardData rawCardData = Mockito.mock(RawCardData.class);

        CardService service = new CardService(5, dataGenerate, dataBase, rawCardData);

        Mockito.when(dataGenerate.generateAccount()).thenReturn(1234567890123456L);
        Mockito.when(dataGenerate.generateFirstName()).thenReturn("John");
        Mockito.when(dataGenerate.generateLastName()).thenReturn("Smith");
        Mockito.when(dataGenerate.generateCVV()).thenReturn(123);
        Mockito.when(dataGenerate.generateMonth()).thenReturn(12);
        Mockito.when(dataGenerate.generateYear()).thenReturn(2027);

        service.createDataBaseCards();

        Mockito.verify(dataBase, Mockito.times(5)).add(Mockito.any(Card.class));
    }

}