import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testLogPositiveValues {
     @Test
        void testLogPositiveValues() {

            double[] valores = {1.0, Math.E, 10.0};
            double[] resultadosEsperados = {0.0, 1.0, Math.log(10.0)};


            for (int i = 0; i < valores.length; i++) {
                double resultado = Math.log(valores[i]);
                assertEquals(resultadosEsperados[i], resultado, 1e-9,
                        "O logaritmo natural de " + valores[i] + " está incorreto");
            }
        }

        @Test
        void testSinPositiveValues() {
            // Setup
            double[] valores = {0.0, Math.PI / 6, Math.PI / 2}; // 0°, 30°, 90°
            double[] resultadosEsperados = {0.0, 0.5, 1.0};

            // Execution & Assertion
            for (int i = 0; i < valores.length; i++) {
                double resultado = Math.sin(valores[i]);
                assertEquals(resultadosEsperados[i], resultado, 1e-9,
                        "O seno de " + valores[i] + " radianos está incorreto");
            }
        }
}