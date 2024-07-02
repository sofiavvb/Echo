package com.echo.model.content;

import java.time.Duration;
import java.util.ArrayList;

public class Album extends Conteudo {
    private Genero genero;
    private ArrayList<Musica> musicas;
    private int ano;
    private Gravadora gravadora;

    public Album(String nome, Duration duracao, Genero genero, int ano, Gravadora gravadora) {
        super(nome, duracao, new ArrayList<Artista>());
        this.genero = genero;
        this.musicas = new ArrayList<Musica>();
        this.ano = ano;
        this.gravadora = gravadora;
        this.gravadora.addAlbum(this);
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public void addMusica(Musica musica){
        this.musicas.add(musica);
    }

    public Musica getMusicabyFaixa(int faixa){
        for(Musica musica : this.musicas){
            if(musica.getFaixa() == faixa){
                return musica;
            }
        }
        return null;
    }

    public void mostrarMusicas(){
        for(Musica musica : this.musicas){
            System.out.println(musica.getFaixa()+ "- " + musica.getNome());
        }
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public Gravadora getGravadora() {
        return gravadora;
    }
    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    @Override
    public String toString() {
        return "Album [genero=" + genero + ", artistaPrincipal=" + super.getArtistaPrincipal() + ", musicas=" + musicas + ", ano="
                + ano + ", gravadora=" + gravadora + "]";
    }

}
