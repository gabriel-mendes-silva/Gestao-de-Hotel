
import controller.ControllerCadModelo;
import model.DAO.HospedeMySQL;
import model.bo.Hospede;
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
        HospedeMySQL hospedeMySQL = new HospedeMySQL();
        /*
        Hospede hospede = new HospedeBuilder()
            .setId(1)
            .setNome("João da Silva")
            .setTelefone("11999998888")
            .setTelefoneReserva("11888887777")
            .setEmail("joao.silva@email.com")
            .setCep("01234-567")
            .setLogradouro("Rua das Flores, 123")
            .setBairro("Centro")
            .setCidade("São Paulo")
            .setComplemento("Apto 45")
            .setDataCadastro("2025-09-15")
            .setCpf("123.456.789-00")
            .setRg("12.345.678-9")
            .setObs("Cliente VIP")
            .setStatus('A') // Ativo
            .setRazaoSocial("João da Silva ME")
            .setCnpj("12.345.678/0001-99")
            .setInscricaoEstadual("1234567890")
            .setContato("Maria Fernanda")
            .build();
        
        hospedeMySQL.inserir(hospede);*/
        Hospede hospede = hospedeMySQL.buscar(12);
        System.out.println(hospede);

    

    }
}
