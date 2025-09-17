import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {

            String categoria = URLEncoder.encode("teste", StandardCharsets.UTF_8);
            String limite = URLEncoder.encode("5", StandardCharsets.UTF_8);


            String urlString = "https://apichallenges.eviltester.com/sim/entities"
                    + "?categoria=" + categoria
                    + "&limite=" + limite;

            System.out.println("URL final montada: " + urlString);

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status HTTP: " + statusCode);

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
