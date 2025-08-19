import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest2 {
    private final ScientificCalculator calculator = new ScientificCalculator();

    @Test
    void testAddition() {
        // Testa se 2.0 + 3.0 = 5.0
        double result = calculator.add(2.0, 3.0);
        assertEquals(5.0, result);
    }
}
