package com.empresa.folha.model;

public class Mensagem {
    private String mensagem;

    public Mensagem() {} // necessário para JSON

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}