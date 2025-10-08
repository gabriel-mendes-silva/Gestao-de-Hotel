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

import model.bo.Hospede;
import model.bo.Servico;
import model.bo.SexoEmpty;
import model.bo.SexoValido;
import utilities.HospedeBuilder;

/**
 *
 * @author GABRIEL
 */
public class ServicoMySQL implements Persistencia <Servico>{

    @Override
    public void inserir(Servico servico) {
        String sql = "insert into servico ("
                + "descricao, "
                + "obs, "
                + "status) values (?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setString(2,servico.getObs());
            stmt.setString(3, String.valueOf(servico.getStatus()));

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Servico buscar(int id) {
        String sql = "select "
                + " id,"
                + " descricao,"
                + " obs,"
                + " status"
                + " from servico"
                + " where id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Servico servico = new Servico(
                            resultSet.getInt("id"),
                            resultSet.getString("descricao"),
                            resultSet.getString("obs"),
                            resultSet.getString("status").charAt(0)
                    );

                    return servico;
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
    public List<Servico> buscar(String atributo, String valor) {
        ArrayList<Servico> servicos = new ArrayList<>();

        String sql = "select "
                + " id,"
                + " descricao,"
                + " obs,"
                + " status"
                + " from servico"
                + " where " + atributo + " like ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Servico servico = new Servico(
                            resultSet.getInt("id"),
                            resultSet.getString("descricao"),
                            resultSet.getString("obs"),
                            resultSet.getString("status").charAt(0)
                    );
                    servicos.add(servico);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return servicos;

    }

    @Override
    public void atualizar(Servico servico) {
        String sql = "update servico"
                + " set"
                + " descricao = ?,"
                + " obs = ?,"
                + " status = ?"
                + " where id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setString(2, servico.getObs());
            stmt.setString(3, String.valueOf(servico.getStatus()));
            stmt.setInt(4, servico.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Servico servico) {
        
    }


    
}
