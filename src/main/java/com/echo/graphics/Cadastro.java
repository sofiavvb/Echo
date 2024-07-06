package com.echo.graphics;

import javax.swing.*;
import java.awt.*;

import com.echo.model.platform.Usuario;
import com.echo.model.content.Album;
import java.util.ArrayList;

public class Cadastro extends JFrame {
    private ArrayList<Album> albums;
    public Cadastro(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void initComponents() {
        setTitle("Echo - Cadastro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());

        // Cor
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.WHITE);

        // Adição de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;

        // Logo
        panel.add(createPainelLogo());

        // Label 1
        JLabel label1 = new JLabel("Olá, Bem vindo ao Echo! Por favor, adicione as informações");
        label1.setForeground(Color.WHITE);
        panel.add(label1, gbc);

        // Nome de usuário
        JLabel label2 = new JLabel("Nome de usuário:"); 
        label2.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label2, gbc);

        // Caixa de texto nome de usuário
        JTextField textField1 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField1, gbc);

        // CPF
        JLabel label3 = new JLabel("CPF:");
        label3.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label3, gbc);

        // Caixa de texto CPF
        JTextField textField2 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField2, gbc);

        // Email
        JLabel label4 = new JLabel("Email:"); 
        label4.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(label4, gbc);

        // Caixa de texto email
        JTextField textField3 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField3, gbc);
        
        
        // Senha
        JLabel label5 = new JLabel("Senha:");
        label5.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(label5, gbc);

        // Caixa de Texto da senha
        JTextField textField4 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField4, gbc);

        // Imagem
        JLabel label6 = new JLabel("URL da foto:"); 
        label6.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(label6, gbc);

        // Caixa de Texto da imagem
        JTextField textField5 = new JTextField(20);
        gbc.gridx = 1;
        panel.add(textField5, gbc);


        JButton button = new JButton("Cadastrar-me");
        button.setBackground(new Color(200, 50, 250));
        button.setForeground(Color.BLACK);
        gbc.gridy = 6;
        panel.add(button, gbc);

        // Adição de listener para o botão
        button.addActionListener(e -> {
            String nomeUsario = textField1.getText();
            String cpf = textField2.getText();
            String email = textField3.getText();
            String senha = textField4.getText();
            String foto = textField5.getText();
            JOptionPane.showMessageDialog(Cadastro.this, "Informações Salvas!");
            setVisible(false);

            Usuario usuario = new Usuario(nomeUsario, senha, cpf, email, foto);
            PaginaUsuario paginaUsuario = new PaginaUsuario(usuario, albums);
            paginaUsuario.initUI();

        });

        add(panel);
        setVisible(true);

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

}


       
