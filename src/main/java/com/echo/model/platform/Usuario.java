package com.echo.model.platform;

import com.echo.model.content.Conteudo;

import java.util.ArrayList;

public class Usuario {
    // Atributos
    private String nome;
    private String senha;
    private String cpf;
    private String email;
    private String foto;
    private ArrayList<Conteudo> biblioteca;
    private ArrayList<Review> reviews;
    private ArrayList<Usuario> amigos;
    private ArrayList<Lista> listas;

    public Usuario() {
        this.biblioteca = new ArrayList<Conteudo>();
        this.reviews = new ArrayList<Review>();
        this.amigos = new ArrayList<Usuario>();
        this.listas = new ArrayList<Lista>();
    }

    public Usuario(String nome, String senha, String cpf, String email, String foto) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
        this.biblioteca = new ArrayList<Conteudo>();
        this.reviews = new ArrayList<Review>();
        this.amigos = new ArrayList<Usuario>();
        this.listas = new ArrayList<Lista>();
    }

    public void publicarReviewMusica(ReviewMusica reviewMusica) {
        this.reviews.add(reviewMusica);
    }
    
    public void publicarReviewAlbum(ReviewAlbum reviewAlbum) {
        this.reviews.add(reviewAlbum);
    }

    public void curtirReview(Review review) {
        review.setCurtidas(review.getCurtidas()+1);
    }

    public void addAmigo(Usuario amigo) {
        this.amigos.add(amigo);
    }
    
    public void publicarLista() {
        Lista l = new Lista(this);
        l.criarLista();
        this.listas.add(l);
    }

    public void removeAmigo(Usuario amigo) {
        this.amigos.remove(amigo);
    }

    public void addBiblioteca(Conteudo conteudo) {
        this.biblioteca.add(conteudo);
    }

    public void removeBiblioteca(Conteudo conteudo) {
        this.biblioteca.remove(conteudo);
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public ArrayList<Conteudo> getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(ArrayList<Conteudo> biblioteca) {
        this.biblioteca = biblioteca;
    }
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }
    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Lista> getListas() {
        return listas;
    }

    public void setListas(ArrayList<Lista> listas) {
        this.listas = listas;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + ", email=" + email + ", foto=" + foto
                + ", biblioteca=" + biblioteca + ", reviews=" + reviews + ", amigos=" + amigos + "]";
    }
}