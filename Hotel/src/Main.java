
import controller.ControllerCadModelo;
import java.util.ArrayList;
import java.util.List;
import model.DAO.FornecedorMySQL;
import model.DAO.FuncionarioMySQL;
import model.DAO.HospedeMySQL;
import model.DAO.MarcaMySQL;
import model.DAO.ModeloMySQL;
import model.DAO.VeiculoMySQL;
import model.bo.Fornecedor;
import model.bo.Funcionario;
import model.bo.Hospede;
import model.bo.Marca;
import model.bo.Modelo;
import model.bo.SexoNullable;
import model.bo.SexoValido;
import model.bo.Veiculo;
import utilities.HospedeBuilder;
import view.TelaCadastroHospede;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author GABRIEL
 */
public class Main {

    public static void main(String[] args) {

        // Instanciando a classe MarcaMySQL
    
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        System.out.println(hospedeMySQL.buscar(11));
        /*

        MarcaMySQL marcaDAO = new MarcaMySQL();
        ModeloMySQL modeloDAO = new ModeloMySQL();
        VeiculoMySQL veiculoDAO = new VeiculoMySQL();
        HospedeMySQL hospedeDAO = new HospedeMySQL();
        FuncionarioMySQL funcionarioDAO = new FuncionarioMySQL();
        FornecedorMySQL fornecedorDAO = new FornecedorMySQL();


        Veiculo veiculo = new Veiculo();
        veiculo.setCor("Vermelho");
        veiculo.setModelo(modeloDAO.buscar(2));
        veiculo.setPlaca("1234567");
        veiculo.setStatus('A');
        veiculo.setHospede(hospedeDAO.buscar(14));

        veiculoDAO.inserir(veiculo);

        List<Modelo> modelos = new ArrayList<>();
        modelos = modeloDAO.buscar("descricao", "Sedan");
        System.out.println(modelos);
        
        Modelo modelo2 = modeloDAO.buscar(2);
        modelo2.setDescricao("SUV");
        modeloDAO.atualizar(modelo2);
*/
        
        
        

    }
}
