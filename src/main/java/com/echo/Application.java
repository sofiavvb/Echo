package com.echo;

import com.echo.model.content.Album;
import com.echo.model.content.Artista;
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
       Artista taylorSwift = new Artista("Taylor Swift", "https://www.google.com/url?sa=i&url=https%3A%2F%2Finteligenciafinanceira.com.br%2Ffinancas%2Fquem-e%2Ftaylor-swift-the-eras-tour%2F&psig=AOvVaw1dOvf91xWqLQsHkNxmtNmi&ust=1720100331504000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNi1-Z3_iocDFQAAAAAdAAAAABAE");

       try {
            json = new String(Files.readAllBytes(Paths.get("src/main/resources/albums.json")));
            JsonNode node = JSONParser.parse(json);
            albums = JSONParser.albumFromJson(node, taylorSwift);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
