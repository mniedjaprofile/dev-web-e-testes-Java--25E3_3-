import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraReembolsoTest {

    @Test
    void deveCalcularReembolsoBasico() {
        CalculadoraReembolso calc = new CalculadoraReembolso();
        double resultado = calc.calcular(200.0, 70.0);
        assertEquals(140.0, resultado, 0.01);
    }

    @Test
    void deveRetornarZeroQuandoValorConsultaZero() {
        CalculadoraReembolso calc = new CalculadoraReembolso();
        double resultado = calc.calcular(0.0, 70.0);
        assertEquals(0.0, resultado, 0.01);
    }

    @Test
    void deveRetornarZeroQuandoCoberturaZero() {
        CalculadoraReembolso calc = new CalculadoraReembolso();
        double resultado = calc.calcular(200.0, 0.0);
        assertEquals(0.0, resultado, 0.01);
    }

    @Test
    void deveRetornarValorTotalQuandoCobertura100() {
        CalculadoraReembolso calc = new CalculadoraReembolso();
        double resultado = calc.calcular(200.0, 100.0);
        assertEquals(200.0, resultado, 0.01);
    }

    @Test
    void deveLancarExcecaoParaPercentualInvalido() {
        CalculadoraReembolso calc = new CalculadoraReembolso();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcular(200.0, 150.0);
        });
    }
}
