/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

/**
 *
 * @author aluno
 */
public class Veiculo {

    private int id;
    private String placa;
    private String cor;
    private Modelo modelo;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private Hospede hospede;
    private char status;

    public Veiculo() {
    }

    public Veiculo(int id, String placa, String cor, Modelo modelo, Funcionario funcionario, Fornecedor fornecedor, Hospede hospede, char status) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.hospede = hospede;
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {

        if ((status == 'A') || (status == 'C') || (status == 'a') || (status == 'c')) {
            this.status = status;
        } else {
            this.status = 'A';
        }

    }

    @Override
    public String toString() {
        return "Id = " + this.getId()
                + "\nModelo = " + this.getModelo()
                + "\nCor = " + this.getCor()
                + "\nPlaca = " + this.getPlaca()
                + "Dono Fornecedor:" + this.getFornecedor().getNome() + this.getFornecedor().getCnpj();

    }

}
