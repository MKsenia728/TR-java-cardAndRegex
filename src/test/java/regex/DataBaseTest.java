package regex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import regex.exceptions.NoSuchElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
class DataBaseTest {

    DataBase dataBase = new DataBase();

    @BeforeEach
    public void init() {
        Card card1 = Mockito.mock(Card.class);
        Card card2 = Mockito.mock(Card.class);
        Card card3 = Mockito.mock(Card.class);

        dataBase.add(card1);
        dataBase.add(card2);
        dataBase.add(card3);
    }

    @Test
    void sizeTest() {

        Assertions.assertEquals(3,dataBase.size(),"Check Size");
    }

    @Test
    void isEmptyTest() {
        Assertions.assertFalse(false);
    }

    @Test
    void addTest() {
        Card cardTest = Mockito.mock(Card.class);
        dataBase.add(cardTest);
        Assertions.assertEquals(4,dataBase.size(),"Check Add");
    }

    @Test
    void removeTest() throws NoSuchElement {
        Card cardTest1 = Mockito.mock(Card.class);
        Card cardTest2 = Mockito.mock(Card.class);
        dataBase.add(cardTest1);
        dataBase.add(cardTest2);
        dataBase.remove(cardTest1);
        Assertions.assertEquals(4,dataBase.size(),"Check remove");
    }
    @Test
    void removeExceptionTest() {
        Card card = Mockito.mock(Card.class);
        assertThrows(NoSuchElement.class, ()-> dataBase.remove(card), "Removing ");
    }

    @Test
    void clearTest() {
        dataBase.clear();
        Assertions.assertEquals(0,dataBase.size(),"Check clear");
    }

    @Test
    void getDataBaseCardTest() {
        Assertions.assertEquals(3, dataBase.getDataBaseCard().size(), "Check getter");
    }

    @AfterEach
    public void destroy() {
        dataBase.clear();
    }
}