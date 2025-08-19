import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScientificCalculatorTest {
    private ScientificCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
    }

    // ===============================
    // Testes de operações básicas
    // ===============================
    @Test
    void shouldReturnSumWhenAddingTwoNumbers() {
        assertEquals(5.0, calculator.add(2, 3), 1e-9);
    }

    @Test
    void shouldReturnDifferenceWhenSubtractingTwoNumbers() {
        assertEquals(1.0, calculator.subtract(3, 2), 1e-9);
    }

    @Test
    void shouldReturnProductWhenMultiplyingTwoNumbers() {
        assertEquals(6.0, calculator.multiply(2, 3), 1e-9);
    }

    @Test
    void shouldReturnQuotientWhenDividingTwoNumbers() {
        assertEquals(2.0, calculator.divide(6, 3), 1e-9);
    }

    // ===============================
    // Testes de exceção
    // ===============================
    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }

    @Test
    void shouldThrowExceptionWhenTakingSquareRootOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-4));
    }

    @Test
    void shouldThrowExceptionWhenTakingLogOfNonPositiveNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.log(0));
        assertThrows(IllegalArgumentException.class, () -> calculator.log(-2));
    }

    // ===============================
    // Testes de funções especiais
    // ===============================
    @Test
    void shouldReturnSquareRootWhenNumberIsPositive() {
        assertEquals(3.0, calculator.squareRoot(9), 1e-9);
    }

    @Test
    void shouldReturnExponentiationResultWhenRaisingBaseToExponent() {
        assertEquals(8.0, calculator.power(2, 3), 1e-9);
    }

    @Test
    void shouldReturnNaturalLogWhenNumberIsPositive() {
        assertEquals(Math.log(2), calculator.log(2), 1e-9);
    }

    // ===============================
    // Testes de funções trigonométricas
    // ===============================
    @Test
    void shouldReturnAccurateSineForCommonPositiveAngles() {
        assertEquals(0.0, calculator.sin(0), 1e-9);
        assertEquals(0.5, calculator.sin(30), 1e-9);
        assertEquals(1.0, calculator.sin(90), 1e-9);
    }

    @Test
    void shouldReturnAccurateCosineForCommonPositiveAngles() {
        assertEquals(1.0, calculator.cos(0), 1e-9);
        assertEquals(Math.sqrt(3)/2, calculator.cos(30), 1e-9);
        assertEquals(0.0, calculator.cos(90), 1e-9);
    }
}
