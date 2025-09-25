package com.empresa.folha.service;

import com.empresa.folha.model.Mensagem;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Service {

    public String hello() {
        return "Hello, Javalin!";
    }

    public Map<String, Object> status() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "ok");

        ZonedDateTime agora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String dataHoraBrasil = agora.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        String horaBrasil = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        response.put("status", "ok");
        response.put("timestamp", dataHoraBrasil);
        response.put("horaBrasil", horaBrasil);

        return response;
    }

    public Mensagem echo(Mensagem mensagem) {
        if (mensagem == null || mensagem.getMensagem() == null) {
            return new Mensagem("Mensagem vazia");
        }
        return mensagem;
    }

    public Mensagem saudacao(String nome) {
        return new Mensagem("Olá, " + nome + "!");
    }
}
