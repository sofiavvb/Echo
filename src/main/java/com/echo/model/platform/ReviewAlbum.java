package com.echo.model.platform;

import com.echo.model.content.Conteudo;
//import com.echo.model.content.Album;

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

    public void criarReview(int nota, String review){
      
        super.setNota(nota);
        super.setReview(review);

        //salva a review em um arquivo
        super.salvaReview();
        super.getConteudo().addReview(this);

        /* 
        do {
            System.out.println("Você gostaria de avaliar músicas de " + super.getConteudo().getNome() + "? [s/n]");
            String escolha = scanner.nextLine();

            if (escolha.equals("s")){
                System.out.println("**Digite a faixa(número) que quer avaliar:**");
                //mostrar musicas do album para o usuario
                ((Album) super.getConteudo()).mostrarMusicas();
                int faixa = Integer.parseInt(scanner.nextLine());
                this.getUsuario().publicarReviewMusica(((Album) super.getConteudo()).getMusicabyFaixa(faixa));
            } else{
                System.out.println("Obrigado por avaliar!");
                break;
            }
            scanner.close();
        } while (true); */
    }


}
