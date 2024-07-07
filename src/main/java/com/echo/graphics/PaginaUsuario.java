package com.echo.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.echo.model.platform.Usuario;
import com.echo.model.content.Album;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaginaUsuario extends JFrame {
    private Usuario usuario;
    private ArrayList<Album> albums;

    public PaginaUsuario(Usuario usuario, ArrayList<Album> albums) {
        this.albums = albums;
        this.usuario = usuario;
        initUI();
    }

    public void initUI() {
        setTitle("Echo - User Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());
        add(createPainelCabecalho(), BorderLayout.NORTH);
        add(createPainelCentral(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Menu");

        JMenuItem itemFeed = new JMenuItem("Feed");
        JMenuItem itemSettings = new JMenuItem("Settings");
        JMenuItem itemLogOut = new JMenuItem("Log out");

        itemLogOut.addActionListener(e -> System.exit(0));

        menuArquivo.add(itemFeed);
        menuArquivo.add(itemSettings);
        menuArquivo.addSeparator();
        menuArquivo.add(itemLogOut);
        menuBar.add(menuArquivo);

        // Alterando a fonte da barra de menu
        Font menuFont = new Font("Serif", Font.PLAIN, 18);
        menuArquivo.setFont(menuFont);
        itemFeed.setFont(menuFont);
        itemSettings.setFont(menuFont);
        itemLogOut.setFont(menuFont);

        return menuBar;
    }

    private JPanel createPainelCabecalho() {
        JPanel painelCabecalho = new JPanel(new BorderLayout());
        painelCabecalho.setBackground(Color.BLACK);

        // Logo no canto superior esquerdo
        painelCabecalho.add(createPainelLogo(), BorderLayout.WEST);

        // Ícones de redes sociais no centro superior
        painelCabecalho.add(createPainelRedesSociais(), BorderLayout.CENTER);

        // Barra de pesquisa no canto superior direito
        painelCabecalho.add(createBarraDePesquisa(), BorderLayout.EAST);

        return painelCabecalho;
    }

    private JPanel createPainelLogo() {
        JPanel painelLogo = new JPanel();
        painelLogo.setBackground(Color.BLACK);

        JLabel logo = createLogo();
        painelLogo.add(logo);

        return painelLogo;
    }

    private JPanel createPainelRedesSociais() {
        JPanel painelRedesSociais = new JPanel();
        painelRedesSociais.setBackground(Color.BLACK);
        painelRedesSociais.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        List<String> caminhos = new ArrayList<>();
        caminhos.add("src/main/resources/instagram.png");
        caminhos.add("src/main/resources/xLogo.jpg");
        caminhos.add("src/main/resources/instagram.png");

        // Adicionar ícones de redes sociais
        for (int i = 0; i < 3; i++) {
            ImageIcon icon = new ImageIcon(caminhos.get(i));
            JButton botaoRedeSocial = new JButton(icon);
            botaoRedeSocial.setPreferredSize(new Dimension(30, 30));
            painelRedesSociais.add(botaoRedeSocial);
        }

        return painelRedesSociais;
    }

    private JPanel createBarraDePesquisa() {
        JPanel painelPesquisa = new JPanel();
        painelPesquisa.setBackground(Color.BLACK);

        JTextField barraPesquisa = new JTextField(20);
        JButton botaoPesquisa = new JButton("Pesquisar");

        painelPesquisa.add(barraPesquisa);
        painelPesquisa.add(botaoPesquisa);

        return painelPesquisa;
    }

    private JPanel createPainelCentral() {
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.setBackground(Color.BLACK);

        painelCentral.add(createMenuHorizontalSuperior());
        painelCentral.add(createPainelImagemTitulo());
        painelCentral.add(createMenuHorizontalInferior());
        painelCentral.add(createBiblioteca());

        return painelCentral;
    }

    private JPanel createMenuHorizontalSuperior() {
        JPanel painelMenu = new JPanel();
        painelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelMenu.setBackground(Color.BLACK);

        // Adicionar itens ao menu
        JButton botaoMenu1 = new JButton("Discover");
        JButton botaoMenu2 = new JButton("Lists");
        JButton botaoMenu3 = new JButton("Genres");
        JButton botaoMenu4 = new JButton("News");
        JButton botaoMenu5 = new JButton("Community");
        painelMenu.add(botaoMenu1);
        painelMenu.add(botaoMenu2);
        painelMenu.add(botaoMenu3);
        painelMenu.add(botaoMenu4);
        painelMenu.add(botaoMenu5);

        return painelMenu;
    }

    private Album procurarAlbum(ArrayList<Album> albums, String nome) throws InvalidAlbumName {
        for (Album album: albums) {
            if((album.getNome().equals(nome))) {
                return album;

            }
        } 

        throw new InvalidAlbumName();

    }

    private JPanel createMenuHorizontalInferior() {
        JPanel painelMenu = new JPanel();
        painelMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelMenu.setBackground(Color.BLACK);

        // Adicionar itens ao menu
        JButton botaoMenu1 = new JButton("Ratings");
        JButton botaoMenu2 = new JButton("Reviews");
        JButton botaoMenu3 = new JButton("Likes");
        JButton botaoMenu4 = new JButton("Lists");
        JButton botaoMenu5 = new JButton("Library");
        JButton botaoMenu6 = new JButton("MAKE A REVIEW");
        botaoMenu6.setBackground(new Color(200, 50, 250));
        botaoMenu6.setForeground(Color.WHITE);
        painelMenu.add(botaoMenu1);
        painelMenu.add(botaoMenu2);
        painelMenu.add(botaoMenu3);
        painelMenu.add(botaoMenu4);
        painelMenu.add(botaoMenu5);
        painelMenu.add(botaoMenu6);

        botaoMenu6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Album album = null;
                String nome = JOptionPane.showInputDialog(null, "Informe o nome do album que deseja avaliar:", "Entrada de Nome de Album", JOptionPane.QUESTION_MESSAGE);
                if (nome != null && !nome.trim().isEmpty()) {
                    // Exibir o nome digitado em uma mensagem
                    JOptionPane.showMessageDialog(null, "Nome informado: " + nome);
                    try {
                        album = procurarAlbum(albums, nome);
                        PaginaReview paginaReview = new PaginaReview(usuario, album, albums);
                        paginaReview.setVisible(true);
                        dispose();

                    } catch(InvalidAlbumName ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                   
                } else {
                    // Exibir mensagem caso o nome não seja informado
                    JOptionPane.showMessageDialog(null, "Nenhum nome foi informado.");
                }

            }
        });

        return painelMenu;
    }


    private JPanel createPainelImagemTitulo() {
        JPanel painelImagemTitulo = new JPanel();
        painelImagemTitulo.setLayout(new BoxLayout(painelImagemTitulo, BoxLayout.Y_AXIS));
        painelImagemTitulo.setBackground(Color.BLACK);

        JLabel labelImagem = createImagemPerfil();
        labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelTitulo = new JLabel(usuario.getNome());
        labelTitulo.setForeground(Color.WHITE);

        // Alterando a fonte do título do usuário
        Font titleFont = new Font("Serif", Font.BOLD, 20);
        labelTitulo.setFont(titleFont);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelImagemTitulo.add(labelImagem);
        painelImagemTitulo.add(Box.createVerticalStrut(10));
        painelImagemTitulo.add(labelTitulo);

        return painelImagemTitulo;
    }
    
    private JLabel createImagemPerfil() {
        try {
            URL url = new URL(usuario.getFoto());
            Image image = ImageIO.read(url);
            
            // Verifique se a imagem foi carregada corretamente
            if (image == null) {
                throw new IOException("Failed to load image.");
            }
            
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            return new JLabel("Image not available");
        }
    }
    

    private JLabel createLogo() {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/logoEcho.jpg");
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(image));
    }

    private JPanel createBiblioteca() {
        JPanel painelBiblioteca = new JPanel();
        painelBiblioteca.setLayout(new BoxLayout(painelBiblioteca, BoxLayout.Y_AXIS));
        painelBiblioteca.setBackground(Color.BLACK);

        JLabel labelCentralTitulo = new JLabel("Library");
        labelCentralTitulo.setForeground(Color.WHITE);
        labelCentralTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Alterando a fonte do título central
        Font centralTitleFont = new Font("Serif", Font.BOLD, 22);
        labelCentralTitulo.setFont(centralTitleFont);

        painelBiblioteca.add(Box.createVerticalStrut(20));
        painelBiblioteca.add(labelCentralTitulo);
        painelBiblioteca.add(Box.createVerticalStrut(10));
        painelBiblioteca.add(createPainelImagens());

        return painelBiblioteca;
    }

    private ImageIcon createImage(Album album) {
        try {
            URL url = new URL(album.getLinkCapa());
            Image image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);


            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageIcon("Image not avalible");
        }

    }

    private JPanel createPainelImagens() {
        JPanel painelImagens = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelImagens.setBackground(Color.BLACK);

        int tamanhoBiblioteca = usuario.getBiblioteca().size();

        for (int i = 0; i < tamanhoBiblioteca; i++) {
            Album album = (Album)usuario.getBiblioteca().get(i);
            ImageIcon icon = createImage(album);
            JButton botaoImagem = new JButton(icon);
            botaoImagem.setPreferredSize(new Dimension(100, 100));
            painelImagens.add(botaoImagem);

            int index = i;
            botaoImagem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Imagem " + index + " clicada!"));
        }

        return painelImagens;
    }

}
