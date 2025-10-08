/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilities.FornecedorBuilder;

/**
 *
 * @author GABRIEL
 */
public class FornecedorMySQL implements Persistencia <Fornecedor>{

     @Override
    public void inserir(Fornecedor fornecedor) {

        String sql = "INSERT INTO fornecedor ("
                + "NOME, "
                + "FONE, "
                + "FONE2, "
                + "EMAIL, "
                + "CEP, "
                + "LOGRADOURO, "
                + "BAIRRO, "
                + "CIDADE, "
                + "COMPLEMENTO, "
                + "DATA_CADASTRO,"
                + "CPF, "
                + "RG, "
                + "OBS, "
                + "STATUS, "
                + "RAZAO_SOCIAL, "
                + "CNPJ, "
                + "INSCRICAO_ESTADUAL, "
                + "CONTATO) VALUES (?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y')"
                + ",?,?,?,?,?,?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getFone1());
            stmt.setString(3, fornecedor.getFone2());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getLogradouro());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getCidade());
            stmt.setString(9, fornecedor.getComplemento());
            stmt.setString(10, fornecedor.getDataCadastro());
            stmt.setString(11, fornecedor.getCpf());
            stmt.setString(12, fornecedor.getRg());
            stmt.setString(13, fornecedor.getObs());
            stmt.setString(14, String.valueOf(fornecedor.getStatus()));
            stmt.setString(15, fornecedor.getRazaoSocial());
            stmt.setString(16, fornecedor.getCnpj());
            stmt.setString(17, fornecedor.getInscricaoEstadual());
            stmt.setString(18, fornecedor.getContato());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Fornecedor buscar(int id) {

        String sql = "SELECT "
                + " ID,"
                + " NOME,"
                + " FONE,"
                + " FONE2,"
                + " EMAIL,"
                + " CEP,"
                + " LOGRADOURO,"
                + " BAIRRO,"
                + " CIDADE,"
                + " COMPLEMENTO,"
                + " DATE_FORMAT(DATA_CADASTRO, '%d/%m/%Y') AS DATA_CADASTRO,"
                + " CPF,"
                + " RG,"
                + " OBS,"
                + " STATUS,"
                + " RAZAO_SOCIAL,"
                + " CNPJ,"
                + " INSCRICAO_ESTADUAL,"
                + " CONTATO"
                + " FROM fornecedor"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Fornecedor fornecedor = new FornecedorBuilder()
                            .setId(resultSet.getInt("ID"))
                            .setNome(resultSet.getString("NOME"))
                            .setTelefone(resultSet.getString("FONE"))
                            .setTelefoneReserva(resultSet.getString("FONE2"))
                            .setEmail(resultSet.getString("EMAIL"))
                            .setCep(resultSet.getString("CEP"))
                            .setLogradouro(resultSet.getString("LOGRADOURO"))
                            .setBairro(resultSet.getString("BAIRRO"))
                            .setCidade(resultSet.getString("CIDADE"))
                            .setComplemento(resultSet.getString("COMPLEMENTO"))
                            .setDataCadastro(resultSet.getString("DATA_CADASTRO"))
                            .setCpf(resultSet.getString("CPF"))
                            .setRg(resultSet.getString("RG"))
                            .setObs(resultSet.getString("OBS"))
                            .setStatus(resultSet.getString("STATUS").charAt(0))
                            .setRazaoSocial(resultSet.getString("RAZAO_SOCIAL"))
                            .setCnpj(resultSet.getString("CNPJ"))
                            .setInscricaoEstadual(resultSet.getString("INSCRICAO_ESTADUAL"))
                            .setContato(resultSet.getString("CONTATO"))
                            .build();

                    return fornecedor;
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
    public List<Fornecedor> buscar(String atributo, String valor) {
        ArrayList<Fornecedor> fornecedors = new ArrayList<>();

        String sql = "SELECT "
                + " ID,"
                + " NOME,"
                + " FONE,"
                + " FONE2,"
                + " EMAIL,"
                + " CEP,"
                + " LOGRADOURO,"
                + " BAIRRO,"
                + " CIDADE,"
                + " COMPLEMENTO,"
                + " DATE_FORMAT(DATA_CADASTRO, '%d/%m/%Y') AS DATA_CADASTRO,"
                + " CPF,"
                + " RG,"
                + " OBS,"
                + " STATUS,"
                + " RAZAO_SOCIAL,"
                + " CNPJ,"
                + " INSCRICAO_ESTADUAL,"
                + " CONTATO"
                + " FROM fornecedor"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Fornecedor fornecedor = new FornecedorBuilder()
                            .setId(resultSet.getInt("ID"))
                            .setNome(resultSet.getString("NOME"))
                            .setTelefone(resultSet.getString("FONE"))
                            .setTelefoneReserva(resultSet.getString("FONE2"))
                            .setEmail(resultSet.getString("EMAIL"))
                            .setCep(resultSet.getString("CEP"))
                            .setLogradouro(resultSet.getString("LOGRADOURO"))
                            .setBairro(resultSet.getString("BAIRRO"))
                            .setCidade(resultSet.getString("CIDADE"))
                            .setComplemento(resultSet.getString("COMPLEMENTO"))
                            .setDataCadastro(resultSet.getString("DATA_CADASTRO"))
                            .setCpf(resultSet.getString("CPF"))
                            .setRg(resultSet.getString("RG"))
                            .setObs(resultSet.getString("OBS"))
                            .setStatus(resultSet.getString("STATUS").charAt(0))
                            .setRazaoSocial(resultSet.getString("RAZAO_SOCIAL"))
                            .setCnpj(resultSet.getString("CNPJ"))
                            .setInscricaoEstadual(resultSet.getString("INSCRICAO_ESTADUAL"))
                            .setContato(resultSet.getString("CONTATO"))
                            .build();
                    fornecedors.add(fornecedor);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return fornecedors;
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {

        String sql = "UPDATE fornecedor"
                + " SET"
                + " NOME = ?,"
                + " FONE = ?,"
                + " FONE2 = ?,"
                + " EMAIL = ?,"
                + " CEP = ?,"
                + " LOGRADOURO = ?,"
                + " BAIRRO = ?,"
                + " CIDADE = ?,"
                + " COMPLEMENTO = ?,"
                + " DATA_CADASTRO = STR_TO_DATE(?,'%d/%m/%Y'),"
                + " CPF = ?,"
                + " RG = ?,"
                + " OBS = ?,"
                + " STATUS = ?,"
                + " RAZAO_SOCIAL = ?,"
                + " CNPJ = ?,"
                + " INSCRICAO_ESTADUAL = ?,"
                + " CONTATO = ?"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getFone1());
            stmt.setString(3, fornecedor.getFone2());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getCep());
            stmt.setString(6, fornecedor.getLogradouro());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getCidade());
            stmt.setString(9, fornecedor.getComplemento());
            stmt.setString(10, fornecedor.getDataCadastro());
            stmt.setString(11, fornecedor.getCpf());
            stmt.setString(12, fornecedor.getRg());
            stmt.setString(13, fornecedor.getObs());
            stmt.setString(14, String.valueOf(fornecedor.getStatus()));
            stmt.setString(15, fornecedor.getRazaoSocial());
            stmt.setString(16, fornecedor.getCnpj());
            stmt.setString(17, fornecedor.getInscricaoEstadual());
            stmt.setString(18, fornecedor.getContato());
            stmt.setInt(19, fornecedor.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Fornecedor fornecedor) {

    }
    
}
