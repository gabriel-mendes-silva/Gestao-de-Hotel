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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GABRIEL
 */
public class HospedeMySQL implements Persistencia<Hospede> {

    @Override
    public void inserir(Hospede hospede) {

        String sql = "INSERT INTO HOSPEDE (NOME, "
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
                + "CNPJ,"
                + "INSCRICAO_ESTADUAL, "
                + "CONTATO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        
        try {

            stmt = conexao.prepareStatement(sql);
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

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            ConnectionFactory.closeConnection(conexao,stmt);
        }
    }

    @Override
    public List<Hospede> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Hospede hospede) {

    }

    @Override
    public void deletar(Hospede hospede) {

    }

}
