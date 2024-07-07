package com.echo.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import com.echo.model.platform.Usuario;
import com.echo.model.platform.ReviewAlbum;
import com.echo.model.content.Album;
import java.util.ArrayList;

public class PaginaReview extends JFrame {
    private Usuario usuario;
    private Album album;
    private int nota;
    private int coesao;
    private String reviewText;
    private ArrayList<Album> albums;

    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textField3;

    public PaginaReview(Usuario usuario, Album album, ArrayList<Album> albums) {
        this.usuario = usuario;
        this.album = album;
        this.albums = albums;
        initComponents();
        setVisible(true);
    }

    public ReviewAlbum criarReviewAlbum() {
        ReviewAlbum reviewAlbum = new ReviewAlbum(usuario, album);
        reviewAlbum.criarReview(nota, reviewText);
        reviewAlbum.setCoesao(coesao);
        return reviewAlbum;
    }

    public void initComponents() {
        // Configurações gerais da janela
        setTitle("Echo - Review");
        setSize(600, 400);
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createPainelCabecalho(), BorderLayout.NORTH);
        add(createPainelCentral(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private JPanel createPainelCabecalho() {
        JPanel painelCabecalho = new JPanel(new BorderLayout());
        painelCabecalho.setBackground(Color.BLACK);

        // Logo no canto superior esquerdo
        painelCabecalho.add(createPainelLogo(), BorderLayout.WEST);

        return painelCabecalho;
    }


    private JPanel createPainelCentral() {
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.setBackground(Color.BLACK);

        painelCentral.add(createImagePanel());
        painelCentral.add(createTextPanel());

        return painelCentral;
    }

    private JPanel createPainelLogo() {
        JPanel painelLogo = new JPanel();
        painelLogo.setBackground(Color.BLACK);

        JLabel logo = createLogo();
        painelLogo.add(logo);

        return painelLogo;
    }


    private JLabel createLogo() {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/logoEcho.jpg");
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(image));
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.setBackground(Color.BLACK);
        

        JLabel labelImagem = createImage();
        labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelTitulo = new JLabel(album.getNome());
        labelTitulo.setForeground(Color.WHITE);

        // Alterando a fonte do título do usuário
        Font titleFont = new Font("Serif", Font.BOLD, 20);
        labelTitulo.setFont(titleFont);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        imagePanel.add(labelTitulo);
        imagePanel.add(Box.createVerticalStrut(10));
        imagePanel.add(labelImagem);

        return imagePanel;
    }

    private JLabel createImage() {
        try {
            URL url = new URL(album.getLinkCapa());
            Image image = ImageIO.read(url);
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);


            return new JLabel(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
            return new JLabel("Image not avalible");
        }

    }

    private JPanel createTextPanel() {
        // Painel para os campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textPanel.setBackground(Color.BLACK);
        textPanel.setForeground(Color.WHITE);

        // Primeira caixa de texto
        JLabel label1 = new JLabel("Nota:");
        textField1 = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        label1.setForeground(Color.WHITE);
        textPanel.add(label1, gbc);
        gbc.gridx = 1;
        textPanel.add(textField1, gbc);

        // Segunda caixa de texto
        JLabel label2 = new JLabel("Coesão:");
        textField2 = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        label2.setForeground(Color.WHITE);
        textPanel.add(label2, gbc);
        gbc.gridx = 1;
        textPanel.add(textField2, gbc);

        // Caixa de texto de várias linhas
        JLabel label3 = new JLabel("Review:");
        textField3 = new JTextArea(10, 20);
        textField3.setLineWrap(true);
        textField3.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textField3);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        label3.setForeground(Color.WHITE);
        textPanel.add(label3, gbc);
        gbc.gridy = 3;
        textPanel.add(scrollPane, gbc);

        // Botão para salvar os textos
        JButton saveButton = new JButton("SALVAR");
        saveButton.setBackground(new Color(200, 50, 250));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> saveText());
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        textPanel.add(saveButton, gbc);

        return textPanel;
    }

    private void saveText() {
        nota = Integer.parseInt(textField1.getText());
        coesao = Integer.parseInt(textField2.getText());
        reviewText = textField3.getText();
        ReviewAlbum reviewAlbum = criarReviewAlbum();
        usuario.publicarReviewAlbum(reviewAlbum);
        setVisible(false);
        PaginaUsuario nova = new PaginaUsuario(usuario, albums);
        nova.setVisible(true);
    }
}
