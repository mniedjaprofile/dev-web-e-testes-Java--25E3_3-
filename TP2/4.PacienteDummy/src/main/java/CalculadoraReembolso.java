public class CalculadoraReembolso {

    public double calcularReembolso(double valorConsulta, double percentualCobertura, Paciente paciente) {
        return valorConsulta * (percentualCobertura / 100);
    }
}
