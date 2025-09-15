/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.Check;

/**
 *
 * @author GABRIEL
 */
public class CheckMySQL implements Persistencia <Check>{

    @Override
    public void inserir(Check check) {

    }

    @Override
    public List<Check> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(Check check) {

    }

    @Override
    public void deletar(Check check) {

    }
    
}
