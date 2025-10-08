/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bo.Fornecedor;
import model.bo.SexoNullable;
import model.bo.SexoValido;
import utilities.FornecedorBuilder;
import utilities.Utilities;
import view.TelaBuscaFornecedor;
import view.TelaBuscaFornecedor;
import view.TelaCadastroFornecedor;

import javax.swing.*;

public class ControllerCadFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;
    public static int codigo;

    public ControllerCadFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;
        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjRadioPessoaFisica().addActionListener(this);
        this.telaCadastroFornecedor.getjRadioPessoaJuridica().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        Component[] componentesJuridica = {
                this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual(),
                this.telaCadastroFornecedor.getjTextFieldCNPJ(),
                this.telaCadastroFornecedor.getjTextFieldRazaoSocial(),
                this.telaCadastroFornecedor.getjTextFieldContato()
        };

        Component[] componentesFisica = {
                this.telaCadastroFornecedor.getjFormattedTextFieldCPF(),
                this.telaCadastroFornecedor.getjTextFieldRG()
        };

        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);
            this.telaCadastroFornecedor.getjTextFieldID().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldStatus().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldCNPJ().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldRazaoSocial().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldContato().setEnabled(false);
            this.telaCadastroFornecedor.getjFormattedTextFieldCPF().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldRG().setEnabled(false);
            this.telaCadastroFornecedor.getButtonGroupPessoa().clearSelection();


            Date dataAtual = new Date();
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            String novaData = dataFormatada.format(dataAtual);
            this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().setText(novaData);
            this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroFornecedor.getjTextFieldNome().requestFocus();




        }


        if(evento.getSource() == this.telaCadastroFornecedor.getjRadioPessoaFisica()){
            if(this.telaCadastroFornecedor.getjRadioPessoaFisica().isSelected()){
                Utilities.limpaComponentes(componentesJuridica, false);
                Utilities.limpaComponentes(componentesFisica, true);
            }
        }

        if(evento.getSource() == this.telaCadastroFornecedor.getjRadioPessoaJuridica()){
            if(this.telaCadastroFornecedor.getjRadioPessoaJuridica().isSelected()){
                Utilities.limpaComponentes(componentesFisica,false);
                Utilities.limpaComponentes(componentesJuridica, true);
            }
        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);
            this.telaCadastroFornecedor.getButtonGroupPessoa().clearSelection();
        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {

            if (this.telaCadastroFornecedor.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Nome é obrigatório...");
                this.telaCadastroFornecedor.getjTextFieldNome().requestFocus();
                System.out.println(this.telaCadastroFornecedor.getjFormattedTextFieldCPF().getText());
                return;
            }
            if (this.telaCadastroFornecedor.getjRadioPessoaFisica().isSelected()) {
                if(this.telaCadastroFornecedor.getjFormattedTextFieldCPF().getText().trim().equalsIgnoreCase(".   .   -")){
                    JOptionPane.showMessageDialog(null, "O Atributo CPF é obrigatório para Pessoas Físicas.");
                    return;
                }

            }

            if(this.telaCadastroFornecedor.getjRadioPessoaJuridica().isSelected()){
                if(this.telaCadastroFornecedor.getjTextFieldCNPJ().getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "O Atributo CNPJ é obrigatório para Pessoas Jurídicas.");
                    return;
                }

            }

            if (!this.telaCadastroFornecedor.getjRadioPessoaFisica().isSelected() && !this.telaCadastroFornecedor.getjRadioPessoaJuridica().isSelected()){
                {
                    JOptionPane.showMessageDialog(null, "Você precisa escolher entre pessoa Física e Jurídica.");
                    return;
                }

            }

                Fornecedor fornecedor = new FornecedorBuilder()
                        .setNome(this.telaCadastroFornecedor.getjTextFieldNome().getText())
                        .setTelefone(this.telaCadastroFornecedor.getjFormattedTextFieldFone1().getText())
                        .setTelefoneReserva(this.telaCadastroFornecedor.getjFormattedTextFieldFone2().getText())
                        .setEmail(this.telaCadastroFornecedor.getjTextFieldEmail().getText())
                        .setCep(this.telaCadastroFornecedor.getjFormattedTextFieldCep().getText())
                        .setLogradouro(this.telaCadastroFornecedor.getjTextFieldLogradouro().getText())
                        .setBairro(this.telaCadastroFornecedor.getjTextFieldBairro().getText())
                        .setCidade(this.telaCadastroFornecedor.getjTextFieldCidade().getText())
                        .setComplemento(this.telaCadastroFornecedor.getjTextFieldComplemento().getText())
                        .setDataCadastro(this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().getText())
                        .setCpf(this.telaCadastroFornecedor.getjFormattedTextFieldCPF().getText())
                        .setRg(this.telaCadastroFornecedor.getjTextFieldRG().getText())
                        .setRazaoSocial(this.telaCadastroFornecedor.getjTextFieldRazaoSocial().getText())
                        .setCnpj(this.telaCadastroFornecedor.getjTextFieldCNPJ().getText())
                        .setInscricaoEstadual(this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().getText())
                        .setContato(this.telaCadastroFornecedor.getjTextFieldContato().getText())
                        .setObs(this.telaCadastroFornecedor.getjTextAreaObservacao().getText())
                        .build();


                if (this.telaCadastroFornecedor.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    fornecedor.setStatus('A');
                    service.FornecedorService.criar(fornecedor);
                } else {
                    fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedor.getjTextFieldID().getText()));
                    fornecedor.setStatus(this.telaCadastroFornecedor.getjTextFieldStatus().getText().charAt(0));
                    service.FornecedorService.atualizar(fornecedor);


                }




                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), false);

        }

        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {
            codigo = 0;

            TelaBuscaFornecedor busca = new TelaBuscaFornecedor(null, true);
            ControllerBuscaFornecedor contr = new ControllerBuscaFornecedor(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroFornecedor.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedor.getjPanelDados(), true);

                this.telaCadastroFornecedor.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroFornecedor.getjTextFieldID().setEnabled(false);
                this.telaCadastroFornecedor.getjTextFieldStatus().setEnabled(false);
                this.telaCadastroFornecedor.getjRadioPessoaJuridica().setEnabled(false);
                this.telaCadastroFornecedor.getjRadioPessoaFisica().setEnabled(false);

                Fornecedor fornecedor = service.FornecedorService.carregar(codigo);

                this.telaCadastroFornecedor.getjTextFieldNome().setText(fornecedor.getNome());
                this.telaCadastroFornecedor.getjTextFieldEmail().setText(fornecedor.getEmail());
                this.telaCadastroFornecedor.getjTextAreaObservacao().setText(fornecedor.getObs());
                this.telaCadastroFornecedor.getjTextFieldStatus().setText(String.valueOf(fornecedor.getStatus()));
                this.telaCadastroFornecedor.getjFormattedTextFieldFone1().setText(fornecedor.getFone1());
                this.telaCadastroFornecedor.getjFormattedTextFieldFone2().setText(fornecedor.getFone2());
                this.telaCadastroFornecedor.getjFormattedTextFieldCep().setText(fornecedor.getCep());
                this.telaCadastroFornecedor.getjTextFieldLogradouro().setText(fornecedor.getLogradouro());
                this.telaCadastroFornecedor.getjTextFieldBairro().setText(fornecedor.getBairro());
                this.telaCadastroFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
                this.telaCadastroFornecedor.getjTextFieldCNPJ().setText(fornecedor.getCnpj());
                this.telaCadastroFornecedor.getjTextFieldInscricaoEstadual().setText(fornecedor.getInscricaoEstadual());
                this.telaCadastroFornecedor.getjTextFieldContato().setText(fornecedor.getContato());
                this.telaCadastroFornecedor.getjTextFieldCidade().setText(fornecedor.getCidade());
                this.telaCadastroFornecedor.getjTextFieldComplemento().setText(fornecedor.getComplemento());
                this.telaCadastroFornecedor.getjFormattedTextFieldDataCadastro().setText(fornecedor.getDataCadastro());
                this.telaCadastroFornecedor.getjFormattedTextFieldCPF().setText(fornecedor.getCpf());
                this.telaCadastroFornecedor.getjTextFieldRG().setText(fornecedor.getRg());

                if (!fornecedor.getCnpj().equalsIgnoreCase("")){
                    this.telaCadastroFornecedor.getButtonGroupPessoa().setSelected(this.telaCadastroFornecedor.getjRadioPessoaJuridica().getModel(), true);
                    Utilities.ativaDesativa(componentesFisica,false);
                    Utilities.ativaDesativa(componentesJuridica, true);
                }
                else{
                    this.telaCadastroFornecedor.getButtonGroupPessoa().setSelected(this.telaCadastroFornecedor.getjRadioPessoaFisica().getModel(), true);
                    Utilities.ativaDesativa(componentesFisica,true);
                    Utilities.ativaDesativa(componentesJuridica, false);
                }
            }

        }

        //--------------------------------- SAIR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
            this.telaCadastroFornecedor.dispose();
        }

    }

}
