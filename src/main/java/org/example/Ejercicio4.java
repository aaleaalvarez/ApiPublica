package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio4 {
    //Uso la consulta retrievegetMovieIdByTitle para sacar el id de la pelicula
    //Uso la consulta listgetCastByMovieIds para sacar el id del actor que hace de Goku
    //Uso la consulta retrievegetActorDetailsById para sacar el lugar de nacimiento y zodiaco
    public static void main(String[] args) throws IOException, InterruptedException {
        final String API_KEY = "07eb6e0402mshc4e644537e597bep1f09fajsnc1ab8c07656f";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/actor/id/nm0154226/"))
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        String signo = json.getJSONObject("results").getString("star_sign");
        String lugar = json.getJSONObject("results").getString("birth_place");

        System.out.println(signo);
        System.out.println(lugar);
    }
}
