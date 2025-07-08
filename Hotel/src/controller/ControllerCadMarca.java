/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaMarca;
import view.TelaCadastroMarca;

public class ControllerCadMarca implements ActionListener {

    TelaCadastroMarca telaCadastroMarca;

    public ControllerCadMarca(TelaCadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;
        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroMarca.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroMarca.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroMarca.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroMarca.getjButtonBuscar()) {
            TelaBuscaMarca busca = new TelaBuscaMarca(null,true);
            ControllerBuscaMarca contr = new ControllerBuscaMarca(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroMarca.getjButtonSair()) {
            this.telaCadastroMarca.dispose();
        }

    }

}
