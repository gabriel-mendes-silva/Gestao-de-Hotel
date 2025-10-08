/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Modelo;
import model.bo.Modelo;

/**
 *
 * @author GABRIEL
 */
public class ModeloMySQL implements Persistencia<Modelo> {

    @Override
    public void inserir(Modelo modelo) {

        String sql = "INSERT INTO modelo ("
                + " DESCRICAO,"
                + " STATUS,"
                + " MARCA_ID) VALUES (?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, modelo.getDescricao());
            stmt.setString(2, String.valueOf(modelo.getStatus()));
            stmt.setInt(3, modelo.getMarca().getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Modelo buscar(int id) {

        String sql = "SELECT"
                + " ID,"
                + " DESCRICAO,"
                + " STATUS,"
                + " MARCA_ID"
                + " FROM modelo"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Modelo modelo = new Modelo(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getString("STATUS").charAt(0),
                            new MarcaMySQL().buscar(resultSet.getInt("MARCA_ID"))
                    );

                    return modelo;
                } else {
                    return null;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Modelo> buscar(String atributo, String valor) {
        ArrayList<Modelo> modelos = new ArrayList<>();

        String sql = "SELECT"
                + " ID,"
                + " DESCRICAO,"
                + " STATUS,"
                + " MARCA_ID"
                + " FROM modelo"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Modelo modelo = new Modelo(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getString("STATUS").charAt(0),
                            new MarcaMySQL().buscar(resultSet.getInt("MARCA_ID"))
                    );
                    modelos.add(modelo);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return modelos;
    }

    @Override
    public void atualizar(Modelo modelo) {

        String sql = "UPDATE modelo"
                + " SET"
                + " DESCRICAO = ?,"
                + " STATUS = ?,"
                + " MARCA_ID = ?"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, modelo.getDescricao());
            stmt.setString(2, String.valueOf(modelo.getStatus()));
            stmt.setInt(3, modelo.getMarca().getId());
            stmt.setInt(4, modelo.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Modelo modelo) {

    }

}
