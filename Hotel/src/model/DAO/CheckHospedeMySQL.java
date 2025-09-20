/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.List;
import model.bo.CheckHospede;

/**
 *
 * @author GABRIEL
 */
public class CheckHospedeMySQL implements Persistencia <CheckHospede>{

    @Override
    public void inserir(CheckHospede checkHospede) {

    }

    @Override
    public List<CheckHospede> buscar(String atributo, String valor) {
        return null;
    }

    @Override
    public void atualizar(CheckHospede checkHospede) {

    }

    @Override
    public void deletar(CheckHospede checkHospede) {

    }

    @Override
    public CheckHospede buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
