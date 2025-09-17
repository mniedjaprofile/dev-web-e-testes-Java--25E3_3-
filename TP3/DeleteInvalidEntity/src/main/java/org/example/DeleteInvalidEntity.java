package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteInvalidEntity {

    public static void main(String[] args) {
        String deleteUrl = "https://apichallenges.eviltester.com/sim/entities/2";

        try {

            URL url = new URL(deleteUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int status = conn.getResponseCode();
            System.out.println("DELETE Status: " + status);


            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream()))) {

                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println("DELETE Response: " + content);
            }

            conn.disconnect();

        } catch (IOException e) {
            System.out.println("Erro ao executar requisição: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
