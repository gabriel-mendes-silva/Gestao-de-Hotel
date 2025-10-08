package service;

import model.DAO.FornecedorMySQL;
import model.bo.Fornecedor;

import java.util.List;

public class FornecedorService {
    public static void criar(Fornecedor objeto) {
        FornecedorMySQL fornecedorMySQL = new FornecedorMySQL();
        fornecedorMySQL.inserir(objeto);
    }

    public static Fornecedor carregar(int id) {

        FornecedorMySQL fornecedorMySQL = new FornecedorMySQL();
        return fornecedorMySQL.buscar(id);
    }

    public static List<Fornecedor> carregar(String atributo, String valor) {
        FornecedorMySQL fornecedorMySQL = new FornecedorMySQL();
        return fornecedorMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorMySQL fornecedorMySQL = new FornecedorMySQL();
        fornecedorMySQL.atualizar(objeto);
    }

    public static void apagar(Fornecedor objeto) {
        FornecedorMySQL fornecedorMySQL = new FornecedorMySQL();
        fornecedorMySQL.deletar(objeto);
    }
}
