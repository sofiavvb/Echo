package com.echo.graphics;
import javax.swing.*;
import java.awt.*;
import com.echo.model.platform.Usuario;
import com.echo.model.platform.ReviewAlbum;
import com.echo.model.content.Album;

public class PaginaReview extends JFrame {
    private Usuario usuario;
    private Album album;
    private int nota;
    private int coesao;
    private String reviewText;


    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textField3;


    public PaginaReview(Usuario usuario, Album album) {
        this.usuario = usuario;
        this.album = album;

    }

    public ReviewAlbum criarReviewAlbum() {
        initComponents();
        ReviewAlbum reviewAlbum = new ReviewAlbum(usuario, album);
        reviewAlbum.criarReview(nota, reviewText);
        reviewAlbum.setCoesao(coesao);
        return reviewAlbum;
    }


    public void initComponents() {
        // Configurações gerais da janela
        setTitle("Echo - Review");
        setSize(600, 400);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createImagePainel(), BorderLayout.NORTH);
        add(createTextPanel(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createImagePainel() {
        JPanel imagePanel = new JPanel();
        ImageIcon image = new ImageIcon(album.getLinkCapa());
        JLabel imageLabel = new JLabel(image);
        imagePanel.add(imageLabel);
        return imagePanel;
    }

    private JPanel createTextPanel() {
        // Painel para os campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout()); 

        // Primeira caixa de texto
        JLabel label1 = new JLabel("Nota:");
        textField1 = new JTextField();

        // Segunda caixa de texto
        JLabel label2 = new JLabel("Coesão:");
        textField2 = new JTextField();

        // Caixa de texto de várias linhas
        JLabel label3 = new JLabel("Review:");
        textField3 = new JTextArea();
        textField3.setLineWrap(true);
        textField3.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textField3);

        // Botão para salvar os textos
        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(e -> saveText());

        // Adiciona os componentes ao painel de texto
        textPanel.add(label1);
        textPanel.add(textField1);
        textPanel.add(label2);
        textPanel.add(textField2);
        textPanel.add(label3);
        textPanel.add(scrollPane);

        return textPanel;
    }

    private void saveText() {
        nota = Integer.parseInt(textField1.getText());
        coesao = Integer.parseInt(textField2.getText());
        reviewText = textField3.getText();

    }

}
