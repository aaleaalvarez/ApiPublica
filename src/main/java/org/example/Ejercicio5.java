package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio5 {
    //Uso la consulta retrievegetMovieIdByTitle para sacar el id de la pelicula
    //Uso la consulta listgetCastByMovieIds para sacar el id del actor que hace de Goku
    //Uso la consulta retrievegetActorDetailsById para sacar el año de nacimiento
    //Uso la consulta retrievegetMoviesByYear para sacar las peliculas de ese año
    public static void main(String[] args) throws IOException, InterruptedException {
        final String API_KEY = "07eb6e0402mshc4e644537e597bep1f09fajsnc1ab8c07656f";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/movie/byYear/1982/"))
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
