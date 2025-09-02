package org.example;

public class AuditoriaSpy implements IAuditoria {
    private boolean metodoChamado = false;
    private String ultimaDescricao = null;

    @Override
    public void registrarConsulta(String descricao) {
        this.metodoChamado = true;
        this.ultimaDescricao = descricao;
    }

    public boolean isMetodoChamado() {
        return metodoChamado;
    }

    public String getUltimaDescricao() {
        return ultimaDescricao;
    }
}
