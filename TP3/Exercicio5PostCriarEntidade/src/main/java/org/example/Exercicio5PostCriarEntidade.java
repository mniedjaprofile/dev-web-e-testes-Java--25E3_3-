import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio5PostCriarEntidade {

    public static void main(String[] args) {
        String url = "https://apichallenges.eviltester.com/sim/entities";
        String jsonInput = "{\"name\": \"aluno\"}";

        try {
            // Criar objeto URL
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configurar conexão
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true); // habilita envio no corpo da requisição

            // Enviar JSON
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(jsonInput);
                wr.flush();
            }

            // Obter código de status
            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP: " + statusCode);

            // Ler resposta
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

            // Buscar ID gerado (geralmente 11)
            if (response.toString().contains("\"id\"")) {
                System.out.println("➡ ID da entidade criada: " +
                        response.toString().replaceAll(".*\"id\":\\s*(\\d+).*", "$1"));
            }

        } catch (IOException e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }
}
