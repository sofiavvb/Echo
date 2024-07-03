package com.echo.utils;

import com.echo.model.content.Album;
import com.echo.model.content.Artista;
import com.echo.model.content.Gravadora;
import com.echo.model.content.Musica;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class JSONParser {
    public static ArrayList<Album> albums;
    public static ArrayList<Gravadora> gravadoras;
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parse(String json) throws IOException {
        return mapper.readTree(json);
    }

    public static ArrayList<Album> albumFromJson(JsonNode node, Artista artista) {
        albums = new ArrayList<Album>();
        gravadoras = new ArrayList<Gravadora>();
        node.forEach(no -> no.forEach(album -> {
            Album a = new Album();
            a.setNome(album.get("name").asText());
            a.setAno(album.get("year").asInt());
            for (Gravadora gravadora : gravadoras) {
                if (gravadora.equals(album.get("label").asText()))
                    a.setGravadora(gravadora);
            }
            if (a.getGravadora() == null) {
                var g = new Gravadora(album.get("label").asText());
                a.setGravadora(g);
                gravadoras.add(g);
            }
            a.setGenero(album.get("genre").asText());
            a.setLinkCapa(album.get("coverLink").asText());
            a.setArtistaPrincipal(artista);
            albums.add(a);
        }));
        
        return albums;
    }

    public static void addTracksFromJson (JsonNode node, ArrayList<Album> albums) {
        int i = 0;
        for (JsonNode no : node) {
            var album = albums.get(i);
            no.get("items").forEach(track -> {
                Musica m = new Musica(
                        track.get("name").asText(),
                        Duration.ofMillis(track.get("duration_ms").asLong()),
                        track.get("disc_number").asInt(),
                        album
                );
                track.get("artists").forEach(artist -> {
                    Artista a = new Artista(artist.get("name").asText(), "");
                    m.addArtista(a);
                });
                album.addMusica(m);
            });
            i++;
        }
    }
}   
