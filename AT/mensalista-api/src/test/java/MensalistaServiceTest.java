
import com.mensalista.Mensalista;
import com.mensalista.MensalistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MensalistaServiceTest {
    private MensalistaService service;

    @BeforeEach
    void setUp() {
        service = new MensalistaService();
    }

    @Test
    void testListarTodos() {
        List<Mensalista> resultado = service.listarTodos();
        assertNotNull(resultado);
        assertTrue(resultado.size() >= 2); // Pelo menos os dados iniciais
    }

    @Test
    void testBuscarPorMatriculaExistente() {
        Mensalista resultado = service.buscarPorMatricula("2023001");
        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getNome());
    }

    @Test
    void testBuscarPorMatriculaInexistente() {
        Mensalista resultado = service.buscarPorMatricula("999999");
        assertNull(resultado);
    }

    @Test
    void testCriarMensalista() {
        Mensalista novo = new Mensalista("2023003", "Pedro Oliveira", "Ford Focus", "GHI-9012");

        Mensalista resultado = service.criar(novo);
        assertNotNull(resultado);
        assertEquals("Pedro Oliveira", resultado.getNome());
    }

    @Test
    void testCriarMensalistaMatriculaDuplicada() {
        Mensalista duplicado = new Mensalista("2023001", "Nome Teste", "Carro Teste", "TEST-123");

        assertThrows(IllegalArgumentException.class, () -> {
            service.criar(duplicado);
        });
    }
}