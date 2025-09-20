/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Fornecedor;

/**
 *
 * @author GABRIEL
 */
public class FornecedorMySQL implements Persistencia <Fornecedor>{

    @Override
    public void inserir(Fornecedor fornecedor) {

    }

    @Override
    public List<Fornecedor> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {

    }

    @Override
    public void deletar(Fornecedor fornecedor) {

    }

    @Override
    public Fornecedor buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
