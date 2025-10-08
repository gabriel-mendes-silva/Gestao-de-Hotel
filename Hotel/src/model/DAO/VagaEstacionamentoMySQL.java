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

import model.bo.Servico;
import model.bo.VagaEstacionamento;

/**
 *
 * @author GABRIEL
 */
public class VagaEstacionamentoMySQL implements Persistencia <VagaEstacionamento> {

    @Override
    public void inserir(VagaEstacionamento vagaEstacionamento) {
        String sql = "insert into vaga_estacionamento ("
                + "descricao, "
                + "obs, "
                + "metragem_vaga,"
                + "status) values (?,?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, vagaEstacionamento.getDescricao());
            stmt.setString(2,vagaEstacionamento.getObs());
            stmt.setDouble(3,vagaEstacionamento.getMetragemVaga());
            stmt.setString(4, String.valueOf(vagaEstacionamento.getStatus()));

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public VagaEstacionamento buscar(int id) {
        String sql = "select "
                + " id,"
                + " descricao,"
                + " obs,"
                + " metragem_vaga,"
                + " status"
                + " from vaga_estacionamento"
                + " where id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    VagaEstacionamento vaga = new VagaEstacionamento(
                            resultSet.getInt("id"),
                            resultSet.getString("descricao"),
                            resultSet.getString("obs"),
                            resultSet.getFloat("metragem_vaga"),
                            resultSet.getString("status").charAt(0)
                    );

                    return vaga;
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
    public List<VagaEstacionamento> buscar(String atributo, String valor) {
        ArrayList<VagaEstacionamento> vagas = new ArrayList<>();

        String sql = "select "
                + " id,"
                + " descricao,"
                + " metragem_vaga,"
                + " obs,"
                + " status"
                + " from vaga_estacionamento"
                + " where " + atributo + " like ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    VagaEstacionamento vaga = new VagaEstacionamento(
                            resultSet.getInt("id"),
                            resultSet.getString("descricao"),
                            resultSet.getString("obs"),
                            resultSet.getFloat("metragem_vaga"),
                            resultSet.getString("status").charAt(0)
                    );
                    vagas.add(vaga);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vagas;


    }

    @Override
    public void atualizar(VagaEstacionamento vagaEstacionamento) {
        String sql = "update vaga_estacionamento"
                + " set"
                + " descricao = ?,"
                + " obs = ?,"
                + " metragem_vaga = ?,"
                + " status = ?"
                + " where id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, vagaEstacionamento.getDescricao());
            stmt.setString(2, vagaEstacionamento.getObs());
            stmt.setFloat(3, vagaEstacionamento.getMetragemVaga());
            stmt.setString(4, String.valueOf(vagaEstacionamento.getStatus()));
            stmt.setInt(5, vagaEstacionamento.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(VagaEstacionamento vagaEstacionamento) {
        
    }


    
}
