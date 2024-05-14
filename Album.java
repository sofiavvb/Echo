import java.util.ArrayList;
import java.time.Duration;

public class Album extends Conteudo {
    // Atributos
    String nome;
    Duration duracao;
    Enum genero;
    ArrayList<Artista> artistaPrincipal;
    ArrayList<Musica> musicas;
    float nota;
    int ano;
    Gravadora gravadora;
    ArrayList<Review> reviews;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public TimeInterval getDuracao() {
        return duracao;
    }
    public void setDuracao(TimeInterval duracao) {
        this.duracao = duracao;
    }
    public Enum getGenero() {
        return genero;
    }
    public void setGenero(Enum genero) {
        this.genero = genero;
    }
    public ArrayList<Artista> getArtistaPrincipal() {
        return artistaPrincipal;
    }
    public void setArtistaPrincipal(ArrayList<Artista> artistaPrincipal) {
        this.artistaPrincipal = artistaPrincipal;
    }
    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
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
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

