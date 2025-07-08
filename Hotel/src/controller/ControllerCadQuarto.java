/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;

public class ControllerCadQuarto implements ActionListener {

    TelaCadastroQuarto telaCadastroQuarto;

    public ControllerCadQuarto(TelaCadastroQuarto telaCadastroQuarto) {
        this.telaCadastroQuarto = telaCadastroQuarto;
        this.telaCadastroQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadastroQuarto.getjButtonSair().addActionListener(this);
        this.telaCadastroQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroQuarto.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {
            TelaBuscaQuarto busca = new TelaBuscaQuarto(null,true);
            ControllerBuscaQuarto contr = new ControllerBuscaQuarto(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();
        }

    }

}
