/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaHospede;
import view.TelaCadastroHospede;

public class ControllerCadHospede implements ActionListener {

    TelaCadastroHospede telaCadastroHospede;

    public ControllerCadHospede(TelaCadastroHospede telaCadastroHospede) {
        this.telaCadastroHospede = telaCadastroHospede;
        this.telaCadastroHospede.getjButtonNovo().addActionListener(this);
        this.telaCadastroHospede.getjButtonSair().addActionListener(this);
        this.telaCadastroHospede.getjButtonGravar().addActionListener(this);
        this.telaCadastroHospede.getjButtonCancelar().addActionListener(this);
        this.telaCadastroHospede.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroHospede.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonBuscar()) {
            TelaBuscaHospede busca = new TelaBuscaHospede(null,true);
            ControllerBuscaHospede contr = new ControllerBuscaHospede(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonSair()) {
            this.telaCadastroHospede.dispose();
        }

    }

}
