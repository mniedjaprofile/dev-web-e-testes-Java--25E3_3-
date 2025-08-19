import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScientificCalculatorTest4 {
    private ScientificCalculator calculator; // variável de instância compartilhada

    // Setup (executa ANTES de cada teste)
    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
        System.out.println("Instanciando nova calculadora...");
    }

    @Test
    void testAddition() {
        double result = calculator.add(2.0, 3.0);
        assertEquals(5.0, result);
    }

    @Test
    void testSubtraction() {
        double result = calculator.subtract(10.0, 4.0);
        assertEquals(6.0, result);
    }
}
