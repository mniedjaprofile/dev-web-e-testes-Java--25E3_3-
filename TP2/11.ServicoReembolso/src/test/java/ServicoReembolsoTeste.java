import PlanoSaude.PlanoSaude;
import org.example.Consulta;
import org.example.ServicoReembolso;

public class ServicoReembolsoTeste

class ServicoReembolsoTest {
    public static void main(String[] args) {
        // Plano cobre 100% → deveria reembolsar 200, mas teto é 150
        PlanoSaude plano100 = () -> 1.0;
        Consulta consulta200 = new Consulta(200.0);
        ServicoReembolso servico100 = new ServicoReembolso(plano100);

        double resultado1 = servico100.calcular(consulta200);
        assert ComparadorNumerico.saoIguais(150.0, resultado1)
                : "Reembolso deveria ser limitado a 150.0";

        // Plano cobre 50% de 200 → 100, que está dentro do teto
        PlanoSaude plano50 = () -> 0.5;
        ServicoReembolso servico50 = new ServicoReembolso(plano50);

        double resultado2 = servico50.calcular(consulta200);
        assert ComparadorNumerico.saoIguais(100.0, resultado2)
                : "Reembolso deveria ser 100.0";

        System.out.println("Testes de teto passaram!");
    }
}
