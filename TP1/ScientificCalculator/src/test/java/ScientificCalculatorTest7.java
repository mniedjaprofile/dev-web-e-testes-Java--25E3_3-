import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest7 {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mathUtils.divide(10, 0);
        });

        assertEquals("Divisor não pode ser zero", exception.getMessage());

        System.out.println("Mensagem da exceção: " + exception.getMessage());
    }
}
