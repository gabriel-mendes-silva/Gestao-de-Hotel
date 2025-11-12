package service;

import model.DAO.ProdutoCopaMySQL;
import model.bo.ProdutoCopa;

import java.util.List;


public class ProdutoService {
    public static void criar(ProdutoCopa produto) {
        ProdutoCopaMySQL produtoMySQL = new ProdutoCopaMySQL();
        produtoMySQL.inserir(produto);
    }

    public static ProdutoCopa carregar(int id) {

        ProdutoCopaMySQL produtoMySQL = new ProdutoCopaMySQL();
        return produtoMySQL.buscar(id);
    }

    public static List<ProdutoCopa> carregar(String atributo, String valor) {
        ProdutoCopaMySQL produtoMySQL = new ProdutoCopaMySQL();
        return produtoMySQL.buscar(atributo, valor);
    }

    public static void atualizar(ProdutoCopa produto) {
        ProdutoCopaMySQL produtoMySQL = new ProdutoCopaMySQL();
        produtoMySQL.atualizar(produto);
    }

    public static void apagar(ProdutoCopa produto) {
        ProdutoCopaMySQL produtoMySQL = new ProdutoCopaMySQL();
        produtoMySQL.deletar(produto);
    }
}


