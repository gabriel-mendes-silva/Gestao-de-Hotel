/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bo.SexoEmpty;
import model.bo.SexoNullable;
import model.bo.SexoValido;
import utilities.HospedeBuilder;

/**
 *
 * @author GABRIEL
 */
public class HospedeMySQL implements Persistencia<Hospede> {

    @Override
    public void inserir(Hospede hospede) {

        String sql = "INSERT INTO HOSPEDE ("
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
                + "CONTATO, "
                + "SEXO) VALUES (?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y')"
                + ",?,?,?,?,?,?,?,?,?)";

        try (Connection conexao = ConnectionFactory.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getFone1());
            stmt.setString(3, hospede.getFone2());
            stmt.setString(4, hospede.getEmail());
            stmt.setString(5, hospede.getCep());
            stmt.setString(6, hospede.getLogradouro());
            stmt.setString(7, hospede.getBairro());
            stmt.setString(8, hospede.getCidade());
            stmt.setString(9, hospede.getComplemento());
            stmt.setString(10, hospede.getDataCadastro());
            stmt.setString(11, hospede.getCpf());
            stmt.setString(12, hospede.getRg());
            stmt.setString(13, hospede.getObs());
            stmt.setString(14, String.valueOf(hospede.getStatus()));
            stmt.setString(15, hospede.getRazaoSocial());
            stmt.setString(16, hospede.getCnpj());
            stmt.setString(17, hospede.getInscricaoEstadual());
            stmt.setString(18, hospede.getContato());
            stmt.setString(19, hospede.getSexo());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Hospede buscar(int id) {

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
                + " DATA_CADASTRO,"
                + " CPF,"
                + " RG,"
                + " OBS,"
                + " STATUS,"
                + " RAZAO_SOCIAL,"
                + " CNPJ,"
                + " INSCRICAO_ESTADUAL,"
                + " CONTATO,"
                + " SEXO"
                + " FROM HOSPEDE"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    Hospede hospede = new HospedeBuilder()
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
                            .setSexo(
                                    new SexoEmpty(
                                            new SexoValido(resultSet.getString("SEXO")
                                            )
                                    )
                            )
                            .build();

                    return hospede;
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
    public List<Hospede> buscar(String atributo, String valor) {
        ArrayList<Hospede> hospedes = new ArrayList<>();

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
                + " DATA_CADASTRO,"
                + " CPF,"
                + " RG,"
                + " OBS,"
                + " STATUS,"
                + " RAZAO_SOCIAL,"
                + " CNPJ,"
                + " INSCRICAO_ESTADUAL,"
                + " CONTATO,"
                + " SEXO"
                + " FROM HOSPEDE"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Hospede hospede = new HospedeBuilder()
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
                            .setSexo(
                                    new SexoEmpty(
                                            new SexoValido(resultSet.getString("SEXO")
                                            )
                                    )
                            )
                            .build();
                    hospedes.add(hospede);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return hospedes;
    }

    @Override
    public void atualizar(Hospede hospede) {

        String sql = "UPDATE HOSPEDE"
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
                + " DATA_CADASTRO = ?,"
                + " CPF = ?,"
                + " RG = ?,"
                + " OBS = ?,"
                + " STATUS = ?,"
                + " RAZAO_SOCIAL = ?,"
                + " CNPJ = ?,"
                + " INSCRICAO_ESTADUAL = ?,"
                + " CONTATO = ?,"
                + " SEXO = ?"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getFone1());
            stmt.setString(3, hospede.getFone2());
            stmt.setString(4, hospede.getEmail());
            stmt.setString(5, hospede.getCep());
            stmt.setString(6, hospede.getLogradouro());
            stmt.setString(7, hospede.getBairro());
            stmt.setString(8, hospede.getCidade());
            stmt.setString(9, hospede.getComplemento());
            stmt.setString(10, hospede.getDataCadastro());
            stmt.setString(11, hospede.getCpf());
            stmt.setString(12, hospede.getRg());
            stmt.setString(13, hospede.getObs());
            stmt.setString(14, String.valueOf(hospede.getStatus()));
            stmt.setString(15, hospede.getRazaoSocial());
            stmt.setString(16, hospede.getCnpj());
            stmt.setString(17, hospede.getInscricaoEstadual());
            stmt.setString(18, hospede.getContato());
            stmt.setString(19, hospede.getSexo());
            stmt.setInt(20, hospede.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(Hospede hospede) {

    }

}
