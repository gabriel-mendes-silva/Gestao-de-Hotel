/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.VagaEstacionamento;

/**
 *
 * @author GABRIEL
 */
public class VagaEstacionamentoMySQL implements Persistencia <VagaEstacionamento> {

    @Override
    public void inserir(VagaEstacionamento vagaEstacionamento) {
        
    }

    @Override
    public List<VagaEstacionamento> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(VagaEstacionamento vagaEstacionamento) {
        
    }

    @Override
    public void deletar(VagaEstacionamento vagaEstacionamento) {
        
    }

    @Override
    public VagaEstacionamento buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
