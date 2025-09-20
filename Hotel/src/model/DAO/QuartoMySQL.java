/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Quarto;

/**
 *
 * @author GABRIEL
 */
public class QuartoMySQL implements Persistencia <Quarto>{

    @Override
    public void inserir(Quarto quarto) {

    }

    @Override
    public List<Quarto> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Quarto quarto) {

    }

    @Override
    public void deletar(Quarto quarto) {

    }

    @Override
    public Quarto buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
