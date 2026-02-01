package br.com.loggest.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCEPService {
    public static String buscarCep(String cep) throws Exception {
        String urlString = "https://viacep.com.br/ws/" + cep.replaceAll("[^0-9]", "") + "/json/";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Falha na requisição. Código: " + responseCode);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }

    }
}
