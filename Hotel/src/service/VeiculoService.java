package service;

import model.DAO.VeiculoMySQL;
import model.bo.Veiculo;

import java.util.List;

public class VeiculoService {
    public static void criar(Veiculo objeto) {
        VeiculoMySQL veiculoMySQL = new VeiculoMySQL();
        veiculoMySQL.inserir(objeto);
    }

    public static Veiculo carregar(int id) {

        VeiculoMySQL veiculoMySQL = new VeiculoMySQL();
        return veiculoMySQL.buscar(id);
    }

    public static List<Veiculo> carregar(String atributo, String valor) {
        VeiculoMySQL veiculoMySQL = new VeiculoMySQL();
        return veiculoMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Veiculo objeto) {
        VeiculoMySQL veiculoMySQL = new VeiculoMySQL();
        veiculoMySQL.atualizar(objeto);
    }

    public static void apagar(Veiculo objeto) {
        VeiculoMySQL veiculoMySQL = new VeiculoMySQL();
        veiculoMySQL.deletar(objeto);
    }
}
