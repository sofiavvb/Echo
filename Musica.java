import java.util.ArrayList;
import java.time.Duration;

public class Musica extends Conteudo{
    private int faixa;
    private ArrayList<Artista> artistaPrincipal;
    private ArrayList<Artista> interpretes;
    private ArrayList<Artista> compositores;
    private ArrayList<Artista> produtores;
    private ArrayList<Artista> instrumentistas;
    private Album album;
    private int reviews;
    private int ano;

    public Musica(String nome, Duration duracao, int faixa, Album album, int ano){
        super(nome, duracao);
        this.faixa = faixa;
        this.artistaPrincipal = new ArrayList<Artista>();
        this.interpretes = new ArrayList<Artista>();
        this.compositores = new ArrayList<Artista>();
        this.produtores = new ArrayList<Artista>();
        this.instrumentistas = new ArrayList<Artista>();
        this.album = album;
        this.reviews = 0;
        this.ano = ano;
    }

    public int getFaixa() {
        return faixa;
    }

    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }

    public ArrayList<Artista> getArtistaPrincipal() {
        return artistaPrincipal;
    }

    public ArrayList<Artista> getInterpretes() {
        return interpretes;
    }

    public ArrayList<Artista> getCompositores() {
        return compositores;
    }

    public ArrayList<Artista> getProdutores() {
        return produtores;
    }

    public ArrayList<Artista> getInstrumentistas() {
        return instrumentistas;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void addArtistaPrincipal(Artista artista){
        this.artistaPrincipal.add(artista);
    }

    public void addInterprete(Artista artista){
        this.interpretes.add(artista);
    }

    public void addCompositor(Artista artista){
        this.compositores.add(artista);
    }

    public void addProdutor(Artista artista){
        this.produtores.add(artista);
    }

    public void addInstrumentista(Artista artista){
        this.instrumentistas.add(artista);
    }

    //faz sentido ter metodo para retirar artista?

}
