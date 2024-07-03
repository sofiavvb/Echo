package com.echo.model.content;

import java.time.Duration;
import java.util.ArrayList;

public class Album extends Conteudo {
    private Genero genero;
    private ArrayList<Musica> musicas;
    private int ano;
    private Gravadora gravadora;
    private String linkCapa;

    public Album() {
        super();
        this.musicas = new ArrayList<Musica>();
    }

    public Album(String nome, Duration duracao, Genero genero, int ano, Gravadora gravadora, String linkCapa) {
        super(nome, duracao);
        this.genero = genero;
        this.musicas = new ArrayList<Musica>();
        this.ano = ano;
        this.gravadora = gravadora;
        this.gravadora.addAlbum(this);
        this.linkCapa = linkCapa;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = Genero.valueOf(genero);
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
    //adiciona o artista no album e
    //o album a discografia do artista
    @Override
    public void addArtistaPrincipal(Artista a){
        super.addArtistaPrincipal(a);
        a.addAlbum(this);
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
    //adiciona a gravadora ao album e o album a gravadora
    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
        this.gravadora.addArtista(this.getArtistaPrincipal());
        this.gravadora.addAlbum(this);
    }
    public String getLinkCapa() {
        return linkCapa;
    }
    public void setLinkCapa(String linkCapa) {
        this.linkCapa = linkCapa;
    }


}
