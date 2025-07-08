/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaHospede;
import view.TelaBuscaVaga;
import view.TelaCadastroVaga;

public class ControllerCadVaga implements ActionListener {

    TelaCadastroVaga telaCadastroVaga;

    public ControllerCadVaga(TelaCadastroVaga telaCadastroVaga) {
        this.telaCadastroVaga = telaCadastroVaga;
        this.telaCadastroVaga.getjButtonNovo().addActionListener(this);
        this.telaCadastroVaga.getjButtonSair().addActionListener(this);
        this.telaCadastroVaga.getjButtonGravar().addActionListener(this);
        this.telaCadastroVaga.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVaga.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroVaga.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonBuscar()) {
            TelaBuscaVaga busca = new TelaBuscaVaga(null,true);
            ControllerBuscaVaga contr = new ControllerBuscaVaga(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonSair()) {
            this.telaCadastroVaga.dispose();
        }

    }

}
