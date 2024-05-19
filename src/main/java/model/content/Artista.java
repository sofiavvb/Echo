import java.util.ArrayList;

public class Artista {
   private String nome;
   private String foto;
   private ArrayList<Album> discografia;
   private ArrayList<Musica> singles;


   public Artista(String nome, String foto){
       this.nome = nome;
       this.foto = foto;
       this.discografia = new ArrayList<Album>();
       this.singles = new ArrayList<Musica>();
   }

   public String getNome(){
       return nome;
   }

   public void setNome(String nome){
       this.nome = nome;
   }

   public String getFoto(){
       return foto;
   }

   public void setFoto(String foto){
       this.foto = foto;
   }

   public ArrayList<Album> getDiscografia(){
       return discografia;
   }

   public ArrayList<Musica> getSingles(){
       return singles;
   }

   public boolean addSingle(Musica musica){
       return this.singles.add(musica);
   }

   public boolean addAlbum(Album album){
       return this.discografia.add(album);
   }

    @Override
    public String toString() {
        return "Artista [nome=" + nome + ", foto=" + foto + ", discografia=" + discografia + ", singles=" + singles + "]";
    }
}
