package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio2 {
    //Uso la consulta retrievegetSeriesByStartYear para mostrar todas las series que comenzaron en 1995
    //Uso la consulta retrievegetSeriesByImdbId para sacar la URL del banner de la serie de Dragon Ball
    public static void main(String[] args) throws IOException, InterruptedException {
        final String API_KEY = "07eb6e0402mshc4e644537e597bep1f09fajsnc1ab8c07656f";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/"))
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        String banner = json.getJSONObject("results").getString("banner");

        System.out.print(banner);
    }
}
