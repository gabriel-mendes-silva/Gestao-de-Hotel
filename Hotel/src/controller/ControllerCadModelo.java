/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaHospede;
import view.TelaBuscaModelo;
import view.TelaCadastroModelo;

public class ControllerCadModelo implements ActionListener {

    TelaCadastroModelo telaCadastroModelo;

    public ControllerCadModelo(TelaCadastroModelo telaCadastroModelo) {
        this.telaCadastroModelo = telaCadastroModelo;
        this.telaCadastroModelo.getjButtonNovo().addActionListener(this);
        this.telaCadastroModelo.getjButtonSair().addActionListener(this);
        this.telaCadastroModelo.getjButtonGravar().addActionListener(this);
        this.telaCadastroModelo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroModelo.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroModelo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroModelo.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroModelo.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroModelo.getjButtonBuscar()) {
            TelaBuscaModelo busca = new TelaBuscaModelo(null,true);
            ControllerBuscaModelo contr = new ControllerBuscaModelo(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroModelo.getjButtonSair()) {
            this.telaCadastroModelo.dispose();
        }

    }

}
