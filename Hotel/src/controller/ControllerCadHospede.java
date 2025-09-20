/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Hospede;
import view.TelaBuscaHospede;
import view.TelaCadastroHospede;

public class ControllerCadHospede implements ActionListener {

    TelaCadastroHospede telaCadastroHospede;
    public static int codigo;

    public ControllerCadHospede(TelaCadastroHospede telaCadastroHospede) {
        this.telaCadastroHospede = telaCadastroHospede;
        this.telaCadastroHospede.getjButtonNovo().addActionListener(this);
        this.telaCadastroHospede.getjButtonSair().addActionListener(this);
        this.telaCadastroHospede.getjButtonGravar().addActionListener(this);
        this.telaCadastroHospede.getjButtonCancelar().addActionListener(this);
        this.telaCadastroHospede.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroHospede.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), true);
            this.telaCadastroHospede.getjTextFieldID().setEnabled(false);
            this.telaCadastroHospede.getjFormattedTextFieldNome().requestFocus();
        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);

        } else if (evento.getSource() == this.telaCadastroHospede.getjButtonGravar()) {

            if (this.telaCadastroHospede.getjFormattedTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é obrigatório...");
                this.telaCadastroHospede.getjFormattedTextFieldNome().requestFocus();
            } else {
                Hospede hospede = new Hospede();
                hospede.setNome(this.telaCadastroHospede.getjFormattedTextFieldNome().getText());
                hospede.setFone1(this.telaCadastroHospede.getjFormattedTextFieldFone1().getText());
                hospede.setFone2(this.telaCadastroHospede.getjFormattedTextFieldFone2().getText());
                hospede.setEmail(this.telaCadastroHospede.getjTextFieldEmail().getText());
                hospede.setCep(this.telaCadastroHospede.getjFormattedTextFieldCep().getText());
                hospede.setLogradouro(this.telaCadastroHospede.getjTextFieldLogradouro().getText());
                hospede.setBairro(this.telaCadastroHospede.getjTextFieldBairro().getText());
                hospede.setCidade(this.telaCadastroHospede.getjTextFieldCidade().getText());
                hospede.setComplemento(this.telaCadastroHospede.getjTextFieldComplemento().getText());
                hospede.setDataCadastro(this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().getText());
                hospede.setCpf(this.telaCadastroHospede.getjFormattedTextFieldCPF().getText());
                hospede.setRg(this.telaCadastroHospede.getjTextFieldRG().getText());
                hospede.setRazaoSocial(this.telaCadastroHospede.getjTextFieldRazaoSocial().getText());
                hospede.setCnpj(this.telaCadastroHospede.getjTextFieldCNPJ().getText());
                hospede.setInscricaoEstadual(this.telaCadastroHospede.getjTextFieldInscricaoEstadual().getText());
                hospede.setContato(this.telaCadastroHospede.getjTextFieldContato().getText());
                hospede.setObs(this.telaCadastroHospede.getjTextAreaObservacao().getText());
 

                if (this.telaCadastroHospede.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    hospede.setStatus('A');
                    service.HospedeService.criar(hospede);
                } else {
                    hospede.setId(Integer.parseInt(this.telaCadastroHospede.getjTextFieldID().getText()));
                    service.HospedeService.atualizar(hospede);
                }

                utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
            }

        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonBuscar()) {
            TelaBuscaHospede busca = new TelaBuscaHospede(null, true);
            ControllerBuscaHospede contr = new ControllerBuscaHospede(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroHospede.getjButtonSair()) {
            this.telaCadastroHospede.dispose();
        }

    }

}
