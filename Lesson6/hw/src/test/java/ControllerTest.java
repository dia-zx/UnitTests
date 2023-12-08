import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lesson6.controller.Controller;

public class ControllerTest {

    @Test
    @DisplayName("Controller.Start() контроль на равенство среднего арифметического списков")
    public void userInputDataList_EqualTest() {
        String out = TestTools.ioListen(
                () -> Controller.Start(),
                "1 2 3 5 6" + System.lineSeparator() + "3 1 2 5 6" + System.lineSeparator()).trim();

        assertEquals(
                        "Ввод первого списка чисел (double)"            + System.lineSeparator() +
                        "Вводите значения чисел списка через <пробел>"  + System.lineSeparator() +
                        "*****************************************"     + System.lineSeparator() +
                        "Ввод второго списка чисел (double)"            + System.lineSeparator() +
                        "Вводите значения чисел списка через <пробел>"  + System.lineSeparator() +
                        "Средние значения равны",
                out);
    }
}
