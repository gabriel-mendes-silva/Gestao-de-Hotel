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
import model.bo.ProdutoCopa;

/**
 *
 * @author GABRIEL
 */
public class ProdutoCopaMySQL implements Persistencia<ProdutoCopa> {

    @Override
    public void inserir(ProdutoCopa produtoCopa) {
        String sql = "INSERT INTO produto_copa ("
                + "DESCRICAO, "
                + "VALOR, "
                + "OBS, "
                + "STATUS) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produtoCopa.getDescricao());
            stmt.setDouble(2, produtoCopa.getValor());
            stmt.setString(3, produtoCopa.getObs());
            stmt.setString(4, String.valueOf(produtoCopa.getStatus()));

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ProdutoCopa buscar(int id) {
        String sql = "SELECT "
                + "ID, "
                + "DESCRICAO, "
                + "VALOR, "
                + "OBS, "
                + "STATUS "
                + "FROM produto_copa "
                + "WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    ProdutoCopa produto = new ProdutoCopa(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getFloat("VALOR"),
                            resultSet.getString("Obs"),
                            resultSet.getString("STATUS").charAt(0)
                    );
                    return produto;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ProdutoCopa> buscar(String atributo, String valor) {
        ArrayList<ProdutoCopa> produtos = new ArrayList<>();

        String sql = "SELECT "
                + "ID, "
                + "DESCRICAO, "
                + "VALOR, "
                + "OBS, "
                + "STATUS "
                + "FROM produto_copa "
                + "WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    ProdutoCopa produto = new ProdutoCopa(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getFloat("VALOR"),
                            resultSet.getString("Obs"),
                            resultSet.getString("STATUS").charAt(0)
                    );

                    produtos.add(produto);

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return produtos;
    }

    @Override
    public void atualizar(ProdutoCopa produtoCopa) {
        String sql = "UPDATE produto_copa SET "
                + "DESCRICAO = ?, "
                + "VALOR = ?, "
                + "OBS = ?, "
                + "STATUS = ? "
                + "WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, produtoCopa.getDescricao());
            stmt.setDouble(2, produtoCopa.getValor());
            stmt.setString(3, produtoCopa.getObs());
            stmt.setString(4, String.valueOf(produtoCopa.getStatus()));
            stmt.setInt(5, produtoCopa.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletar(ProdutoCopa produtoCopa) {

    }
}