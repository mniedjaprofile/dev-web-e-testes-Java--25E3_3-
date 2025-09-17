import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio6GetEntidadeCriada {

    public static void main(String[] args) {

        int id = 11;
        String url = "https://apichallenges.eviltester.com/sim/entities/" + id;

        try {

            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

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

            if (response.toString().contains("\"name\":\"aluno\"")) {
                System.out.println("A entidade foi encontrada e possui o nome esperado: aluno");
            } else {
                System.out.println("A entidade retornada não contém o valor esperado para 'name'");
            }

        } catch (IOException e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }
}
