package com.mensalista.api.controller;

import com.mensalista.api.model.Mensalista;
import com.mensalista.api.service.MensalistaService;
import io.javalin.Javalin;

public class MensalistaController {
    private final MensalistaService service;

    public MensalistaController(MensalistaService service) {
        this.service = service;
    }

    public void registerRoutes(Javalin app) {
        // Criar Mensalista (POST)
        app.post("/mensalistas", ctx -> {
            Mensalista m = ctx.bodyAsClass(Mensalista.class);
            ctx.json(service.criar(m));
        });

        // Listar Mensalistas (GET)
        app.get("/mensalistas", ctx -> ctx.json(service.listar()));

        // Buscar Mensalista por matrícula (GET)
        app.get("/mensalistas/{matricula}", ctx -> {
            String matricula = ctx.pathParam("matricula");
            Mensalista m = service.buscarPorMatricula(matricula);
            if (m != null) {
                ctx.json(m);
            } else {
                ctx.status(404).result("Mensalista não encontrado");
            }
        });
    }
}
