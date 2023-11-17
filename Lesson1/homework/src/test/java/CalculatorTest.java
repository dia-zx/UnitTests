import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import Calculator.Calculator;

public class CalculatorTest {
  private Calculator calculator;
  
  @BeforeEach // метод будет выполняться каждый раз перед каждым тестом
  public void setup(){
      calculator = new Calculator();
  }

  @AfterEach  // метод будет выполняться каждый раз после каждого теста
  public void teardown(){
      calculator = null;
  }

  @Test
  @DisplayName("Проверка вычислений метода calculateDiscount")
  public void tests_calculateDiscount_Calculation(){
    assertEquals(90.0, Calculator.calculatingDiscount(100, 10));
    assertEquals(114.475, Calculator.calculatingDiscount(120.5, 5));
    assertEquals(0.0, Calculator.calculatingDiscount(0.0, 5));
    assertEquals(11.1, Calculator.calculatingDiscount(11.1, 0));
  }

  @Test
  @DisplayName("Проверка на выдачу исключений метода calculateDiscount")
  public void tests_calculateDiscount_Exceptions(){
    assertThrows(ArithmeticException.class, ()-> Calculator.calculatingDiscount(100.0, -5)); // значение скидки не может быть < 0%
    assertThrows(ArithmeticException.class, ()-> Calculator.calculatingDiscount(-100.0, 5)); // значение суммы не может быть < 0
    assertThrows(ArithmeticException.class, ()-> Calculator.calculatingDiscount(100.0, 110)); // значение скидки не может быть > 100%
  }

   
}
