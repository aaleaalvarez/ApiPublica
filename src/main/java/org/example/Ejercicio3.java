package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio3 {
    //Uso la consulta retrievegetSeriesByStartYear para sacar el id de la serie de Dragon Ball
    //Uso la consulta retrievegetEpisodeBySeasonNumAndEpNum para sacar el titulo y la descripcion
    public static void main(String[] args) throws IOException, InterruptedException {
        final String API_KEY = "07eb6e0402mshc4e644537e597bep1f09fajsnc1ab8c07656f";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/season/3/episode/1/"))
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        String titulo = json.getJSONObject("results").getString("title");
        String descripcion = json.getJSONObject("results").getString("description");

        System.out.println(titulo);
        System.out.println(descripcion);
    }
}
