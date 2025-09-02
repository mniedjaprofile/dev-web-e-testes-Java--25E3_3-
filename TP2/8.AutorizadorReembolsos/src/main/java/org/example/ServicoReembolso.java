package org.example;
import java.util.Objects;

public class ServicoReembolso {

    private final IAutorizadorReembolso autorizador;

    public ServicoReembolso(IAutorizadorReembolso autorizador) {
        this.autorizador = Objects.requireNonNull(autorizador, "autorizador é obrigatório");
    }

    /**
     * Calcula o valor do reembolso (não o valor final ao paciente).
     * Ex.: consulta 200 e cobertura 50% => reembolso 100.
     */
    public double calcularReembolso(String idConsulta, double valorConsulta, IPlanoDeSaude plano) {
        if (!autorizador.autoriza(idConsulta)) {
            throw new AutorizacaoNegadaException("Reembolso não autorizado para consulta " + idConsulta);
        }
        double cobertura = plano.getPercentualCobertura();
        return valorConsulta * cobertura;
    }
}
