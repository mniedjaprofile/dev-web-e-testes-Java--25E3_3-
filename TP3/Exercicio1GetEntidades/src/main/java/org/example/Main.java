package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String url = "https://apichallenges.eviltester.com/sim/entities";

        try {
            // Criar objeto URL
            URL apiUrl = new URL(url);

            // Abrir conexão
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Definir método HTTP
            connection.setRequestMethod("GET");

            // Obter código de status
            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP: " + statusCode);

            // Ler resposta do servidor
            BufferedReader reader;
            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                // Se não for sucesso, ler do erro
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Exibir corpo da resposta
            System.out.println("Resposta do Servidor:");
            System.out.println(response.toString());

            // Fechar conexão
            connection.disconnect();

        } catch (IOException e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }
}