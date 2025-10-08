/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bo.Servico;
import model.bo.Servico;
import view.TelaBuscaServico;
import view.TelaBuscaServico;
import view.TelaCadastroServico;

import javax.swing.*;

public class ControllerCadServico implements ActionListener {

    TelaCadastroServico telaCadastroServico;
    public static int codigo;

    public ControllerCadServico(TelaCadastroServico telaCadastroServico) {
        this.telaCadastroServico = telaCadastroServico;
        this.telaCadastroServico.getjButtonNovo().addActionListener(this);
        this.telaCadastroServico.getjButtonSair().addActionListener(this);
        this.telaCadastroServico.getjButtonGravar().addActionListener(this);
        this.telaCadastroServico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroServico.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroServico.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), true);
            this.telaCadastroServico.getjTextFieldID().setEnabled(false);
            this.telaCadastroServico.getjTextFieldStatus().setEnabled(false);

            this.telaCadastroServico.getjTextFieldDescricao().requestFocus();

        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroServico.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------


        if (evento.getSource() == this.telaCadastroServico.getjButtonGravar()) {

            if (this.telaCadastroServico.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Descrição é obrigatório...");
                this.telaCadastroServico.getjTextFieldDescricao().requestFocus();
            } else {

                Servico servico = new Servico();
                servico.setDescricao(this.telaCadastroServico.getjTextFieldDescricao().getText());
                servico.setObs(this.telaCadastroServico.getjTextAreaObservacao().getText());


                if (this.telaCadastroServico.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    servico.setStatus('A');
                    service.ServicoService.criar(servico);
                } else {
                    servico.setId(Integer.parseInt(this.telaCadastroServico.getjTextFieldID().getText()));
                    servico.setStatus(this.telaCadastroServico.getjTextFieldStatus().getText().charAt(0));
                    service.ServicoService.atualizar(servico);


                }

                utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
            }

        }


        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroServico.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaServico busca = new TelaBuscaServico(null, true);
            ControllerBuscaServico contr = new ControllerBuscaServico(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroServico.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), true);

                this.telaCadastroServico.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroServico.getjTextFieldID().setEnabled(false);
                this.telaCadastroServico.getjTextFieldStatus().setEnabled(false);

                Servico servico = service.ServicoService.carregar(codigo);

                this.telaCadastroServico.getjTextFieldDescricao().setText(servico.getDescricao());
                this.telaCadastroServico.getjTextAreaObservacao().setText(servico.getObs());
                this.telaCadastroServico.getjTextFieldStatus().setText(String.valueOf(servico.getStatus()));


            }

        }

        //--------------------------------- SAIR -------------------------------------------------------------


        if (evento.getSource() == this.telaCadastroServico.getjButtonSair()) {
            this.telaCadastroServico.dispose();
        }

    }

}
