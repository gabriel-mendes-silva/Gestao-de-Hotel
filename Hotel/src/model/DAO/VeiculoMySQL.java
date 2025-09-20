/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Veiculo;

/**
 *
 * @author GABRIEL
 */
public class VeiculoMySQL implements Persistencia <Veiculo>{

    @Override
    public void inserir(Veiculo veiculo) {
        
    }

    @Override
    public List<Veiculo> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        
    }

    @Override
    public void deletar(Veiculo veiculo) {
        
    }

    @Override
    public Veiculo buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
