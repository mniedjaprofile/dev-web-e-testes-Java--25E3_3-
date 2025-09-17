package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        int[] entityIds = {2, 3, 4, 5, 6, 7, 8};

        for (int id : entityIds) {
            String url = "https://apichallenges.eviltester.com/sim/entities/" + id;
            System.out.println("Consultando entidade ID: " + id);
            realizarGet(url);
            System.out.println("--------------------------------------------------");
        }
    }

    private static void realizarGet(String url) {
        try {
            // Criar objeto URL
            URL apiUrl = new URL(url);

            // Abrir conexão
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            // Obter código de status
            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP: " + statusCode);

            // Ler resposta do servidor
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

            // Exibir corpo da resposta
            System.out.println("Resposta do Servidor:");
            System.out.println(response.toString());

        } catch (IOException e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }
}