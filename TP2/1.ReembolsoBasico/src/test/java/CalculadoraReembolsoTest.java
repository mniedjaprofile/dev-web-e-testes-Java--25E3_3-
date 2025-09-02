import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraReembolsoTest {

    @Test
    void deveCalcularReembolsoBasico() {
        CalculadoraReembolso calc = new CalculadoraReembolso();

        BigDecimal reembolso = calc.calcularReembolso(
                BigDecimal.valueOf(200.00),
                0.70
        );

        assertEquals(new BigDecimal("140.00"), reembolso);
    }
}
