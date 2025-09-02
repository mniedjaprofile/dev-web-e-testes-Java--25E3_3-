import org.example.ComparadorNumerico;
import org.example.Consulta;
import org.example.PlanoSaude;
import org.example.ServicoReembolso;

public class ServicoReembolsoTeste {
    public static void main(String[] args) {
        PlanoSaude plano50 = () -> 0.5; // 50% de cobertura
        Consulta consulta = new Consulta(200.0);
        ServicoReembolso servico = new ServicoReembolso(plano50);

        double resultado = servico.calcular(consulta);
        assert ComparadorNumerico.saoIguais(100.0, resultado) : "Reembolso deveria ser 100.0";

        System.out.println("ServicoReembolsoTest passou!");
    }
}

