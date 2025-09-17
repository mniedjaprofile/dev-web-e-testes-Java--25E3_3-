package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SimpleApiFullFlow {

    public static void main(String[] args) {
        try {
            System.out.println("=== GET TODOS OS ITENS ===");
            String allItems = doGet("https://apichallenges.eviltester.com/simpleapi/items");
            System.out.println(allItems);

            System.out.println("\n=== GET ISBN ALEATÓRIO ===");
            String isbn = doGet("https://apichallenges.eviltester.com/simpleapi/randomisbn");
            isbn = isbn.replaceAll("\"", ""); // remover aspas se houver
            System.out.println("ISBN gerado: " + isbn);

            System.out.println("\n=== POST CRIAR ITEM ===");
            String postJson = String.format("""
                    {
                      "type": "book",
                      "isbn13": "%s",
                      "price": 5.99,
                      "numberinstock": 5
                    }
                    """, isbn);
            String postResponse = doPost("https://apichallenges.eviltester.com/simpleapi/items", postJson);
            System.out.println(postResponse);

            System.out.println("\n=== PUT ATUALIZAR ITEM ===");
            String putJson = String.format("""
                    {
                      "type": "book",
                      "isbn13": "%s",
                      "price": 9.99,
                      "numberinstock": 10
                    }
                    """, isbn);
            try {
                String putResponse = doPut("https://apichallenges.eviltester.com/simpleapi/items", putJson);
                System.out.println(putResponse);
            } catch (UnsupportedOperationException e) {
                System.out.println("PUT não suportado neste endpoint. Pulando atualização via PUT.");
            }

            System.out.println("\n=== DELETE ITEM ===");
            String deleteResponse = doDelete("https://apichallenges.eviltester.com/simpleapi/items/" + isbn);
            System.out.println(deleteResponse);

        } catch (IOException e) {
            System.err.println("Erro na execução do fluxo: " + e.getMessage());
        }
    }

    // ==================== MÉTODOS AUXILIARES ====================
    private static String doGet(String urlStr) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod("GET");
        int status = conn.getResponseCode();
        System.out.println("GET Status: " + status);
        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    private static String doPost(String urlStr, String jsonInput) throws IOException {
        return doWrite(urlStr, jsonInput, "POST");
    }

    private static String doPut(String urlStr, String jsonInput) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int status = conn.getResponseCode();
        System.out.println("PUT Status: " + status);

        if (status == 405 || status == 403) {
            conn.disconnect();
            throw new UnsupportedOperationException("Método PUT não permitido (Status: " + status + ")");
        }

        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    private static String doDelete(String urlStr) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod("DELETE");
        int status = conn.getResponseCode();
        System.out.println("DELETE Status: " + status);
        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    private static String doWrite(String urlStr, String jsonInput, String method) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        int status = conn.getResponseCode();
        System.out.println(method + " Status: " + status);
        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    private static String readResponse(HttpURLConnection conn) throws IOException {
        InputStream stream;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
            stream = conn.getInputStream();
        } else if (conn.getErrorStream() != null) {
            stream = conn.getErrorStream();
        } else {
            return "Sem corpo de resposta";
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        return response.toString();
    }
}
