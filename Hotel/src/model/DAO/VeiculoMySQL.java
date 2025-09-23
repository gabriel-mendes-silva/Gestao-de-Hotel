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
import model.bo.Veiculo;
import model.bo.Veiculo;

/**
 *
 * @author GABRIEL
 */
public class VeiculoMySQL implements Persistencia<Veiculo> {

    @Override
    public void inserir(Veiculo veiculo) {

        String sql = "INSERT INTO VEICULO ("
                + " PLACA,"
                + " COR,"
                + " MODELO_ID,"
                + " FUNCIONARIO_ID,"
                + " FORNECEDOR_ID,"
                + " HOSPEDE_ID,"
                + " STATUS) VALUES (?,?,?,?,?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getCor());
            stmt.setInt(3, veiculo.getModelo().getId());
            stmt.setInt(4, veiculo.getFuncionario().getId());
            stmt.setInt(5, veiculo.getFornecedor().getId());
            stmt.setInt(6, veiculo.getHospede().getId());
            stmt.setString(7, String.valueOf(veiculo.getStatus()));

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Veiculo buscar(int id) {

        String sql = "SELECT"
                + " ID,"
                + " PLACA,"
                + " COR,"
                + " MODELO_ID,"
                + " FUNCIONARIO_ID,"
                + " FORNECEDOR_ID,"
                + " HOSPEDE_ID,"
                + " STATUS"
                + " FROM VEICULO"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Veiculo veiculo = new Veiculo(
                            resultSet.getInt("ID"),
                            resultSet.getString("PLACA"),
                            resultSet.getString("COR"),
                            new ModeloMySQL().buscar(resultSet.getInt("MODELO_ID")),
                            new FuncionarioMySQL().buscar(resultSet.getInt("FUNCIONARIO_ID")),
                            new FornecedorMySQL().buscar(resultSet.getInt("FORNECEDOR_ID")),
                            new HospedeMySQL().buscar(resultSet.getInt("HOSPEDE_ID")),
                            resultSet.getString("STATUS").charAt(0)
                    );

                    return veiculo;
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
    public List<Veiculo> buscar(String atributo, String valor) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        String sql = "SELECT"
                + " ID,"
                + " PLACA,"
                + " COR,"
                + " MODELO_ID,"
                + " FUNCIONARIO_ID,"
                + " FORNECEDOR_ID,"
                + " HOSPEDE_ID,"
                + " STATUS"
                + " FROM VEICULO"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Veiculo veiculo = new Veiculo(
                            resultSet.getInt("ID"),
                            resultSet.getString("PLACA"),
                            resultSet.getString("COR"),
                            new ModeloMySQL().buscar(resultSet.getInt("MODELO_ID")),
                            new FuncionarioMySQL().buscar(resultSet.getInt("FUNCIONARIO_ID")),
                            new FornecedorMySQL().buscar(resultSet.getInt("FORNECEDOR_ID")),
                            new HospedeMySQL().buscar(resultSet.getInt("HOSPEDE_ID")),
                            resultSet.getString("STATUS").charAt(0)
                    );
                    veiculos.add(veiculo);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return veiculos;
    }

    @Override
    public void atualizar(Veiculo veiculo) {

        String sql = "UPDATE VEICULO"
                + " PLACA = ?,"
                + " COR = ?,"
                + " MODELO_ID = ?,"
                + " FUNCIONARIO_ID = ?,"
                + " FORNECEDOR_ID = ?,"
                + " HOSPEDE_ID = ?,"
                + " STATUS = ?"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getCor());
            stmt.setInt(3, veiculo.getModelo().getId());
            stmt.setInt(4, veiculo.getFuncionario().getId());
            stmt.setInt(5, veiculo.getFornecedor().getId());
            stmt.setInt(6, veiculo.getHospede().getId());
            stmt.setString(7, String.valueOf(veiculo.getStatus()));
            stmt.setInt(8, veiculo.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Veiculo veiculo) {

    }
}
