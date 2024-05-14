import java.util.Scanner;

public class Review {
    private Usuario usuario;
    private Conteudo conteudo;
    private String review;
    private float nota;
    public Review (Usuario u, Conteudo c) {
        this.usuario = u;
        this.conteudo = c;
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
}


/*
 * ReviewMusica
 * -
 * -
 * -
 * -
 * 
 * 
 * 
 */