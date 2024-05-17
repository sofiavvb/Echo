import java.util.Scanner;
import java.time.Duration;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //albuns disponiveis na v0 do Echo
        ArrayList<Album> albuns = new ArrayList<Album>();
        addAlbunsEcho(albuns);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo(a) ao Echo!");
        Usuario usuario = new Usuario();
        System.out.println("Qual o seu nome?");
        usuario.setNome(scanner.nextLine());
        System.out.println("Qual o seu CPF?");
        usuario.setCpf(scanner.nextLine());
        System.out.println("Qual seu email?");
        usuario.setEmail(scanner.nextLine());
        System.out.println("Crie uma senha:");
        usuario.setSenha(scanner.nextLine());
        System.out.println("Insira a URL de uma foto sua:");
        usuario.setFoto(scanner.nextLine());

        System.out.println("Olá, " + usuario.getNome() + "!");
        System.out.println("Esses são os álbuns disponíveis no Echo:");
        mostrarAlbuns(albuns);

        //Fazer review de um album, por enquanto so temos 1 cadastrado na plataforma
        System.out.println(usuario.getNome() + ", gostaria de fazer uma review de algum álbum?\n1-Sim\n2-Não");
        int escolha = Integer.parseInt(scanner.nextLine());
        //Obter o album que o usuario quer fazer a review
        if (escolha == 1){
            System.out.println("*****Qual álbum você gostaria de avaliar?*****");
            mostrarAlbuns(albuns);
            String albumEscolhido = scanner.nextLine();
            for (Album album : albuns){
                if (album.getNome().equals(albumEscolhido)){
                    usuario.publicarReviewAlbum(album);
                }
            }
        }
        scanner.close();
    }

    public static void addAlbunsEcho(ArrayList<Album> a){
        Gravadora republicRecords = new Gravadora("Republic Records");
        Artista taylorSwift = new Artista("Taylor Swift", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbr.pinterest.com%2Fpin%2F800514902541450549%2F&psig=AOvVaw16iIVlVUJwDSdCi0llX-GL&ust=1715811172335000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIiE--yUjoYDFQAAAAAdAAAAABAE");
        republicRecords.addArtista(taylorSwift);

        Album ttpd = new Album("THE TORTURED POETS DEPARTMENT: THE ANTHOLOGY", Duration.ofHours(2).plusMinutes(2), Genero.SYNTHPOP, 2024, republicRecords);
        ttpd.addArtista(taylorSwift);
        ttpd.addMusica(new Musica("Fortnight (feat. Post Malone)", Duration.ofMinutes(3).plusSeconds(48), 1, ttpd));
        ttpd.addMusica(new Musica("The Tortured Poets Department", Duration.ofMinutes(4).plusSeconds(12), 2, ttpd));
        ttpd.addMusica(new Musica("My Boy Only Breaks His Favorite Toys", Duration.ofMinutes(3).plusSeconds(45), 3, ttpd));
        ttpd.addMusica(new Musica("Down Bad", Duration.ofMinutes(3).plusSeconds(12), 4, ttpd));
        ttpd.addMusica(new Musica("So Long, London", Duration.ofMinutes(4).plusSeconds(2), 5, ttpd));
        ttpd.addMusica(new Musica("But Daddy I Love Him", Duration.ofMinutes(4).plusSeconds(12), 6, ttpd));
        ttpd.addMusica(new Musica("Fresh Out the Slammer", Duration.ofMinutes(3).plusSeconds(12), 7, ttpd));
        ttpd.addMusica(new Musica("Florida!!! (feat. Florence + The Machine)", Duration.ofMinutes(3).plusSeconds(12), 8, ttpd));      
        ttpd.addMusica(new Musica("Guilty as Sin?", Duration.ofMinutes(3).plusSeconds(12), 9, ttpd));
        ttpd.addMusica(new Musica("Who's Afraid of Little Old Me?", Duration.ofMinutes(3).plusSeconds(12), 10, ttpd));
        ttpd.addMusica(new Musica("I Can Fix Him (No I Really I Can)", Duration.ofMinutes(3).plusSeconds(12), 11, ttpd));
        ttpd.addMusica(new Musica("loml", Duration.ofMinutes(3).plusSeconds(12), 12, ttpd));
        ttpd.addMusica(new Musica("I Can Do It With a Broken Heart", Duration.ofMinutes(3).plusSeconds(12), 13, ttpd));
        a.add(ttpd);
    }

    public static void mostrarAlbuns(ArrayList<Album> albuns){
        for (Album album : albuns){
            System.out.println("-" + album.getNome());
        }
    }
}
