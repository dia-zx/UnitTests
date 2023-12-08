import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lesson6.model.Model;

public class ModelTest {
    @Test
    @DisplayName("Model.getDataListFromSring() проверка исключений")
    public void getDataListFromSring_ExTest(){
        assertThrows(NumberFormatException.class, () -> Model.getDataListFromSring(""));
        assertThrows(NumberFormatException.class, () -> Model.getDataListFromSring("xcvxcv"));
    }

    @Test
    @DisplayName("Model.getDataListFromSring() проверка корректных значений")
    public void getDataListFromSring_ValidateOnTest(){
        assertArrayEquals(new Double[] {5.0, 6.0, 1.0, -1.5}, Model.getDataListFromSring("5 6 1 -1.5").toArray());
    }    

    @Test
    @DisplayName("Model.calculateMeanList()  проверка исключений")
    public void calculateMeanList_ExTest(){
        assertThrows(IllegalArgumentException.class, () -> Model.calculateMeanList(null));
        assertThrows(IllegalArgumentException.class, () -> Model.calculateMeanList(new ArrayList<Double>()));
    }

    @Test
    @DisplayName("Model.calculateMeanList()  проверка корректных значений")
    public void calculateMeanList_ValidateOnTest(){
        assertEquals(4.0, Model.calculateMeanList(Arrays.asList(5.0, 5.0, 2.0, 4.0)));
    }    

    @Test
    @DisplayName("Model.compareLists()  проверка корректных возможных значений")
    public void compareLists_Test(){
        assertEquals("Второй список имеет большее среднее значение", Model.compareLists(4.0, 5.0));
        assertEquals("Средние значения равны", Model.compareLists(4.0, 4.0));
        assertEquals("Первый список имеет большее среднее значение", Model.compareLists(10.0, 4.0));
    }       

}
