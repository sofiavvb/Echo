package com.echo;

import com.echo.model.content.Album;
import com.echo.model.content.Artista;
import com.echo.graphics.InterfaceGrafica;
import com.echo.utils.JSONParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import static com.echo.utils.JSONParser.albums;

public class Application {
    public static void main(String[] args) {
        var albums = addAlbunsJson();
        addTracksJson(albums);
        //System.out.println(albums.get(0));
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica(albums);
        interfaceGrafica.chamarCadastro();
    }

    public static ArrayList<Album> addAlbunsJson() {
       Artista taylorSwift = new Artista("Taylor Swift", "https://www.google.com/url?sa=i&url=https%3A%2F%2Finteligenciafinanceira.com.br%2Ffinancas%2Fquem-e%2Ftaylor-swift-the-eras-tour%2F&psig=AOvVaw1dOvf91xWqLQsHkNxmtNmi&ust=1720100331504000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNi1-Z3_iocDFQAAAAAdAAAAABAE");

       try {
            var json = new String(Files.readAllBytes(Paths.get("src/main/resources/albums.json")));
            JsonNode node = JSONParser.parse(json);
            albums = JSONParser.albumFromJson(node, taylorSwift);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return albums;
    }

    public static void addTracksJson(ArrayList<Album> albums) {
        try {
            var json = new String(Files.readAllBytes(Paths.get("src/main/resources/tracks.json")));
            JsonNode node = JSONParser.parse(json);
            JSONParser.addTracksFromJson(node, albums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
