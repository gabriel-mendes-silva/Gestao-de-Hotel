/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.OrdemServico;

/**
 *
 * @author GABRIEL
 */
public class OrdemServicoMySQL implements Persistencia <OrdemServico>{

    @Override
    public void inserir(OrdemServico ordemServico) {

    }

    @Override
    public List<OrdemServico> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(OrdemServico ordemServico) {

    }

    @Override
    public void deletar(OrdemServico ordemServico) {

    }

    @Override
    public OrdemServico buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
