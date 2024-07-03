package com.echo.model.content;

import java.util.ArrayList;
import java.time.Duration;

public class Musica extends Conteudo {
    private int faixa;
    private ArrayList<Artista> artistaPrincipal;
    private Album album;

    public Musica(String nome, Duration duracao, int faixa, Album album){
        super(nome, duracao, album.getArtistaPrincipal());
        this.faixa = faixa;
        this.artistaPrincipal = new ArrayList<Artista>();
        this.album = album;
    }

    public int getFaixa() {
        return faixa;
    }

    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Musica [faixa=" + faixa + ", artistaPrincipal=" + artistaPrincipal + ", album=" + album + "]";
    }

}