package com.mensalista.api.service;

import com.mensalista.api.model.Mensalista;
import java.util.*;

public class MensalistaService {
    private final Map<String, Mensalista> mensalistas = new HashMap<>();

    public Mensalista criar(Mensalista m) {
        mensalistas.put(m.getMatricula(), m);
        return m;
    }

    public Collection<Mensalista> listar() {
        return mensalistas.values();
    }

    public Mensalista buscarPorMatricula(String matricula) {
        return mensalistas.get(matricula);
    }
}
