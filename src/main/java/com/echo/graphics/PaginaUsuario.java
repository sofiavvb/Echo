package com.echo.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PaginaUsuario extends JFrame {
    public PaginaUsuario() {
        // Configuração da janela
        setTitle("Echo - Página do Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
 
        initComponents();

    }

    public void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());

        // Adição de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 50, 50, 50);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Label 1
        JLabel label1 = new JLabel("Página do usuário");
        panel.add(label1, gbc);

        // Foto de perfil
         try {
            BufferedImage originalImage = ImageIO.read(new File("fotoGato.jpg"));
            JLabel imageLabel = new JLabel(new ImageIcon(getCircularImage(originalImage)));
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            panel.add(imageLabel, gbc);

            // Adicionar o nome ao lado da imagem
            JLabel nameLabel = new JLabel("Gato com oculos");
            gbc.gridx = 1; // Coluna 1
            gbc.gridy = 1; // Linha 0
            gbc.anchor = GridBagConstraints.WEST; // Alinhar à esquerda
            panel.add(nameLabel, gbc);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Albuns favoritos
        JLabel label2 = new JLabel("Albuns Favoritos");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(label2, gbc);


        // Albuns avaliados
        JLabel label3 = new JLabel("Biblioteca");
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(label3, gbc);


        add(panel);


    }

    private BufferedImage getCircularImage(BufferedImage originalImage) {
        int diameter = Math.min(originalImage.getWidth(), originalImage.getHeight()) / 2;
        BufferedImage mask = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, diameter, diameter);
        g2d.dispose();

        BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = circularImage.createGraphics();
        g2d.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, diameter, diameter));
        int x = (diameter - originalImage.getWidth()) / 2;
        int y = (diameter - originalImage.getHeight()) / 2;
        g2d.drawImage(originalImage, x, y, null);
        g2d.dispose();

        return circularImage;
    }
    public static void main(String[] args) {
        // Criação e exibição da janela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaginaUsuario().setVisible(true);
            }
        });

    }
    
}
