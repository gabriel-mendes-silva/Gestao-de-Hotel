package service;

import model.DAO.VagaEstacionamentoMySQL;
import model.bo.VagaEstacionamento;

import java.util.List;

public class VagaEstacionamentoService {
    public static void criar(VagaEstacionamento vagaEstacionamento) {
        VagaEstacionamentoMySQL vagaEstacionamentoMySQL = new VagaEstacionamentoMySQL();
        vagaEstacionamentoMySQL.inserir(vagaEstacionamento);
    }

    public static VagaEstacionamento carregar(int id) {

        VagaEstacionamentoMySQL vagaEstacionamentoMySQL = new VagaEstacionamentoMySQL();
        return vagaEstacionamentoMySQL.buscar(id);
    }

    public static List<VagaEstacionamento> carregar(String atributo, String valor) {
        VagaEstacionamentoMySQL vagaEstacionamentoMySQL = new VagaEstacionamentoMySQL();
        return vagaEstacionamentoMySQL.buscar(atributo, valor);
    }

    public static void atualizar(VagaEstacionamento vagaEstacionamento) {
        VagaEstacionamentoMySQL vagaEstacionamentoMySQL = new VagaEstacionamentoMySQL();
        vagaEstacionamentoMySQL.atualizar(vagaEstacionamento);
    }

    public static void apagar(VagaEstacionamento vagaEstacionamento) {
        VagaEstacionamentoMySQL vagaEstacionamentoMySQL = new VagaEstacionamentoMySQL();
        vagaEstacionamentoMySQL.deletar(vagaEstacionamento);
    }
}
