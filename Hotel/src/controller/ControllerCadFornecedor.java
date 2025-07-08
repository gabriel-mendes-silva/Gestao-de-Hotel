/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaHospede;
import view.TelaCadastroFornecedor;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;

    public ControllerCadFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;
        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanel1(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanel2(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanel1(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanel2(), true);

        }
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanel2(), false);

        }
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanel1(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanel2(), false);
        }
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {
            TelaBuscaHospede busca = new TelaBuscaHospede(null,true);
            ControllerBuscaHospede contr = new ControllerBuscaHospede(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
            this.telaCadastroFornecedor.dispose();
        }

    }

}
