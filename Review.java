import java.time.LocalDate;

public abstract class Review {
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

    public abstract void criarReview();

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

    @Override
    public String toString() {
        return "Review [usuario=" + usuario + ", data=" + data + ", conteudo=" + conteudo + ", review=" + review
                + ", nota=" + nota + ", curtidas=" + curtidas + "]";
    }

}
