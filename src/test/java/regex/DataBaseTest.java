package regex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    DataBase dataBase = new DataBase();
    Card card1 = new Card(1111222233334444l, "Ivan","Ivanov", 123,01,25);
    Card card2 = new Card(2222333344445555l, "Petr","Petrov", 345,05,26);
    Card card3 = new Card(3333444455556666l, "Sidor","Sidorov", 333,10,26);

    @BeforeEach
    public void init() {
        dataBase.add(card1);
        dataBase.add(card2);
        dataBase.add(card3);
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assertions.assertEquals(3,dataBase.size(),"Check Size");
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Assertions.assertFalse(false);
    }

    @org.junit.jupiter.api.Test
    void add() {
        dataBase.add(new Card(3333444455557777l, "Ss","Ss", 333,10,26));
        Assertions.assertEquals(4,dataBase.size(),"Check Add");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        dataBase.remove(card3);
        Assertions.assertEquals(2,dataBase.size(),"Check remove");
    }
    @org.junit.jupiter.api.Test
    void removeException() {
        assertThrows(NoSuchElementException.class, ()-> dataBase.remove(new Card(3333444455557777l, "Ss","Ss", 333,10,26)), "Removing with exception");
    }


    @org.junit.jupiter.api.Test
    void clear() {
        dataBase.clear();
        Assertions.assertEquals(0,dataBase.size(),"Check clear");
    }

    @org.junit.jupiter.api.Test
    void getDataBaseCard() {
    }

    @AfterEach
    public void destroy() {
        dataBase.clear();
    }
}