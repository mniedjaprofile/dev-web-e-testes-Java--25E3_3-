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

    // === Casos de borda ===

    @Test
    void deveRetornarZero_quandoValorConsultaZero() {
        CalculadoraReembolso calc = new CalculadoraReembolso();

        BigDecimal reembolso = calc.calcularReembolso(
                BigDecimal.valueOf(0.00),
                0.70
        );

        assertEquals(new BigDecimal("0.00"), reembolso);
    }

    @Test
    void deveRetornarZero_quandoPercentualZero() {
        CalculadoraReembolso calc = new CalculadoraReembolso();

        BigDecimal reembolso = calc.calcularReembolso(
                BigDecimal.valueOf(300.00),
                0.00
        );

        assertEquals(new BigDecimal("0.00"), reembolso);
    }

    @Test
    void deveRetornarValorIntegral_quandoPercentualCem() {
        CalculadoraReembolso calc = new CalculadoraReembolso();

        BigDecimal reembolso = calc.calcularReembolso(
                BigDecimal.valueOf(150.00),
                1.00
        );

        assertEquals(new BigDecimal("150.00"), reembolso);
    }
}
