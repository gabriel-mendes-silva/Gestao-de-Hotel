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
import view.TelaBuscaVeiculo;
import view.TelaCadastroVeiculo;

public class ControllerCadVeiculo implements ActionListener {

    TelaCadastroVeiculo telaCadastroVeiculo;

    public ControllerCadVeiculo(TelaCadastroVeiculo telaCadastroVeiculo) {
        this.telaCadastroVeiculo = telaCadastroVeiculo;
        this.telaCadastroVeiculo.getjButtonNovo().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonSair().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonGravar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);

        }
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);

        }
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        }
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonBuscar()) {
            TelaBuscaVeiculo busca = new TelaBuscaVeiculo(null,true);
            ControllerBuscaVeiculo contr = new ControllerBuscaVeiculo(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonSair()) {
            this.telaCadastroVeiculo.dispose();
        }

    }

}
