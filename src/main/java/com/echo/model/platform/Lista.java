package com.echo.model.platform;

import java.util.ArrayList;
import java.util.Scanner;

import com.echo.model.content.Conteudo;

public class Lista {
    private String nome;
    private String descricao;
    private ArrayList<Conteudo> lista;
    private Usuario usuario;
    private int curtidas;

    public Lista(Usuario usuario) {
        this.usuario = usuario;
        this.lista = new ArrayList<Conteudo>();
        this.curtidas = 0;
    }

    public void criarLista() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual será o nome da sua lista?");
        this.setNome(scanner.nextLine());
        System.out.println("Insira uma breve descrição dela:");
        this.setDescricao(scanner.nextLine());
        System.out.println("Qual dos conteúdos disponíveis você gostaria de adicionar a sua lista?");
        // aqui, devemos nas próximas versões mostrar os conteúdos disponíveis na plataforma e deixar o
        // usuário escolher e adicionar
        // this.adicionarConteudo(conteudoEscolhido);
        scanner.close();
    }

    public void adicionarConteudo(Conteudo c) {
        this.lista.add(c);
    }

    public void removeConteudo(Conteudo c) {
        this.lista.remove(c);
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

    @Override
    public String toString() {
        return "Lista [nome=" + nome + ", descricao=" + descricao + ", lista=" + lista + ", usuario=" + usuario
                + ", curtidas=" + curtidas + "]";
    }

}
