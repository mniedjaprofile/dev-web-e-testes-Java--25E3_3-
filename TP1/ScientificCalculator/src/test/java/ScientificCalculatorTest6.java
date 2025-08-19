import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ScientificCalculatorTest6 {
    @Test
    void testSquareRootNegative() {

        ScientificCalculator calculator = new ScientificCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(-9.0);
        }, "Deve lançar IllegalArgumentException para números negativos");

    }
}
