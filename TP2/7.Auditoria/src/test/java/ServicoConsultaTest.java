import org.example.AuditoriaSpy;
import org.example.ServicoConsulta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoConsultaTest {
    @Test
    public void deveChamarAuditoriaAoRegistrarConsulta() {

        AuditoriaSpy auditoriaSpy = new AuditoriaSpy();
        ServicoConsulta servico = new ServicoConsulta(auditoriaSpy);

        servico.registrarConsulta("Consulta de rotina");

        // Assert - Validar chamada de auditoria
        assertTrue(auditoriaSpy.isMetodoChamado(),
                "O método registrarConsulta da auditoria deveria ter sido chamado.");
        assertEquals("Consulta de rotina", auditoriaSpy.getUltimaDescricao(),
                "A descrição da consulta registrada está incorreta.");
    }
}
