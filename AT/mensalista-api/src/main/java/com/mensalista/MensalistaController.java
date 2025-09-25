package com.mensalista;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MensalistaController {
    private final MensalistaService mensalistaService;
    private final ObjectMapper objectMapper;

    public MensalistaController() {
        this.mensalistaService = new MensalistaService();
        this.objectMapper = new ObjectMapper();
        // Registrar módulo para Java 8 Date/Time
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void listarTodos(Context ctx) {
        try {
            ctx.json(mensalistaService.listarTodos());
        } catch (Exception e) {
            e.printStackTrace(); // Para debug
            ctx.status(500).result("Erro interno do servidor: " + e.getMessage());
        }
    }

    public void buscarPorMatricula(Context ctx) {
        try {
            String matricula = ctx.pathParam("matricula");
            Mensalista mensalista = mensalistaService.buscarPorMatricula(matricula);

            if (mensalista == null) {
                throw new NotFoundResponse("Mensalista não encontrado");
            }

            ctx.json(mensalista);
        } catch (NotFoundResponse e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace(); // Para debug
            ctx.status(500).result("Erro interno do servidor: " + e.getMessage());
        }
    }

    public void criar(Context ctx) {
        try {
            // Usar o ObjectMapper customizado para desserializar
            Mensalista mensalista = objectMapper.readValue(ctx.body(), Mensalista.class);

            // Validação dos dados de entrada
            validarMensalista(mensalista);

            Mensalista novoMensalista = mensalistaService.criar(mensalista);
            ctx.status(201).json(novoMensalista);
        } catch (IllegalArgumentException e) {
            throw new BadRequestResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Para debug
            ctx.status(500).result("Erro interno do servidor: " + e.getMessage());
        }
    }

    private void validarMensalista(Mensalista mensalista) {
        if (mensalista.getMatricula() == null || mensalista.getMatricula().trim().isEmpty()) {
            throw new IllegalArgumentException("Matrícula é obrigatória");
        }
        if (mensalista.getNome() == null || mensalista.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (mensalista.getPlaca() == null || mensalista.getPlaca().trim().isEmpty()) {
            throw new IllegalArgumentException("Placa do veículo é obrigatória");
        }
        if (mensalista.getVeiculo() == null || mensalista.getVeiculo().trim().isEmpty()) {
            throw new IllegalArgumentException("Veículo é obrigatório");
        }

        // Validar formato da placa (exemplo simples)
        if (!mensalista.getPlaca().matches("[A-Z]{3}-\\d{4}")) {
            throw new IllegalArgumentException("Placa deve estar no formato AAA-1234");
        }
    }
}