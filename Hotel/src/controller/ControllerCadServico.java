/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaServico;
import view.TelaCadastroServico;

public class ControllerCadServico implements ActionListener {

    TelaCadastroServico telaCadastroServico;

    public ControllerCadServico(TelaCadastroServico telaCadastroServico) {
        this.telaCadastroServico = telaCadastroServico;
        this.telaCadastroServico.getjButtonNovo().addActionListener(this);
        this.telaCadastroServico.getjButtonSair().addActionListener(this);
        this.telaCadastroServico.getjButtonGravar().addActionListener(this);
        this.telaCadastroServico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroServico.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroServico.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroServico.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroServico.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroServico.getjButtonBuscar()) {
            TelaBuscaServico busca = new TelaBuscaServico(null,true);
            ControllerBuscaServico contr = new ControllerBuscaServico(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroServico.getjButtonSair()) {
            this.telaCadastroServico.dispose();
        }

    }

}
