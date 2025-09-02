import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraReembolsoTest {

    @Test
    void deveCalcularReembolsoBasico() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Paciente pacienteDummy = new Paciente("Paciente Dummy");

        double resultado = calculadora.calcularReembolso(200, 70, pacienteDummy);

        assertEquals(140, resultado, 0.001);
    }
}
