import org.example.AutorizacaoNegadaException;
import org.example.IAutorizadorReembolso;
import org.example.IPlanoDeSaude;
import org.example.ServicoReembolso;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoReembolsoTest {

    @Mock
    IAutorizadorReembolso autorizador;

    @Test
    void deveCalcularReembolsoQuandoAutorizado() {
        // Arrange
        when(autorizador.autoriza("C1")).thenReturn(true);
        ServicoReembolso servico = new ServicoReembolso(autorizador);

        // Plano de 50% (stub simples via lambda porque PlanoSaude é funcional)
        IPlanoDeSaude plano50 = () -> 0.50;

        // Act
        double reembolso = servico.calcularReembolso("C1", 200.0, plano50);

        // Assert
        assertEquals(100.0, reembolso, 0.001); // 50% de 200
        verify(autorizador).autoriza("C1");    // garante que o mock foi chamado
    }

    @Test
    void deveLancarExcecaoQuandoNaoAutorizado() {
        // Arrange
        when(autorizador.autoriza("C2")).thenReturn(false);
        ServicoReembolso servico = new ServicoReembolso(autorizador);
        IPlanoDeSaude plano80 = () -> 0.80;

        // Act + Assert
        assertThrows(AutorizacaoNegadaException.class,
                () -> servico.calcularReembolso("C2", 200.0, plano80));

        verify(autorizador).autoriza("C2");
        verifyNoMoreInteractions(autorizador);
    }
}
