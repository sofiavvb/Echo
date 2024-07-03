package com.echo.utils;

import com.echo.model.content.Album;
import com.echo.model.content.Gravadora;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class JSONParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parse(String json) throws IOException {
        return mapper.readTree(json);
    }

    public static ArrayList<Album> albumFromJson(JsonNode node, ArrayList<Gravadora> gravadoras) {
        var albums = new ArrayList<Album>();
        node.forEach(album -> {
               Album a = new Album();
               a.setNome(album.get("name").asText());
               a.setAno(album.get("year").asInt());
               gravadoras.
               albums.add(a);
              });
        
        return albums;
    }
}   
