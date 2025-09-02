
import org.example.IPlanoDeSaude;
import org.example.ServicoConsulta;
import org.example.StubPlano50;
import org.example.StubPlano80;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoConsultaTest {

    @Test
    public void testePlano50() {
        ServicoConsulta servico = new ServicoConsulta();
        IPlanoDeSaude plano50 = new StubPlano50();

        double valorFinal = servico.calcularValorFinal(200.0, plano50);
        assertEquals(100.0, valorFinal, 0.01); // 200 - (200*0.5)
    }

    @Test
    public void testePlano80() {
        ServicoConsulta servico = new ServicoConsulta();
        IPlanoDeSaude plano80 = new StubPlano80();

        double valorFinal = servico.calcularValorFinal(200.0, plano80);
        assertEquals(40.0, valorFinal, 0.01); // 200 - (200*0.8)
    }

    @Test
    public void testePlanoDinamico() {
        ServicoConsulta servico = new ServicoConsulta();
        IPlanoDeSaude plano70 = new IPlanoDeSaude() {
            @Override
            public double getPercentualCobertura() {
                return 0.70;
            }
        };

        double valorFinal = servico.calcularValorFinal(100.0, plano70);
        assertEquals(30.0, valorFinal, 0.01); // 100 - (100*0.7)
    }
}
