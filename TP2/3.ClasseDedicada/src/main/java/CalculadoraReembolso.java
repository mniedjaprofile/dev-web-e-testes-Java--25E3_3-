public class CalculadoraReembolso {
    public double calcular(double valorConsulta, double percentualCobertura) {
        if (valorConsulta < 0 || percentualCobertura < 0 || percentualCobertura > 100) {
            throw new IllegalArgumentException("Valores inválidos para cálculo de reembolso.");
        }
        return valorConsulta * (percentualCobertura / 100.0);
    }
}
