public class Paciente {
    private String nome;
    private String cpf;

    public Paciente(String nome) {
        this.nome = nome;
        this.cpf = "";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
