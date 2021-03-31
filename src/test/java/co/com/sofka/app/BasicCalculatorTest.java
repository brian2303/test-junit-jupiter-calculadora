package co.com.sofka.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing suma 1 + 1 = 2")
    void sum() {

        //Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        //Act
        Long result = basicCalculator.sum(number1,number2);

        //Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subtracts")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1,    0,   1",
            "3,    2,   1",
            "50,  15, 35",
            "18,  3, 15"
    })
    public void severalSubtracts(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.substract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "1,    0,   0",
            "3,    3,   9",
            "50,  3, 150",
            "6,  3, 18"
    })
    public void severalMultiplications(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "10,   2,   5",
            "9,    3,   3",
            "18,   3,   6",
            "21,   0,   No puede dividir en 0"
    })
    public void severalDivisions(Long first, Long second, String expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }


}