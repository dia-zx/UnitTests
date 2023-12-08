import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lesson6.visual.Visual;

public class VisualTest {
    private String out_str;


    @Test
    @DisplayName("Visual.print() контроль вывода в консоль")
    public void printTest() {
        assertEquals("Hello \n word", TestTools.ioListen(() -> Visual.print("Hello \n word"), "").trim());
    }

    @Test
    @DisplayName("Visual.userInputDataList() контроль соответствия ввода/вывода")
    public void userInputDataListTest() {
        String out = TestTools.ioListen(
                () ->  out_str = (new Visual()).userInputDataList(),
                "5 4 3.5 2 1").trim();

        assertEquals("Вводите значения чисел списка через <пробел>", out);
        assertEquals("5 4 3.5 2 1", out_str);
    }

}
