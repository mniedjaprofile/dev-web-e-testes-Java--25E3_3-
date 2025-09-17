package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteEntity {

    public static void main(String[] args) throws IOException {
        String deleteUrl = "https://apichallenges.eviltester.com/sim/entities/9";

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

        URL getUrl = new URL(deleteUrl);
        HttpURLConnection getConn = (HttpURLConnection) getUrl.openConnection();
        getConn.setRequestMethod("GET");

        int getStatus = getConn.getResponseCode();
        System.out.println("GET Status (após DELETE): " + getStatus);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                (getStatus >= 200 && getStatus < 300) ? getConn.getInputStream() : getConn.getErrorStream()))) {

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println("GET Response (após DELETE): " + content);
        }
        getConn.disconnect();
    }
}
