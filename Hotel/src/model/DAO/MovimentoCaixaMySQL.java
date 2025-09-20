/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.MovimentoCaixa;

/**
 *
 * @author GABRIEL
 */
public class MovimentoCaixaMySQL implements Persistencia <MovimentoCaixa> {

    @Override
    public void inserir(MovimentoCaixa movimentoCaixa) {

    }

    @Override
    public List<MovimentoCaixa> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(MovimentoCaixa movimentoCaixa) {

    }

    @Override
    public void deletar(MovimentoCaixa movimentoCaixa) {

    }

    @Override
    public MovimentoCaixa buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
