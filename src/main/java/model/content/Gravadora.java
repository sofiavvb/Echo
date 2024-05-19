package src.main.java.model.content;

import java.util.ArrayList;

public class Gravadora {
    String nome;
    private ArrayList<Artista> artistas;
    private ArrayList<Album> albuns;

    public Gravadora(String nome){
        this.nome = nome;
        this.artistas = new ArrayList<Artista>();
        this.albuns = new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbuns(){
        return this.albuns;
    }

    public ArrayList<Artista> getArtistas(){
        return this.artistas;
    }

    public boolean addArtista(Artista artista){
        return this.artistas.add(artista);
    }

    public boolean addAlbum(Album album){
        return this.albuns.add(album);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //artistas saem de gravadoras, albuns não.
    public boolean removeArtista(Artista artista){
        return this.artistas.remove(artista);
    }

    @Override
    public String toString() {
        return "Gravadora [nome=" + nome + ", artistas=" + artistas + ", albuns=" + albuns + "]";
    }
}
