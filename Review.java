import java.time.LocalDate;
import java.util.Scanner;

public class Review {
    private Usuario usuario;
    private LocalDate data;
    private Conteudo conteudo;
    private String review;
    private float nota;
    private int curtidas;

    public Review (Usuario u, Conteudo c) {
        this.usuario = u;
        this.conteudo = c;
        this.data = LocalDate.now();
        this.curtidas = 0;
        this.nota = 0;
        this.review = "";
    }

    void publicarReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas estrelas (de 1 a 5) esse conteúdo merece?");
        this.nota = scanner.nextByte();

        System.out.println("Qual sua opinião sobre: " + this.conteudo.getNome() + "?");
        this.review = scanner.nextLine();

        this.conteudo.addReview(this);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Conteudo getConteudo() {
        return conteudo;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public LocalDate getData() {
        return data;
    }
}
