/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Veiculo {

    private int id;
    private String placa;
    private String cor;
    private Modelo modelo;

    public Veiculo() {
    }

    public Veiculo(int id, String placa, String cor, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
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

    @Override
    public String toString() {
        return "Id = " + this.getId()
                + "\nModelo = " + this.getModelo()
                + "\nCor = " + this.getCor() 
                + "\nPlaca = " + this.getPlaca();
                
    }

}
