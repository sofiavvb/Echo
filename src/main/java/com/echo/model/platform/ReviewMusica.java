package com.echo.model.platform;

import com.echo.model.content.Conteudo;

import java.util.Scanner;

public class ReviewMusica extends Review{
    
    public ReviewMusica(Usuario u, Conteudo c) {
        super(u, c);
    }

    @Override
    public void criarReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas estrelas (de 1 a 5) essa música merece?");
        super.setNota(Integer.parseInt(scanner.nextLine()));

        System.out.println("Qual sua opinião sobre: " + super.getConteudo().getNome() + "?");
        super.setReview(scanner.nextLine());

        super.getConteudo().addReview(this);
        //salva a review em um arquivo
        super.salvaReview();
        System.out.println("Obrigado por avaliar!");
        scanner.close();
    }  
}
