package org.example;

public class ServicoReembolso {
    private PlanoSaude plano;

    public ServicoReembolso(PlanoSaude plano) {
        this.plano = plano;
    }

    public double calcular(Consulta consulta) {
        return consulta.getValor() * plano.getPercentualCobertura();
    }
}
