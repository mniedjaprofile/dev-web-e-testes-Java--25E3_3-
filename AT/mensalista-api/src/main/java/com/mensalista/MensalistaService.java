package com.mensalista;

import com.mensalista.Mensalista;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MensalistaService {
    private final Map<String, Mensalista> mensalistas = new ConcurrentHashMap<>();

    public MensalistaService() {
        // Dados iniciais para teste
        inicializarDados();
    }

    private void inicializarDados() {
        Mensalista m1 = new Mensalista("2023001", "João Silva", "Toyota Corolla", "ABC-1234");
        Mensalista m2 = new Mensalista("2023002", "Maria Santos", "Honda Civic", "DEF-5678");

        mensalistas.put(m1.getMatricula(), m1);
        mensalistas.put(m2.getMatricula(), m2);
    }

    public List<Mensalista> listarTodos() {
        return new ArrayList<>(mensalistas.values());
    }

    public Mensalista buscarPorMatricula(String matricula) {
        return mensalistas.get(matricula);
    }

    public Mensalista criar(Mensalista mensalista) {
        if (mensalista.getMatricula() == null || mensalista.getMatricula().trim().isEmpty()) {
            throw new IllegalArgumentException("Matrícula é obrigatória");
        }
        if (mensalistas.containsKey(mensalista.getMatricula())) {
            throw new IllegalArgumentException("Mensalista com esta matrícula já existe");
        }

        mensalistas.put(mensalista.getMatricula(), mensalista);
        return mensalista;
    }

    public boolean existeMatricula(String matricula) {
        return mensalistas.containsKey(matricula);
    }
}