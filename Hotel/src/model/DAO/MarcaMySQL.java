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
import model.bo.Marca;
import model.bo.Marca;
import model.bo.SexoEmpty;
import model.bo.SexoValido;

/**
 *
 * @author GABRIEL
 */
public class MarcaMySQL implements Persistencia<Marca> {

    @Override
    public void inserir(Marca marca) {

        String sql = "INSERT INTO MARCA ("
                + " DESCRICAO,"
                + "STATUS) VALUES (?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, marca.getDescricao());
            stmt.setString(2, String.valueOf(marca.getStatus()));

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Marca buscar(int id) {

        String sql = "SELECT"
                + " ID,"
                + " DESCRICAO,"
                + " STATUS"
                + " FROM MARCA"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Marca marca = new Marca(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getString("STATUS").charAt(0)
                    );

                    return marca;
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
    public List<Marca> buscar(String atributo, String valor) {
        ArrayList<Marca> marcas = new ArrayList<>();

        String sql = "SELECT"
                + " ID,"
                + " DESCRICAO,"
                + " STATUS"
                + " FROM MARCA"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Marca marca = new Marca(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getString("STATUS").charAt(0)
                    );
                    marcas.add(marca);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return marcas;
    }

    @Override
    public void atualizar(Marca marca) {

        String sql = "UPDATE MARCA"
                + " SET"
                + " DESCRICAO = ?,"
                + " STATUS = ?"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            
            stmt.setString(1,marca.getDescricao());
            stmt.setString(2, String.valueOf(marca.getStatus()));
            stmt.setInt(3, marca.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Marca marca) {

    }

}
