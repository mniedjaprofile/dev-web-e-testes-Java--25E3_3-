package com.mensalista.api.controller;

import com.mensalista.api.model.Mensagem;
import com.mensalista.api.service.Service;
import io.javalin.Javalin;

public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void registerRoutes(Javalin app) {

        // GET /hello
        app.get("/hello", ctx -> ctx.result(service.hello()));

        // GET /status
        app.get("/status", ctx -> ctx.json(service.status()));

        // POST /echo
        app.post("/echo", ctx -> {
            try {
                Mensagem msg = ctx.bodyAsClass(Mensagem.class);
                ctx.json(service.echo(msg));
            } catch (Exception e) {
                ctx.status(400).json(new Mensagem("Erro: JSON inválido"));
            }
        });

        // GET /saudacao/{nome}
        app.get("/saudacao/{nome}", ctx -> {
            String nome = ctx.pathParam("nome");
            ctx.json(service.saudacao(nome));
        });
    }
}