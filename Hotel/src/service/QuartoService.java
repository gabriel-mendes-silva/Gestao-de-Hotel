package service;

import model.DAO.QuartoMySQL;
import model.bo.Quarto;

import java.util.List;

public class QuartoService {
    public static void criar(Quarto quarto) {
        QuartoMySQL quartoMySQL = new QuartoMySQL();
        quartoMySQL.inserir(quarto);
    }

    public static Quarto carregar(int id) {

        QuartoMySQL quartoMySQL = new QuartoMySQL();
        return quartoMySQL.buscar(id);
    }

    public static List<Quarto> carregar(String atributo, String valor) {
        QuartoMySQL quartoMySQL = new QuartoMySQL();
        return quartoMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Quarto quarto) {
        QuartoMySQL quartoMySQL = new QuartoMySQL();
        quartoMySQL.atualizar(quarto);
    }

    public static void apagar(Quarto quarto) {
        QuartoMySQL quartoMySQL = new QuartoMySQL();
        quartoMySQL.deletar(quarto);
    }
}
