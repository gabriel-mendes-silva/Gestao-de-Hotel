/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.DAO.FuncionarioMySQL;
import model.bo.Funcionario;

import java.util.List;

/**
 *
 * @author GABRIEL
 */
public class FuncionarioService {
    public static void criar(Funcionario objeto) {
        FuncionarioMySQL funcionarioMySQL = new FuncionarioMySQL();
        funcionarioMySQL.inserir(objeto);
    }

    public static Funcionario carregar(int id) {

        FuncionarioMySQL funcionarioMySQL = new FuncionarioMySQL();
        return funcionarioMySQL.buscar(id);
    }

    public static List<Funcionario> carregar(String atributo, String valor) {
        FuncionarioMySQL funcionarioMySQL = new FuncionarioMySQL();
        return funcionarioMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Funcionario objeto) {
        FuncionarioMySQL funcionarioMySQL = new FuncionarioMySQL();
        funcionarioMySQL.atualizar(objeto);
    }

    public static void apagar(Funcionario objeto) {
        FuncionarioMySQL funcionarioMySQL = new FuncionarioMySQL();
        funcionarioMySQL.deletar(objeto);
    }
}
