import java.util.ArrayList;

public class Usuario {
    // Atributos
    String nome;
    String senha;
    String cpf;
    String email;
    String foto;
    ArrayList<Conteudo> biblioteca;
    ArrayList<Review> reviews;
    ArrayList<Usuario> amigos;

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

    // outros métodos


}