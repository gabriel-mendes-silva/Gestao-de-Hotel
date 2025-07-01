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
public class ProdutoCopa {
    private int id;
    private String descricao;
    private float valor;
    private String obs;
    private char status;

    public ProdutoCopa() {
    }

    public ProdutoCopa(int id, String descricao, float valor, String obs, char status) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id = " + id + 
                "\ndescricao = " + descricao + 
                "\nvalor = " + valor + 
                "\nobs = " + obs + 
                "\nstatus = " + status;
    }
    
    
}
