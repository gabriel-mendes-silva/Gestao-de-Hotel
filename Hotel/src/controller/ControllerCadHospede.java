/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

import model.bo.Hospede;
import utilities.HospedeBuilder;
import view.TelaBuscaHospede;
import view.TelaCadastroHospede;
import model.bo.SexoNullable;
import model.bo.SexoValido;

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

        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroHospede.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), true);
            this.telaCadastroHospede.getjTextFieldID().setEnabled(false);
            this.telaCadastroHospede.getjTextFieldStatus().setEnabled(false);

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroHospede.getjTextFieldNome().requestFocus();

        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroHospede.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        else if (evento.getSource() == this.telaCadastroHospede.getjButtonGravar()) {

            if (this.telaCadastroHospede.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é obrigatório...");
                this.telaCadastroHospede.getjTextFieldNome().requestFocus();
            } else {

                Hospede hospede = new HospedeBuilder()
                        .setNome(this.telaCadastroHospede.getjTextFieldNome().getText())
                        .setTelefone(this.telaCadastroHospede.getjFormattedTextFieldFone1().getText())
                        .setTelefoneReserva(this.telaCadastroHospede.getjFormattedTextFieldFone2().getText())
                        .setEmail(this.telaCadastroHospede.getjTextFieldEmail().getText())
                        .setCep(this.telaCadastroHospede.getjFormattedTextFieldCep().getText())
                        .setLogradouro(this.telaCadastroHospede.getjTextFieldLogradouro().getText())
                        .setBairro(this.telaCadastroHospede.getjTextFieldBairro().getText())
                        .setCidade(this.telaCadastroHospede.getjTextFieldCidade().getText())
                        .setComplemento(this.telaCadastroHospede.getjTextFieldComplemento().getText())
                        .setDataCadastro(this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().getText())
                        .setCpf(this.telaCadastroHospede.getjFormattedTextFieldCPF().getText())
                        .setRg(this.telaCadastroHospede.getjTextFieldRG().getText())
                        .setRazaoSocial(this.telaCadastroHospede.getjTextFieldRazaoSocial().getText())
                        .setCnpj(this.telaCadastroHospede.getjTextFieldCNPJ().getText())
                        .setInscricaoEstadual(this.telaCadastroHospede.getjTextFieldInscricaoEstadual().getText())
                        .setContato(this.telaCadastroHospede.getjTextFieldContato().getText())
                        .setObs(this.telaCadastroHospede.getjTextAreaObservacao().getText())
                        .setSexo(
                                new SexoNullable(
                                        new SexoValido(
                                                this.telaCadastroHospede.getjComboBoxSexo().getSelectedItem().toString().charAt(0)
                                        )
                                )
                        )
                        .build();


                if (this.telaCadastroHospede.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    hospede.setStatus('A');
                    service.HospedeService.criar(hospede);
                } else {
                    hospede.setId(Integer.parseInt(this.telaCadastroHospede.getjTextFieldID().getText()));
                    hospede.setStatus(this.telaCadastroHospede.getjTextFieldStatus().getText().charAt(0));
                    service.HospedeService.atualizar(hospede);


                }

                utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), false);
            }

        }

        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroHospede.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaHospede busca = new TelaBuscaHospede(null, true);
            ControllerBuscaHospede contr = new ControllerBuscaHospede(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroHospede.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospede.getjPanelDados(), true);

                this.telaCadastroHospede.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroHospede.getjTextFieldID().setEnabled(false);
                this.telaCadastroHospede.getjTextFieldStatus().setEnabled(false);

                Hospede hospede = service.HospedeService.carregar(codigo);

                this.telaCadastroHospede.getjTextFieldNome().setText(hospede.getNome());
                this.telaCadastroHospede.getjTextFieldEmail().setText(hospede.getEmail());
                this.telaCadastroHospede.getjTextAreaObservacao().setText(hospede.getObs());
                this.telaCadastroHospede.getjTextFieldStatus().setText(String.valueOf(hospede.getStatus()));
                this.telaCadastroHospede.getjFormattedTextFieldFone1().setText(hospede.getFone1());
                this.telaCadastroHospede.getjFormattedTextFieldFone2().setText(hospede.getFone2());
                this.telaCadastroHospede.getjFormattedTextFieldCep().setText(hospede.getCep());
                this.telaCadastroHospede.getjTextFieldLogradouro().setText(hospede.getLogradouro());
                this.telaCadastroHospede.getjTextFieldBairro().setText(hospede.getBairro());
                this.telaCadastroHospede.getjTextFieldRazaoSocial().setText(hospede.getRazaoSocial());
                this.telaCadastroHospede.getjTextFieldCNPJ().setText(hospede.getCnpj());
                this.telaCadastroHospede.getjTextFieldInscricaoEstadual().setText(hospede.getInscricaoEstadual());
                this.telaCadastroHospede.getjTextFieldContato().setText(hospede.getContato());
                this.telaCadastroHospede.getjTextFieldCidade().setText(hospede.getCidade());
                this.telaCadastroHospede.getjTextFieldComplemento().setText(hospede.getComplemento());
                this.telaCadastroHospede.getjFormattedTextFieldDataCadastro().setText(hospede.getDataCadastro());
                this.telaCadastroHospede.getjFormattedTextFieldCPF().setText(hospede.getCpf());
                this.telaCadastroHospede.getjTextFieldRG().setText(hospede.getRg());

                for (int i = 0; i < this.telaCadastroHospede.getjComboBoxSexo().getItemCount(); i++){
                    if(hospede.getSexo().equalsIgnoreCase(String.valueOf(this.telaCadastroHospede.getjComboBoxSexo().getItemAt(i).charAt(0)))){
                        this.telaCadastroHospede.getjComboBoxSexo().setSelectedIndex(i);
                    }
                }

                JComboBox ComboSexo = this.telaCadastroHospede.getjComboBoxSexo();
                if(ComboSexo.getSelectedIndex() == -1){
                    this.telaCadastroHospede.getjComboBoxSexo().setSelectedIndex(2);
                }



            }

        }

        //--------------------------------------- SAIR  -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroHospede.getjButtonSair()) {
            this.telaCadastroHospede.dispose();
        }

    }

}
