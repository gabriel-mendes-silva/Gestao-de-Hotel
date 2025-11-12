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
import model.bo.Quarto;

/**
 *
 * @author GABRIEL
 */

public class QuartoMySQL implements Persistencia<Quarto> {

    @Override
    public void inserir(Quarto quarto) {
        String sql = "INSERT INTO quarto ("
                + "DESCRICAO, "
                + "CAPACIDADE_HOSPEDES, "
                + "METRAGEM, "
                + "IDENTIFICACAO, "
                + "ANDAR, "
                + "FLAG_ANIMAIS, "
                + "OBS, "
                + "STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, quarto.getDescricao());
            stmt.setInt(2, quarto.getCapacidadeHospedes());
            stmt.setFloat(3, quarto.getMetragem());
            stmt.setString(4, quarto.getIdentificacao());
            stmt.setInt(5, quarto.getAndar());
            stmt.setBoolean(6, quarto.isFlagAnimais());
            stmt.setString(7, quarto.getObs());
            stmt.setString(8, String.valueOf(quarto.getStatus()));

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Quarto buscar(int id) {
        String sql = "SELECT "
                + "ID, "
                + "DESCRICAO, "
                + "CAPACIDADE_HOSPEDES, "
                + "METRAGEM, "
                + "IDENTIFICACAO, "
                + "ANDAR, "
                + "FLAG_ANIMAIS, "
                + "OBS, "
                + "STATUS "
                + "FROM quarto "
                + "WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Quarto quarto = new Quarto(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getInt("CAPACIDADE_HOSPEDES"),
                            resultSet.getFloat("METRAGEM"),
                            resultSet.getString("IDENTIFICACAO"),
                            resultSet.getInt("ANDAR"),
                            resultSet.getBoolean("FLAG_ANIMAIS"),
                            resultSet.getString("OBS"),
                            resultSet.getString("STATUS").charAt(0)
                    );
                    return quarto;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Quarto> buscar(String atributo, String valor) {
        ArrayList<Quarto> quartos = new ArrayList<>();

        String sql = "SELECT "
                + "ID, "
                + "DESCRICAO, "
                + "CAPACIDADE_HOSPEDES, "
                + "METRAGEM, "
                + "IDENTIFICACAO, "
                + "ANDAR, "
                + "FLAG_ANIMAIS, "
                + "OBS, "
                + "STATUS "
                + "FROM quarto "
                + "WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Quarto quarto = new Quarto(
                            resultSet.getInt("ID"),
                            resultSet.getString("DESCRICAO"),
                            resultSet.getInt("CAPACIDADE_HOSPEDES"),
                            resultSet.getFloat("METRAGEM"),
                            resultSet.getString("IDENTIFICACAO"),
                            resultSet.getInt("ANDAR"),
                            resultSet.getBoolean("FLAG_ANIMAIS"),
                            resultSet.getString("OBS"),
                            resultSet.getString("STATUS").charAt(0)
                    );
                    quartos.add(quarto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return quartos;
    }

    @Override
    public void atualizar(Quarto quarto) {
        String sql = "UPDATE quarto SET "
                + "DESCRICAO = ?, "
                + "CAPACIDADE_HOSPEDES = ?, "
                + "METRAGEM = ?, "
                + "IDENTIFICACAO = ?, "
                + "ANDAR = ?, "
                + "FLAG_ANIMAIS = ?, "
                + "OBS = ?, "
                + "STATUS = ? "
                + "WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, quarto.getDescricao());
            stmt.setInt(2, quarto.getCapacidadeHospedes());
            stmt.setFloat(3, quarto.getMetragem());
            stmt.setString(4, quarto.getIdentificacao());
            stmt.setInt(5, quarto.getAndar());
            stmt.setBoolean(6, quarto.isFlagAnimais());
            stmt.setString(7, quarto.getObs());
            stmt.setString(8, String.valueOf(quarto.getStatus()));
            stmt.setInt(9, quarto.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletar(Quarto quarto) {

    }
}