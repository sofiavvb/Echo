package com.echo.model.platform;

import com.echo.model.content.Conteudo;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public abstract void criarReview(int nota, String review);

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

   public void salvaReview(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/reviews/reviews.txt", true))) {
            writer.write("----Review de " + this.conteudo.getNome() + " por " + this.usuario.getNome()+ "----\n");
            writer.write("* Data: " + this.data + "\n");
            writer.write("* Nota: " + this.nota + "\n");
            writer.write(this.review + "\n");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar review: " + e.getMessage());
        }
   }
}