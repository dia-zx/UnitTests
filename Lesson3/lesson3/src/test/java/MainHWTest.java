import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import homework.MainHW;

public class MainHWTest {
    private MainHW mainHW;

    @BeforeEach // метод будет выполняться каждый раз перед каждым тестом
    public void setup() {
        mainHW = new MainHW(); // создадим экземпляр класса mainHW методы которого будем тестировать
    }

    @AfterEach // метод будет выполняться каждый раз после каждого теста
    public void teardown() {
        mainHW = null; // убираем указатель с экземпляра класса mainHW
    }

    /**
     * Тестируем метод MainHW.evenOddNumber(int) на нечетные числа (должен
     * возвратить false)
     * 
     * @param number нечетное число
     */
    @Test
    @DisplayName("проверка метода evenOddNumber(int) на нечетные числа")
    @ParameterizedTest
    @ValueSource(ints = { 1, 3, -1, -77, 99, 0x6FFF_FFFF, 0x7FFF_FFFF })
    void evenOddNumber_OddTest(int number) {
        assertFalse(mainHW.evenOddNumber(number));
    }

    /**
     * Тестируем метод MainHW.evenOddNumber(int) на нечетные числа (должен
     * возвратить true)
     * 
     * @param number нечетное число
     */
    @Test
    @DisplayName("проверка метода evenOddNumber(int) на четные числа")
    @ParameterizedTest
    @ValueSource(ints = { 0, 2, -2, -78, 98, 0x6FFF_FFFA, 0x7FFF_FFF4 })
    void evenOddNumber_EvenTest(int number) {
        assertTrue(mainHW.evenOddNumber(number));
    }

    /**
     * Тестируем метод MainHW.numberInInterval(int) на числа не принадлежащие
     * интервалу (25;100) (должен возвратить false)
     * 
     * @param number число не принадлежащие интервалу (25;100)
     */
    @Test
    @DisplayName("проверка метода numberInInterval(int) на не принадлежность интервалу")
    @ParameterizedTest
    @ValueSource(ints = { 1, 3, -1, 0, 100, 25, 0x6FFF_FFFF, 0x7FFF_FFFF, 0xFFFF_FFFF })
    void numberInInterval_FalseTest(int number) {
        assertFalse(mainHW.numberInInterval(number));
    }

    /**
     * Тестируем метод MainHW.numberInInterval(int) на числа принадлежащие
     * интервалу (25;100) (должен возвратить true)
     * 
     * @param number число принадлежащие интервалу (25;100)
     */
    @Test
    @DisplayName("проверка метода numberInInterval(int) на принадлежность интервалу")
    @ParameterizedTest
    @ValueSource(ints = { 26, 50, 70, 99, 90, 88, 40, 30, 33 })
    void numberInInterval_TrueTest(int number) {
        assertTrue(mainHW.numberInInterval(number));
    }
}
