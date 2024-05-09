import java.util.ArrayList;

public class Gravadora {
    private ArrayList<Artista> artistas;
    private ArrayList<Album> albuns;

    public Gravadora(){
        this.artistas = new ArrayList<Artista>();
        this.albuns = new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbum(){
        return this.albuns;
    }

    public ArrayList<Artista> getArtista(){
        return this.artistas;
    }

    public boolean addArtista(Artista artista){
        return this.artistas.add(artista);
    }

    public boolean addAlbum(Album album){
        return this.albuns.add(album);
    }
    //artistas saem de gravadoras, albuns não.
    public boolean removeArtista(Artista artista){
        return this.artistas.remove(artista);
    }
}
