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
import model.bo.Funcionario;
import model.bo.SexoEmpty;
import model.bo.SexoValido;
import utilities.FuncionarioBuilder;

/**
 *
 * @author GABRIEL
 */
public class FuncionarioMySQL implements Persistencia <Funcionario>{
@Override
    public void inserir(Funcionario funcionario) {

        String sql = "INSERT INTO FUNCIONARIO ("
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
                + "USUARIO, "
                + "SENHA,"
                + "SEXO) VALUES (?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%d/%m/%Y')"
                + ",?,?,?,?,?,?,?)";

        
        
        try(Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getFone1());
            stmt.setString(3, funcionario.getFone2());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCep());
            stmt.setString(6, funcionario.getLogradouro());
            stmt.setString(7, funcionario.getBairro());
            stmt.setString(8, funcionario.getCidade());
            stmt.setString(9, funcionario.getComplemento());
            stmt.setString(10, funcionario.getDataCadastro());
            stmt.setString(11, funcionario.getCpf());
            stmt.setString(12, funcionario.getRg());
            stmt.setString(13, funcionario.getObs());
            stmt.setString(14, String.valueOf(funcionario.getStatus()));
            stmt.setString(15, funcionario.getUsuario());
            stmt.setString(16, funcionario.getSenha());
            stmt.setString(17, funcionario.getSexo());
    

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
     @Override
    public Funcionario buscar(int id) {
        
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
                + " USUARIO,"
                + " SENHA, "
                + " SEXO"
                + " FROM FUNCIONARIO"
                + " WHERE ID = ?";
      
        
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql)){
           
            pstm.setInt(1, id);
            try(ResultSet resultSet = pstm.executeQuery()){
                if(resultSet.next()){
                    Funcionario funcionario = new FuncionarioBuilder()
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
                            .setUsuario(resultSet.getString("USUARIO"))
                            .setSenha(resultSet.getString("SENHA"))
                            .setSexo(
                                    new SexoEmpty(
                                            new SexoValido(resultSet.getString("SEXO")
                                            )
                                    )
                            )
                            .build();
                    
                    return funcionario;
                }
                else{
                    return null;
                }
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
        
    }
    
    @Override
    public List<Funcionario> buscar(String atributo, String valor) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
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
                + " USUARIO,"
                + " SENHA,"
                + " SEXO"
                + " FROM FUNCIONARIO"
                + " WHERE " + atributo + " LIKE ?";
        
        try(Connection connection = ConnectionFactory.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)){
            
            pstmt.setString(1, "%" + valor + "%");
            try(ResultSet resultSet = pstmt.executeQuery()){
                while(resultSet.next()){
                    Funcionario funcionario = new FuncionarioBuilder()
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
                            .setUsuario(resultSet.getString("USUARIO"))
                            .setSenha(resultSet.getString("SENHA"))
                            .setSexo(
                                    new SexoEmpty(
                                            new SexoValido(resultSet.getString("SEXO")
                                            )
                                    )
                            )
                            .build();
                    funcionarios.add(funcionario);
                }
            }
            
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return funcionarios;
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        
        String sql = "UPDATE FUNCIONARIO"
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
                + " USUARIO = ?,"
                + " SENHA = ?,"
                + " SEXO = ?"
                + " WHERE ID = ?";
        
        try(Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getFone1());
            stmt.setString(3, funcionario.getFone2());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCep());
            stmt.setString(6, funcionario.getLogradouro());
            stmt.setString(7, funcionario.getBairro());
            stmt.setString(8, funcionario.getCidade());
            stmt.setString(9, funcionario.getComplemento());
            stmt.setString(10, funcionario.getDataCadastro());
            stmt.setString(11, funcionario.getCpf());
            stmt.setString(12, funcionario.getRg());
            stmt.setString(13, funcionario.getObs());
            stmt.setString(14, String.valueOf(funcionario.getStatus()));
            stmt.setString(15, funcionario.getUsuario());
            stmt.setString(16, funcionario.getSenha());
            stmt.setString(17, funcionario.getSexo());
            stmt.setInt(18, funcionario.getId());
            
            stmt.execute();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
                
    }

    @Override
    public void deletar(Funcionario funcionario) {

    }
    
}
