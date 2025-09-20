/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Receber;

/**
 *
 * @author GABRIEL
 */
public class ReceberMySQL implements Persistencia<Receber> {

    @Override
    public void inserir(Receber receber) {

    }

    @Override
    public List<Receber> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Receber receber) {

    }

    @Override
    public void deletar(Receber receber) {

    }

    @Override
    public Receber buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
