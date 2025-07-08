/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaHospede;
import view.TelaBuscaProduto;
import view.TelaCadastroProduto;

public class ControllerCadProduto implements ActionListener {

    TelaCadastroProduto telaCadastroProduto;

    public ControllerCadProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;
        this.telaCadastroProduto.getjButtonNovo().addActionListener(this);
        this.telaCadastroProduto.getjButtonSair().addActionListener(this);
        this.telaCadastroProduto.getjButtonGravar().addActionListener(this);
        this.telaCadastroProduto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroProduto.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroProduto.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroProduto.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroProduto.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroProduto.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroProduto.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroProduto.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroProduto.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroProduto.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroProduto.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroProduto.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroProduto.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroProduto.getjButtonBuscar()) {
            TelaBuscaProduto busca = new TelaBuscaProduto(null,true);
            ControllerBuscaProduto contr = new ControllerBuscaProduto(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroProduto.getjButtonSair()) {
            this.telaCadastroProduto.dispose();
        }

    }

}
