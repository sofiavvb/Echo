package com.echo;

import com.echo.model.content.Album;
import com.echo.utils.JSONParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // instanciar interface gráfica
        addAlbunsJson(new ArrayList<Album>());
    }

    public static void addAlbunsJson(ArrayList<Album> albums) {
       String json = "";

       try {
           JsonNode node = JSONParser.parse(json);
           //System.out.println(node.get());


       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
