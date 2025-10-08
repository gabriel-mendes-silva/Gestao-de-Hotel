/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import model.bo.Funcionario;
import model.bo.Funcionario;
import model.bo.SexoNullable;
import model.bo.SexoValido;
import utilities.FuncionarioBuilder;
import view.TelaBuscaFuncionario;
import view.TelaBuscaFuncionario;
import view.TelaCadastroFuncionario;

import javax.swing.*;

public class ControllerCadFuncionario implements ActionListener {

    TelaCadastroFuncionario telaCadastroFuncionario;
    public static int codigo;

    public ControllerCadFuncionario(TelaCadastroFuncionario telaCadastroFuncionario) {
        this.telaCadastroFuncionario = telaCadastroFuncionario;
        this.telaCadastroFuncionario.getjButtonNovo().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonSair().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonGravar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFuncionario.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);
            this.telaCadastroFuncionario.getjTextFieldID().setEnabled(false);
            this.telaCadastroFuncionario.getjTextFieldStatus().setEnabled(false);

            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroFuncionario.getjTextFieldNome().requestFocus();

        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonGravar()) {

            if (this.telaCadastroFuncionario.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é obrigatório...");
                this.telaCadastroFuncionario.getjTextFieldNome().requestFocus();
            } else {

                Funcionario funcionario = new FuncionarioBuilder()
                        .setNome(this.telaCadastroFuncionario.getjTextFieldNome().getText())
                        .setTelefone(this.telaCadastroFuncionario.getjFormattedTextFieldFone1().getText())
                        .setTelefoneReserva(this.telaCadastroFuncionario.getjFormattedTextFieldFone2().getText())
                        .setEmail(this.telaCadastroFuncionario.getjTextFieldEmail().getText())
                        .setCep(this.telaCadastroFuncionario.getjFormattedTextFieldCep().getText())
                        .setLogradouro(this.telaCadastroFuncionario.getjTextFieldLogradouro().getText())
                        .setBairro(this.telaCadastroFuncionario.getjTextFieldBairro().getText())
                        .setCidade(this.telaCadastroFuncionario.getjTextFieldCidade().getText())
                        .setComplemento(this.telaCadastroFuncionario.getjTextFieldComplemento().getText())
                        .setDataCadastro(this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().getText())
                        .setCpf(this.telaCadastroFuncionario.getjFormattedTextFieldCPF().getText())
                        .setRg(this.telaCadastroFuncionario.getjTextFieldRG().getText())
                        .setSenha(this.telaCadastroFuncionario.getjTextFieldSenha().getText())
                        .setUsuario(this.telaCadastroFuncionario.getjTextFieldUsuario().getText())
                        .setObs(this.telaCadastroFuncionario.getjTextAreaObservacao().getText())
                        .setSexo(
                                new SexoNullable(
                                        new SexoValido(
                                                this.telaCadastroFuncionario.getjComboBoxSexo().getSelectedItem().toString().charAt(0)
                                        )
                                )
                        )
                        .build();

                if (this.telaCadastroFuncionario.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    funcionario.setStatus('A');
                    service.FuncionarioService.criar(funcionario);
                } else {
                    funcionario.setId(Integer.parseInt(this.telaCadastroFuncionario.getjTextFieldID().getText()));
                    funcionario.setStatus(this.telaCadastroFuncionario.getjTextFieldStatus().getText().charAt(0));
                    service.FuncionarioService.atualizar(funcionario);

                }

                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), false);
            }

        }

        // ____________________________________________________________________________________________________________

        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaFuncionario busca = new TelaBuscaFuncionario(null, true);
            ControllerBuscaFuncionario contr = new ControllerBuscaFuncionario(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroFuncionario.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionario.getjPanelDados(), true);

                this.telaCadastroFuncionario.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroFuncionario.getjTextFieldID().setEnabled(false);
                this.telaCadastroFuncionario.getjTextFieldStatus().setEnabled(false);

                Funcionario funcionario = service.FuncionarioService.carregar(codigo);

                this.telaCadastroFuncionario.getjTextFieldNome().setText(funcionario.getNome());
                this.telaCadastroFuncionario.getjTextFieldEmail().setText(funcionario.getEmail());
                this.telaCadastroFuncionario.getjTextAreaObservacao().setText(funcionario.getObs());
                this.telaCadastroFuncionario.getjTextFieldStatus().setText(String.valueOf(funcionario.getStatus()));
                this.telaCadastroFuncionario.getjFormattedTextFieldFone1().setText(funcionario.getFone1());
                this.telaCadastroFuncionario.getjFormattedTextFieldFone2().setText(funcionario.getFone2());
                this.telaCadastroFuncionario.getjFormattedTextFieldCep().setText(funcionario.getCep());
                this.telaCadastroFuncionario.getjTextFieldLogradouro().setText(funcionario.getLogradouro());
                this.telaCadastroFuncionario.getjTextFieldBairro().setText(funcionario.getBairro());
                this.telaCadastroFuncionario.getjTextFieldSenha().setText(funcionario.getSenha());
                this.telaCadastroFuncionario.getjTextFieldUsuario().setText(funcionario.getUsuario());
                this.telaCadastroFuncionario.getjTextFieldCidade().setText(funcionario.getCidade());
                this.telaCadastroFuncionario.getjTextFieldComplemento().setText(funcionario.getComplemento());
                this.telaCadastroFuncionario.getjFormattedTextFieldDataCadastro().setText(funcionario.getDataCadastro());
                this.telaCadastroFuncionario.getjFormattedTextFieldCPF().setText(funcionario.getCpf());
                this.telaCadastroFuncionario.getjTextFieldRG().setText(funcionario.getRg());

                for (int i = 0; i < this.telaCadastroFuncionario.getjComboBoxSexo().getItemCount(); i++){
                    if(funcionario.getSexo().equalsIgnoreCase(String.valueOf(this.telaCadastroFuncionario.getjComboBoxSexo().getItemAt(i).charAt(0)))){
                        this.telaCadastroFuncionario.getjComboBoxSexo().setSelectedIndex(i);
                    }
                }

                JComboBox ComboSexo = this.telaCadastroFuncionario.getjComboBoxSexo();
                if(ComboSexo.getSelectedIndex() == -1){
                    this.telaCadastroFuncionario.getjComboBoxSexo().setSelectedIndex(2);
                }



            }

        }


        // ____________________________________________________________________________________________________________

        if (evento.getSource() == this.telaCadastroFuncionario.getjButtonSair()) {
            this.telaCadastroFuncionario.dispose();
        }



    }

    // ____________________________________________________________________________________________________________


}


