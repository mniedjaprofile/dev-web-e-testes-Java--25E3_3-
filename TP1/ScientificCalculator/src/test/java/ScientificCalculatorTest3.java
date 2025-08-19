import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest3 {

    @Test
    void testSubtraction() {
        // Setup: preparar os objetos/variáveis necessários
        ScientificCalculator calculator = new ScientificCalculator();
        double a = 10.0;
        double b = 4.0;

        // Execution: executar o método a ser testado
        double result = calculator.subtract(a, b);

        // Assertion: verificar se o resultado é o esperado
        assertEquals(6.0, result);

        // Teardown: (não aplicável aqui, pois não há recursos externos como arquivos ou conexões)
        // Se houvesse, seria o momento de liberar ou fechar esses recursos
    }
}
