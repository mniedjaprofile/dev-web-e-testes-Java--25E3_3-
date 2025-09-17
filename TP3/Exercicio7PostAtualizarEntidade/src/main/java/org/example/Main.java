package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        String url = "https://apichallenges.eviltester.com/sim/entities/10";
        String jsonInput = "{\"name\": \"atualizado\"}";

        atualizarEntidade(url, jsonInput);

        verificarEntidade(url);
    }

    private static void atualizarEntidade(String url, String jsonInput) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);


            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(jsonInput);
                wr.flush();
            }

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP (POST): " + statusCode);


            BufferedReader reader;
            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            System.out.println("Resposta do Servidor (POST):");
            System.out.println(response.toString());

        } catch (IOException e) {
            System.err.println("Erro na atualização: " + e.getMessage());
        }
    }

    private static void verificarEntidade(String url) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP (GET): " + statusCode);

            BufferedReader reader;
            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            System.out.println("Resposta do Servidor (GET):");
            System.out.println(response.toString());

            if (response.toString().contains("\"name\":\"atualizado\"")) {
                System.out.println("A entidade foi atualizada com sucesso!");
            } else {
                System.out.println("A entidade não contém o valor esperado.");
            }

        } catch (IOException e) {
            System.err.println("Erro na verificação: " + e.getMessage());
        }
    }
}
