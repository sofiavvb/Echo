package src.main.java.model.platform;

import javax.swing.*;

import src.main.java.model.content.Artista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    public static Connection conectaBanco(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/nomedobanco", "usuario", "senha");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "CONEXAO" + e.getMessage());

        }
        return conexao;
    }

    public Artista buscarArtistaPorNome(String nome) {
        Artista artista = null;
        String sql = "SELECT * FROM Artistas WHERE nome = ?";
        try (Connection conexao = conectaBanco(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar artista: " + e.getMessage());
        }
        return artista;
    }

}
