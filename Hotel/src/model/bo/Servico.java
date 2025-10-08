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
public class Servico {
   private int id;
   private String descricao;
   private String obs;
   private char status;

    public Servico() {
    }

    public Servico(int id, String descricao, String obs, char status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.obs = obs;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "id = " + id + 
                "\ndescricao = " + descricao + 
                "\nstatus = " + status;
    }
   
   
}
