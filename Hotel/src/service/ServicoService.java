package service;

import model.DAO.ServicoMySQL;
import model.bo.Servico;

import java.util.List;

public class ServicoService {
    public static void criar(Servico objeto) {
        ServicoMySQL servicoMySQL = new ServicoMySQL();
        servicoMySQL.inserir(objeto);
    }

    public static Servico carregar(int id) {

        ServicoMySQL servicoMySQL = new ServicoMySQL();
        return servicoMySQL.buscar(id);
    }

    public static List<Servico> carregar(String atributo, String valor) {
        ServicoMySQL servicoMySQL = new ServicoMySQL();
        return servicoMySQL.buscar(atributo, valor);
    }

    public static void atualizar(Servico objeto) {
        ServicoMySQL servicoMySQL = new ServicoMySQL();
        servicoMySQL.atualizar(objeto);
    }

    public static void apagar(Servico objeto) {
        ServicoMySQL servicoMySQL = new ServicoMySQL();
        servicoMySQL.deletar(objeto);
    }
}
