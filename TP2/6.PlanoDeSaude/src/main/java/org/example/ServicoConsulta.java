package org.example;

public class ServicoConsulta {
    public double calcularValorFinal(double valorConsulta, IPlanoDeSaude plano) {
        double desconto = valorConsulta * plano.getPercentualCobertura();
        return valorConsulta - desconto;
    }
}
