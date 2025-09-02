package org.example;
import java.util.ArrayList;
import java.util.List;

public class HistoricoConsultasFake implements IHistoricoConsultas {

    private List<String> consultas = new ArrayList<>();

    @Override
    public void adicionarConsulta(String consulta) {
        consultas.add(consulta);
    }

    @Override
    public List<String> listarConsultas() {
        return new ArrayList<>(consultas);
    }
}
