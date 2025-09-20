/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.AlocacaoVaga;

/**
 *
 * @author GABRIEL
 */
public class AlocacaoVagaMySQL implements Persistencia <AlocacaoVaga>{

    @Override
    public void inserir(AlocacaoVaga alocacaoVaga) {

    }

    @Override
    public List<AlocacaoVaga> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(AlocacaoVaga alocacaoVaga) {

    }

    @Override
    public void deletar(AlocacaoVaga alocacaoVaga) {

    }

    @Override
    public AlocacaoVaga buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
