import java.util.ArrayList;
import java.time.Duration;

public class Conteudo{
    private String nome;
    private float nota;
    private ArrayList<Review> reviews;
    private Duration duracao;

    public Conteudo(String nome, Duration duracao){
        this.nome = nome;
        this.nota = 0;
        this.duracao = duracao;
        this.reviews = new ArrayList<Review>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
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
        this.setNota((this.nota - review.getNota()) / this.reviews.size());
        //remove a review da lista de reviews do conteudo
        this.reviews.remove(review);
    }
}