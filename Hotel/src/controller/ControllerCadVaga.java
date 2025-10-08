/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bo.Servico;
import model.bo.VagaEstacionamento;
import view.TelaBuscaHospede;
import view.TelaBuscaServico;
import view.TelaBuscaVaga;
import view.TelaCadastroVaga;

import javax.swing.*;

public class ControllerCadVaga implements ActionListener {

    TelaCadastroVaga telaCadastroVaga;
    public static int codigo;

    public ControllerCadVaga(TelaCadastroVaga telaCadastroVaga) {
        this.telaCadastroVaga = telaCadastroVaga;
        this.telaCadastroVaga.getjButtonNovo().addActionListener(this);
        this.telaCadastroVaga.getjButtonSair().addActionListener(this);
        this.telaCadastroVaga.getjButtonGravar().addActionListener(this);
        this.telaCadastroVaga.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVaga.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroVaga.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanelDados(), true);
            this.telaCadastroVaga.getjTextFieldID().setEnabled(false);
            this.telaCadastroVaga.getjTextFieldStatus().setEnabled(false);
            this.telaCadastroVaga.getjTextFieldDescricao().requestFocus();

        }

        //--------------------------------- CANCELAR -------------------------------------------------------------
        
        if (evento.getSource() == this.telaCadastroVaga.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanelDados(), false);

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroVaga.getjButtonGravar()) {

            if (this.telaCadastroVaga.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Descrição é obrigatório...");
                this.telaCadastroVaga.getjTextFieldDescricao().requestFocus();
            } else {

                VagaEstacionamento vaga = new VagaEstacionamento();
                vaga.setDescricao(this.telaCadastroVaga.getjTextFieldDescricao().getText());
                vaga.setMetragemVaga(Float.parseFloat(this.telaCadastroVaga.getjTextFieldMetragem().getText()));
                vaga.setObs(this.telaCadastroVaga.getjTextAreaObservacao().getText());


                if (this.telaCadastroVaga.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    vaga.setStatus('A');
                    service.VagaEstacionamentoService.criar(vaga);
                } else {
                    vaga.setId(Integer.parseInt(this.telaCadastroVaga.getjTextFieldID().getText()));
                    vaga.setStatus(this.telaCadastroVaga.getjTextFieldStatus().getText().charAt(0));
                    service.VagaEstacionamentoService.atualizar(vaga);


                }

                utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanelDados(), false);
            }

        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaVaga busca = new TelaBuscaVaga(null, true);
            ControllerBuscaVaga contr = new ControllerBuscaVaga(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroVaga.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroVaga.getjPanelDados(), true);

                this.telaCadastroVaga.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroVaga.getjTextFieldID().setEnabled(false);
                this.telaCadastroVaga.getjTextFieldStatus().setEnabled(false);

                VagaEstacionamento vaga = service.VagaEstacionamentoService.carregar(codigo);

                this.telaCadastroVaga.getjTextFieldDescricao().setText(vaga.getDescricao());
                this.telaCadastroVaga.getjTextFieldMetragem().setText(String.valueOf(vaga.getMetragemVaga()));
                this.telaCadastroVaga.getjTextAreaObservacao().setText(vaga.getObs());
                this.telaCadastroVaga.getjTextFieldStatus().setText(String.valueOf(vaga.getStatus()));


            }

        }
        if (evento.getSource() == this.telaCadastroVaga.getjButtonSair()) {
            this.telaCadastroVaga.dispose();
        }

    }

}
