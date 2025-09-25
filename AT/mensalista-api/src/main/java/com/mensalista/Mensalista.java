package com.mensalista;
import java.time.LocalDateTime;

public class Mensalista {
    private String matricula;
    private String nome;
    private String veiculo;
    private String placa;
    private LocalDateTime dataCadastro;
    private boolean ativo;

    public Mensalista() {}

    public Mensalista(String matricula, String nome, String veiculo, String placa) {
        this.matricula = matricula;
        this.nome = nome;
        this.veiculo = veiculo;
        this.placa = placa;
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }

    // Getters e Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getVeiculo() { return veiculo; }
    public void setVeiculo(String veiculo) { this.veiculo = veiculo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}