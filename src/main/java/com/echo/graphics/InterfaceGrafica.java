package com.echo.graphics;
import com.echo.model.content.Album;
import java.util.ArrayList;

public class InterfaceGrafica {
    private Cadastro paginaCadastro;

    public InterfaceGrafica(ArrayList<Album> albums) {
        paginaCadastro = new Cadastro(albums);
    }

    public void chamarCadastro() {
        paginaCadastro.initComponents();;

    }
    
}
