package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String url = "https://apichallenges.eviltester.com/sim/entities/13"; // ID inexistente
        realizarGet(url);
    }

    private static void realizarGet(String url) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode == 404) {
                System.out.println("Código de Status HTTP: " + statusCode);
                System.out.println("A entidade não foi encontrada (404). Verifique o ID informado.");
                return;
            }

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

            System.out.println("Resposta do Servidor:");
            System.out.println(response.toString());

        } catch (IOException e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }
}