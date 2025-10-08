package service;

import model.DAO.ModeloMySQL;
import model.bo.Modelo;

import java.util.List;

public class ModeloService {
    public static void criar(Modelo modelo) {
        ModeloMySQL modeloMySQL = new ModeloMySQL();
        modeloMySQL.inserir(modelo);
    }

    public static Modelo carregar(int id) {

        ModeloMySQL modeloMySQL = new ModeloMySQL();
        return modeloMySQL.buscar(id);
    }

    public static List<Modelo> carregar(String atributo, String valor) {
        ModeloMySQL modeloMySQL = new ModeloMySQL();
        return modeloMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Modelo modelo) {
        ModeloMySQL modeloMySQL = new ModeloMySQL();
        modeloMySQL.atualizar(modelo);
    }

    public static void apagar(Modelo modelo) {
        ModeloMySQL modeloMySQL = new ModeloMySQL();
        modeloMySQL.deletar(modelo);
    }
}
