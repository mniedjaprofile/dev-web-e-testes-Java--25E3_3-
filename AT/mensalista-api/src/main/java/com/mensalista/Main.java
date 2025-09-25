package com.mensalista;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.json.JavalinJackson;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Configurar ObjectMapper com suporte a Java 8 Date/Time
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();

        MensalistaController mensalistaController = new MensalistaController();

        Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost();
                });
            });
            // Configurar Javalin para usar o ObjectMapper customizado
            config.jsonMapper(new JavalinJackson(objectMapper));
        }).start(7000);

        // Endpoint da Rubrica 1 - Status
        app.get("/status", Main::status);

        // Endpoints da Rubrica 4 - Mensalistas
        app.get("/mensalistas", mensalistaController::listarTodos);
        app.get("/mensalistas/{matricula}", mensalistaController::buscarPorMatricula);
        app.post("/mensalistas", mensalistaController::criar);

        System.out.println("API rodando na porta 7000");
    }

    private static void status(Context ctx) {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "online");
        status.put("timestamp", LocalDateTime.now().toString());
        status.put("service", "Mensalista API");
        status.put("version", "1.0.0");

        ctx.json(status);
    }
}