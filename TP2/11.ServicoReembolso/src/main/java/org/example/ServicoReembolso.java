package org.example;

import PlanoSaude.PlanoSaude;

public class ServicoReembolso {
    private PlanoSaude plano;
    private static final double TETO_REEMBOLSO = 150.0;

    public ServicoReembolso(PlanoSaude plano) {
        this.plano = plano;
    }

    public double calcular(Consulta consulta) {
        double valorCalculado = consulta.getValor() * plano.getPercentualCobertura();
        return Math.min(valorCalculado, TETO_REEMBOLSO);
    }
}
