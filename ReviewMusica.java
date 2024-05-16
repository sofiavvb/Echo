import java.util.Scanner;

public class ReviewMusica extends Review{
    
    public ReviewMusica(Usuario u, Conteudo c) {
        super(u, c);
    }

    @Override
    public void criarReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantas estrelas (de 1 a 5) essa música merece?");
        super.setNota(scanner.nextByte());

        System.out.println("Qual sua opinião sobre: " + super.getConteudo().getNome() + "?");
        super.setReview(scanner.nextLine());

        super.getConteudo().addReview(this);
        
        System.out.println("Obrigado por avaliar!");
        scanner.close();
    }

    @Override
    public String toString() {
        return "ReviewMusica []";
    }

    
}
