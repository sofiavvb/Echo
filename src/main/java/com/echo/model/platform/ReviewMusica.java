package com.echo.model.platform;

import com.echo.model.content.Conteudo;


public class ReviewMusica extends Review{
    
    public ReviewMusica(Usuario u, Conteudo c) {
        super(u, c);
    }

    @Override
    public void criarReview(int nota, String review) {

        super.setNota(nota);
        super.setReview(review);

        super.getConteudo().addReview(this);

        //salva a review em um arquivo
        super.salvaReview();
    }  
}
