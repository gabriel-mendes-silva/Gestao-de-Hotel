/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Reserva;

/**
 *
 * @author GABRIEL
 */
public class ReservaMySQL implements Persistencia <Reserva>{

    @Override
    public void inserir(Reserva reserva) {

    }

    @Override
    public List<Reserva> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Reserva reserva) {

    }

    @Override
    public void deletar(Reserva reserva) {

    }

    @Override
    public Reserva buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
