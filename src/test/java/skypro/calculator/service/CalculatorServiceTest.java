package skypro.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.*;

@DisplayName("тест CalculatorService")
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService service;

    @BeforeEach
    public void setUp() {
        this.service = new CalculatorServiceImp();
    }

    @Test
    @DisplayName("проверка приветствия")
    public void testStartMethod() {
        String actual = "Добро пожаловать в калькулятор";
        String expected = service.startMethod();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("testParams")
    @DisplayName("тест сложения")
    public void testPlusMethod(int inputOne, int inputTwo) {
        int expected = service.plusMethod(inputOne, inputTwo);
        assertEquals(expected, 6);
    }

    @ParameterizedTest
    @MethodSource("testParams")
    @DisplayName("тест разности")
    public void testMinusMethod(int inputOne, int inputTwo) {
        int expected = service.minusMethod(inputOne, inputTwo);
        assertEquals(expected, 2);
    }

    @ParameterizedTest
    @MethodSource("testParams")
    @DisplayName("тест умножения")
    public void testMultiplyMethod(int inputOne, int inputTwo) {
        int expected = service.multiplyMethod(inputOne, inputTwo);
        assertEquals(expected, 8);
    }

    @ParameterizedTest
    @MethodSource("testParams")
    @DisplayName("тест деления")
    public void testDivideMethod(int inputOne, int inputTwo) {
        double expected = service.divideMethod(inputOne, inputTwo);
        assertEquals(expected, 2);
    }

    @ParameterizedTest
    @MethodSource("testParams")
    @DisplayName("тест деления на ноль")
    public void testDivideMethodByZero(int inputOne, int inputTwo) {
        int two = 0;
        assertThrows(IllegalArgumentException.class, () -> service.divideMethod(inputOne, two));
    }


    public static Stream<Arguments> testParams() {
        return Stream.of(
                of(4, 2)
        );
    }
}