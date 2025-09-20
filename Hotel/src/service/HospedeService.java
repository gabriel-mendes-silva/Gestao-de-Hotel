/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.HospedeMySQL;
import model.bo.Hospede;

/**
 *
 * @author GABRIEL
 */
public class HospedeService{
       public static void criar(Hospede objeto) {
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        hospedeMySQL.inserir(objeto);
    }

    public static Hospede carregar(int id) {

        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        return hospedeMySQL.buscar(id);
    }

    public static List<Hospede> carregar(String atributo, String valor) {
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        return hospedeMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Hospede objeto) {
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        hospedeMySQL.atualizar(objeto);
    }

    public static void apagar(Hospede objeto) {
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        hospedeMySQL.deletar(objeto);
    }
}
