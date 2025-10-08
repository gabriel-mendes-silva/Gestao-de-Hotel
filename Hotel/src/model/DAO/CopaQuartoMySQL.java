/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.CopaQuarto;
import model.bo.CopaQuarto;
import model.bo.CopaQuarto;
import model.bo.SexoEmpty;
import model.bo.SexoValido;


/**
 *
 * @author GABRIEL
 */
public class CopaQuartoMySQL implements Persistencia <CopaQuarto>{


    @Override
    public void inserir(CopaQuarto copaQuarto) {

    }

    @Override
    public CopaQuarto buscar(int id) {
        return null;
    }

    @Override
    public List<CopaQuarto> buscar(String atributo, String valor) {
        return List.of();
    }

    @Override
    public void atualizar(CopaQuarto copaQuarto) {

    }

    @Override
    public void deletar(CopaQuarto copaQuarto) {

    }
}
