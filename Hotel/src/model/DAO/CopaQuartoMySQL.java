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
import model.bo.CopaQuarto;
import model.bo.CopaQuarto;
import model.bo.CopaQuarto;
import model.bo.SexoEmpty;
import model.bo.SexoValido;
import utilities.CopaQuartoBuilder;

/**
 *
 * @author GABRIEL
 */
public class CopaQuartoMySQL implements Persistencia <CopaQuarto>{
 @Override
    public void inserir(CopaQuarto copaQuarto) {

        String sql = "INSERT INTO COPA_QUARTO ("
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

            stmt.setString(1, copaQuarto.getNome());
            stmt.setString(2, copaQuarto.getFone1());
            stmt.setString(3, copaQuarto.getFone2());
            stmt.setString(4, copaQuarto.getEmail());
            stmt.setString(5, copaQuarto.getCep());
            stmt.setString(6, copaQuarto.getLogradouro());
            stmt.setString(7, copaQuarto.getBairro());
            stmt.setString(8, copaQuarto.getCidade());
            stmt.setString(9, copaQuarto.getComplemento());
            stmt.setString(10, copaQuarto.getDataCadastro());
            stmt.setString(11, copaQuarto.getCpf());
            stmt.setString(12, copaQuarto.getRg());
            stmt.setString(13, copaQuarto.getObs());
            stmt.setString(14, String.valueOf(copaQuarto.getStatus()));
            stmt.setString(15, copaQuarto.getRazaoSocial());
            stmt.setString(16, copaQuarto.getCnpj());
            stmt.setString(17, copaQuarto.getInscricaoEstadual());
            stmt.setString(18, copaQuarto.getContato());
            stmt.setString(19, copaQuarto.getSexo());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public CopaQuarto buscar(int id) {

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
                + " FROM COPA_QUARTO"
                + " WHERE ID = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, id);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    CopaQuarto copaQuarto = new CopaQuartoBuilder()
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

                    return copaQuarto;
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
    public List<CopaQuarto> buscar(String atributo, String valor) {
        ArrayList<CopaQuarto> copaQuartos = new ArrayList<>();

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
                + " FROM COPA_QUARTO"
                + " WHERE " + atributo + " LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "%" + valor + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    CopaQuarto copaQuarto = new CopaQuartoBuilder()
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
                    copaQuartos.add(copaQuarto);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return copaQuartos;
    }

    @Override
    public void atualizar(CopaQuarto copaQuarto) {

        String sql = "UPDATE COPA_QUARTO"
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

            stmt.setString(1, copaQuarto.getNome());
            stmt.setString(2, copaQuarto.getFone1());
            stmt.setString(3, copaQuarto.getFone2());
            stmt.setString(4, copaQuarto.getEmail());
            stmt.setString(5, copaQuarto.getCep());
            stmt.setString(6, copaQuarto.getLogradouro());
            stmt.setString(7, copaQuarto.getBairro());
            stmt.setString(8, copaQuarto.getCidade());
            stmt.setString(9, copaQuarto.getComplemento());
            stmt.setString(10, copaQuarto.getDataCadastro());
            stmt.setString(11, copaQuarto.getCpf());
            stmt.setString(12, copaQuarto.getRg());
            stmt.setString(13, copaQuarto.getObs());
            stmt.setString(14, String.valueOf(copaQuarto.getStatus()));
            stmt.setString(15, copaQuarto.getRazaoSocial());
            stmt.setString(16, copaQuarto.getCnpj());
            stmt.setString(17, copaQuarto.getInscricaoEstadual());
            stmt.setString(18, copaQuarto.getContato());
            stmt.setString(19, copaQuarto.getSexo());
            stmt.setInt(20, copaQuarto.getId());

            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deletar(CopaQuarto copaQuarto) {

    }
    
}
