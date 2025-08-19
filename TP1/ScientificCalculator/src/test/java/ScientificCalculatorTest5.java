import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ScientificCalculatorTest5 {
    @Test
    void testSquareRootPositive() {

        ScientificCalculator calculator = new ScientificCalculator();

        double result = calculator.squareRoot(16.0);

        assertEquals(4.0, result, 0.0001, "A raiz quadrada de 16 deve ser 4");
    }
}
