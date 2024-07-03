package com.echo.model.content;

import java.util.ArrayList;
import java.time.Duration;

import com.echo.model.platform.Review;

public class Conteudo{
    private String nome;
    private float nota;
    private ArrayList<Review> reviews;
    private ArrayList<Artista> artistaPrincipal;
    private Duration duracao;

    public Conteudo(){
        this.nome = "";
        this.nota = 0;
        this.reviews = new ArrayList<Review>();
        this.artistaPrincipal = new ArrayList<Artista>();
        this.duracao = Duration.ZERO;
    }

    public Conteudo(String nome, Duration duracao, ArrayList<Artista> artista){
        this.nome = nome;
        this.duracao = duracao;
        this.artistaPrincipal = artista;
        this.nota = 0;
        this.reviews = new ArrayList<Review>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public ArrayList<Artista> getArtistaPrincipal() {
        return artistaPrincipal;
    }

    public void setArtistaPrincipal(ArrayList<Artista> artistaPrincipal) {
        this.artistaPrincipal = artistaPrincipal;
    }

    public void addArtistaPrincipal(Artista a){
        this.artistaPrincipal.add(a);
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public ArrayList<Review> getReviews(){
        return reviews;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
    
    public void addReview(Review review){
        //contabiliza a review na lista de reviews do conteudo
        this.reviews.add(review);
        //atualiza a sua nota media
        this.setNota((review.getNota() + this.nota) / this.reviews.size());
    }
    
    public void removeReview(Review review){
        //atualiza a nota media do conteudo
        this.setNota((this.nota - review.getNota()) / (this.reviews.size()-1));
        //remove a review da lista de reviews do conteudo
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Conteudo [nome=" + nome + ", nota=" + nota + ", reviews=" + reviews + ", duracao=" + duracao + "]";
    }
}