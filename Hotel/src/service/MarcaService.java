package service;

import model.DAO.MarcaMySQL;
import model.bo.Marca;

import java.util.List;

public class MarcaService {
    public static void criar(Marca marca) {
        MarcaMySQL marcaMySQL = new MarcaMySQL();
        marcaMySQL.inserir(marca);
    }

    public static Marca carregar(int id) {

        MarcaMySQL marcaMySQL = new MarcaMySQL();
        return marcaMySQL.buscar(id);
    }

    public static List<Marca> carregar(String atributo, String valor) {
        MarcaMySQL marcaMySQL = new MarcaMySQL();
        return marcaMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Marca marca) {
        MarcaMySQL marcaMySQL = new MarcaMySQL();
        marcaMySQL.atualizar(marca);
    }

    public static void apagar(Marca marca) {
        MarcaMySQL marcaMySQL = new MarcaMySQL();
        marcaMySQL.deletar(marca);
    }
}
