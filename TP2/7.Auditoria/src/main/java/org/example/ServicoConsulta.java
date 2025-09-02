package org.example;

public class ServicoConsulta {

    private final IAuditoria auditoria;

    public ServicoConsulta(IAuditoria auditoria) {
        this.auditoria = auditoria;
    }

    public void registrarConsulta(String descricao) {
        auditoria.registrarConsulta(descricao);
    }
}
