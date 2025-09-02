import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraReembolso {
    public BigDecimal calcularReembolso(BigDecimal valorConsulta, double percentualCobertura) {
        return valorConsulta.multiply(BigDecimal.valueOf(percentualCobertura))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
