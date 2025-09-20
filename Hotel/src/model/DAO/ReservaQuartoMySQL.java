/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.ReservaQuarto;

/**
 *
 * @author GABRIEL
 */
public class ReservaQuartoMySQL implements Persistencia <ReservaQuarto>{

    @Override
    public void inserir(ReservaQuarto reservaQuarto) {

    }

    @Override
    public List<ReservaQuarto> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(ReservaQuarto reservaQuarto) {

    }

    @Override
    public void deletar(ReservaQuarto reservaQuarto) {
        
    }

    @Override
    public ReservaQuarto buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
