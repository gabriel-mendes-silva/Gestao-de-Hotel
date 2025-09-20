/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Funcionario;

/**
 *
 * @author GABRIEL
 */
public class FuncionarioMySQL implements Persistencia <Funcionario>{

    @Override
    public void inserir(Funcionario funcionario) {

    }

    @Override
    public List<Funcionario> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Funcionario funcionario) {

    }

    @Override
    public void deletar(Funcionario funcionario) {

    }

    @Override
    public Funcionario buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
