package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        final String API_KEY = "07eb6e0402mshc4e644537e597bep1f09fajsnc1ab8c07656f";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20Ball/"))
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        JSONArray resultsArray = json.getJSONArray("results");

        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject result = resultsArray.getJSONObject(i);
            String titulo = result.getString("title");
            System.out.println(titulo);
        }
    }
}