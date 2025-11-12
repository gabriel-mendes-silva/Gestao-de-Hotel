/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.bo.Marca;
import model.bo.ProdutoCopa;
import model.bo.Veiculo;
import service.ModeloService;
import service.ProdutoService;
import utilities.Utilities;
import view.TelaBuscaHospede;
import view.TelaBuscaProduto;
import view.TelaBuscaProduto;
import view.TelaCadastroProduto;

import javax.swing.*;

public class ControllerCadProduto implements ActionListener {

    TelaCadastroProduto telaCadastroProduto;
    public static int codigo;

    public ControllerCadProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;
        this.telaCadastroProduto.getjButtonNovo().addActionListener(this);
        this.telaCadastroProduto.getjButtonSair().addActionListener(this);
        this.telaCadastroProduto.getjButtonGravar().addActionListener(this);
        this.telaCadastroProduto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroProduto.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroProduto.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroProduto.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroProduto.getjButtonNovo()) {
            Utilities.ativaDesativa(this.telaCadastroProduto.getjPanelBotoes(), false);
            Utilities.limpaComponentes(this.telaCadastroProduto.getjPanelDados(), true);
            this.telaCadastroProduto.getjTextFieldId().setEnabled(false);
            this.telaCadastroProduto.getjTextFieldStatus().setEnabled(false);


        }

        if (evento.getSource() == this.telaCadastroProduto.getjButtonCancelar()) {
            Utilities.ativaDesativa(this.telaCadastroProduto.getjPanelBotoes(), true);
            Utilities.limpaComponentes(this.telaCadastroProduto.getjPanelDados(), false);

        }
        if (evento.getSource() == this.telaCadastroProduto.getjButtonGravar()) {

            if (this.telaCadastroProduto.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Descrição é obrigatório...");
                this.telaCadastroProduto.getjTextFieldDescricao().requestFocus();
            } else {

                ProdutoCopa produtoCopa = new ProdutoCopa();
                produtoCopa.setDescricao(this.telaCadastroProduto.getjTextFieldDescricao().getText());
                produtoCopa.setObs(this.telaCadastroProduto.getjTextAreaObservacao().getText());
                produtoCopa.setValor(Float.parseFloat(this.telaCadastroProduto.getjTextFieldValor().getText()));


                if (this.telaCadastroProduto.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    produtoCopa.setStatus('A');
                    ProdutoService.criar(produtoCopa);
                } else {
                    produtoCopa.setId(Integer.parseInt(this.telaCadastroProduto.getjTextFieldId().getText()));
                    produtoCopa.setStatus(this.telaCadastroProduto.getjTextFieldStatus().getText().charAt(0));
                    ProdutoService.atualizar(produtoCopa);


                }

                Utilities.ativaDesativa(this.telaCadastroProduto.getjPanelBotoes(), true);
                Utilities.limpaComponentes(this.telaCadastroProduto.getjPanelDados(), false);
            }
        }

        if (evento.getSource() == this.telaCadastroProduto.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaProduto busca = new TelaBuscaProduto(null, true);
            ControllerBuscaProduto contr = new ControllerBuscaProduto(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                Utilities.ativaDesativa(this.telaCadastroProduto.getjPanelBotoes(), false);
                Utilities.limpaComponentes(this.telaCadastroProduto.getjPanelDados(), true);

                this.telaCadastroProduto.getjTextFieldId().setText(String.valueOf(codigo));
                this.telaCadastroProduto.getjTextFieldId().setEnabled(false);
                this.telaCadastroProduto.getjTextFieldStatus().setEnabled(false);

                ProdutoCopa produto = ProdutoService.carregar(codigo);

                this.telaCadastroProduto.getjTextFieldDescricao().setText(produto.getDescricao());
                this.telaCadastroProduto.getjTextFieldStatus().setText(String.valueOf(produto.getStatus()));
                this.telaCadastroProduto.getjTextAreaObservacao().setText(produto.getObs());
                this.telaCadastroProduto.getjTextFieldValor().setText(String.valueOf(produto.getValor()));


            }

        }
        
        if (evento.getSource() == this.telaCadastroProduto.getjButtonSair()) {
            this.telaCadastroProduto.dispose();
        }

    }

}
