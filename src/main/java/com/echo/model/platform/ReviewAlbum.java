package com.echo.model.platform;

import com.echo.model.content.Conteudo;
import com.echo.model.content.Album;
import java.util.Scanner;

public class ReviewAlbum extends Review{
    private int coesao;

    public ReviewAlbum(Usuario u, Conteudo c) {
        super(u, c);
        this.coesao = 0;
    }

    public int getCoesao() {
        return coesao;
    }

    public void setCoesao(int coesao) {
        this.coesao = coesao;
    }

    @Override
    public void criarReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas estrelas (de 1 a 5) esse álbum merece?");
        super.setNota(Integer.parseInt(scanner.nextLine()));

        System.out.println("Qual sua opinião sobre: " + super.getConteudo().getNome() + "?");
        super.setReview(scanner.nextLine());

        System.out.println("Qual a coesão desse álbum (de 1 a 5)?");
        this.setCoesao(Integer.parseInt(scanner.nextLine()));

        super.getConteudo().addReview(this);
        do {
            System.out.println("Você gostaria de avaliar músicas de " + super.getConteudo().getNome() + "? [s/n]");
            String escolha = scanner.nextLine();

            if (escolha.equals("s")){
                System.out.println("*****Digite a faixa(número) que quer avaliar:*****");
                //mostrar musicas do album para o usuario
                ((Album) super.getConteudo()).mostrarMusicas();
                int faixa = Integer.parseInt(scanner.nextLine());
                this.getUsuario().publicarReviewMusica(((Album) super.getConteudo()).getMusicabyFaixa(faixa));
            } else{
                System.out.println("Obrigado por avaliar!");
                break;
            }
            scanner.close();
        } while (true);
    }

    @Override
    public String toString() {
        return "ReviewAlbum [coesao=" + coesao + "]";
    } 
}
