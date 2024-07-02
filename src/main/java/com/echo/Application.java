package com.echo;

import com.echo.model.content.Album;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // instanciar interface gráfica
        addAlbunsJson(new ArrayList<Album>());
    }

    public static void addAlbunsJson(ArrayList<Album> albums) {
       try {
           FileReader reader = new FileReader(".\\resources\\tracks.json");
           System.out.println(reader.toString());
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
}
