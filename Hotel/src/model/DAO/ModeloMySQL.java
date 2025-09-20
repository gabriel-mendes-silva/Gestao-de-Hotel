/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Modelo;

/**
 *
 * @author GABRIEL
 */
public class ModeloMySQL implements Persistencia <Modelo>{

    @Override
    public void inserir(Modelo modelo) {

    }

    @Override
    public List<Modelo> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Modelo modelo) {

    }

    @Override
    public void deletar(Modelo modelo) {

    }

    @Override
    public Modelo buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
