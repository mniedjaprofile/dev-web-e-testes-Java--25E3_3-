package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class OptionsRequest {

    public static void main(String[] args) {
        String optionsUrl = "https://apichallenges.eviltester.com/sim/entities";

        try {
            URL url = new URL(optionsUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("OPTIONS");

            int status = conn.getResponseCode();
            System.out.println("OPTIONS Status: " + status);

            Map<String, List<String>> headers = conn.getHeaderFields();

            // Verificar o cabeçalho Allow
            if (headers.containsKey("Allow")) {
                System.out.println("Métodos permitidos: " + headers.get("Allow"));
            } else {
                System.out.println("Cabeçalho 'Allow' não encontrado.");
            }

            conn.disconnect();

        } catch (IOException e) {
            System.out.println("Erro na requisição OPTIONS: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
