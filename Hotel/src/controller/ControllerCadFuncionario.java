/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaFuncionario;
import view.TelaBuscaHospede;
import view.TelaCadastroFuncionario;

public class ControllerCadFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;

    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;
        this.telaCadastroFuncionario.getjButtonNovo().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonSair().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonGravar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonBuscar()) {
            TelaBuscaFuncionario fun = new TelaBuscaFuncionario(null,true);
            ControllerBuscaFuncionario contr = new ControllerBuscaFuncionario(fun);
            fun.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonSair()) {
            this.telaCadastroFuncionario.dispose();
        }

    }

}
