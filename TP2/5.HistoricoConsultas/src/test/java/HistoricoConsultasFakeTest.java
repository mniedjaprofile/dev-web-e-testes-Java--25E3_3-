import org.example.IHistoricoConsultas;
import org.example.HistoricoConsultasFake;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricoConsultasFakeTest {

    @Test
    void deveAdicionarEListarConsultas() {
        IHistoricoConsultas historico = new HistoricoConsultasFake();

        historico.adicionarConsulta("Consulta 01 - 200 reais");
        historico.adicionarConsulta("Consulta 02 - 300 reais");

        assertEquals(2, historico.listarConsultas().size());
        assertEquals("Consulta 01 - 200 reais", historico.listarConsultas().get(0));
    }
}
