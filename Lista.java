import java.util.ArrayList;

public class Lista {
    private String nome;
    private String descricao;
    private ArrayList<Conteudo> lista;
    private Usuario usuario;
    private int curtidas;

    public Lista(Usuario usuario, String nome, String descricao) {
        this.usuario = usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.lista = new ArrayList<Conteudo>();
        this.curtidas = 0;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        this.lista.add(conteudo);
    }

    public void removeConteudo(Conteudo conteudo) {
        this.lista.remove(conteudo);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conteudo> getLista() {
        return this.lista;
    }

    public void setLista(ArrayList<Conteudo> lista) {
        this.lista = lista;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCurtidas() {
        return this.curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
