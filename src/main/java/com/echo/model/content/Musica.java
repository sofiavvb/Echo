package com.echo.model.content;

import java.util.ArrayList;
import java.time.Duration;

public class Musica extends Conteudo {
    private int faixa;
    private Album album;

    public Musica() {}
    public Musica(String nome, Duration duracao, int faixa, Album album){
        super(nome, duracao);
        this.faixa = faixa;
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
        return "Musica [faixa=" + faixa + ", artistaPrincipal=" + super.getArtistaPrincipal() + ", album=" + album + "]";
    }

}
