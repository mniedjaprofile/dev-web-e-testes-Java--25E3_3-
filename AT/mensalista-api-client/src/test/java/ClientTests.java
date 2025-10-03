import com.mensalista.BuscarMensalistaClient;
import com.mensalista.CriarMensalistaClient;
import com.mensalista.ListarMensalistasClient;
import com.mensalista.StatusClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTests {

    @Test
    void testStatusEndpoint() throws Exception {
        StatusClient client = new StatusClient();
        String response = client.getStatus();
        assertTrue(response.contains("ok"));
    }

    @Test
    void testCriarEListarMensalista() throws Exception {
        CriarMensalistaClient criar = new CriarMensalistaClient();
        String novo = criar.criarMensalista("{\"matricula\":\"001\",\"nome\":\"Maria\",\"salario\":3000.0}");
        assertTrue(novo.contains("Maria"));

        ListarMensalistasClient listar = new ListarMensalistasClient();
        String lista = listar.listar();
        assertTrue(lista.contains("Maria"));
    }

    @Test
    void testBuscarMensalista() throws Exception {
        CriarMensalistaClient criar = new CriarMensalistaClient();
        criar.criarMensalista("{\"matricula\":\"002\",\"nome\":\"Carlos\",\"salario\":4000.0}");

        BuscarMensalistaClient buscar = new BuscarMensalistaClient();
        String resp = buscar.buscarPorMatricula("002");
        assertTrue(resp.contains("Carlos"));
    }
}