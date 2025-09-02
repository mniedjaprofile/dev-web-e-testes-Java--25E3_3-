import org.example.ComparadorNumerico;

public class ComparadorNumericoTeste {
    public static void main(String[] args) {
        assert ComparadorNumerico.saoIguais(10.0, 10.005) : "Deveria ser considerado igual";
        assert !ComparadorNumerico.saoIguais(10.0, 10.02) : "Não deveria ser considerado igual";

        System.out.println("ComparadorNumericoTest passou!");
    }
}
