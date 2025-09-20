/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.CheckQuarto;

/**
 *
 * @author GABRIEL
 */
public class CheckQuartoMySQL implements Persistencia <CheckQuarto>{

    @Override
    public void inserir(CheckQuarto checkQuarto) {

    }

    @Override
    public List<CheckQuarto> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(CheckQuarto checkQuarto) {

    }

    @Override
    public void deletar(CheckQuarto checkQuarto) {

    }

    @Override
    public CheckQuarto buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
