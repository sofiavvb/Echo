package com.echo;

import com.echo.model.content.Album;
import com.echo.utils.JSONParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // instanciar interface gráfica
        ArrayList<Album> albums = new ArrayList<Album>();
        addAlbunsJson(albums);
    }

    public static void addAlbunsJson(ArrayList<Album> albums) {
       String json = "";

       try {
            json = new String(Files.readAllBytes(Paths.get("src/main/resources/albums.json")));

           JsonNode node = JSONParser.parse(json);

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
