package regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)

class ServiceTest {

    Service service = new Service(5);


    @Mock
    DataBase dataBase;
    @Mock
    DataGenerate dataGenerate;
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this);
//    }


    @Test
    void testCreateDataBaseCards() {
        Card card = Mockito.mock(Card.class);
//        int count = 0;

//        Mockito.when(dataBase.add(card)).thenAnswer()
        Mockito.when(dataGenerate.generateAccount()).thenReturn(anyLong());
        Mockito.when(dataGenerate.generateFirstName()).thenReturn(anyString());
        Mockito.when(dataGenerate.generateLastName()).thenReturn(anyString());
        Mockito.when(dataGenerate.generateCVV()).thenReturn(anyInt());
        Mockito.when(dataGenerate.generateMonth()).thenReturn(anyInt());
        Mockito.when(dataGenerate.generateYear()).thenReturn(anyInt());
        Mockito.doNothing().when(dataBase).add(card);
        service.createDataBaseCards();
        Mockito.verify(dataGenerate, Mockito.times(5)).generateAccount();
//        Assertions.assertEquals(5,count);

    }

    @Test
    void createListCardInString() {
    }
}