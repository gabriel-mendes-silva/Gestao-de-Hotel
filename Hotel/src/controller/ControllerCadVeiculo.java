/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import model.bo.*;
import service.ModeloService;
import view.*;
import view.TelaBuscaVeiculo;

import javax.swing.*;

public class ControllerCadVeiculo implements ActionListener, ItemListener {

    TelaCadastroVeiculo telaCadastroVeiculo;
    public static int codigo;

    public ControllerCadVeiculo(TelaCadastroVeiculo telaCadastroVeiculo) {
        this.telaCadastroVeiculo = telaCadastroVeiculo;
        this.telaCadastroVeiculo.getjButtonNovo().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonSair().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonGravar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonBuscar().addActionListener(this);
        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().addActionListener(this);
        this.telaCadastroVeiculo.getjComboBoxMarca().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonBuscaDono().addActionListener(this);
        this.telaCadastroVeiculo.getjComboBoxDono().addActionListener(this);


        utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        this.telaCadastroVeiculo.getjButtonBuscaDono().setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //--------------------------------- NOVO -------------------------------------------------------------

        this.telaCadastroVeiculo.getjTextFieldID().setEnabled(false);
        this.telaCadastroVeiculo.getjTextFieldStatus().setEnabled(false);
        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setEnabled(false);


        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);

            this.telaCadastroVeiculo.getjComboBoxModelo().setEnabled(false);
            this.telaCadastroVeiculo.getjButtonBuscaDono().setEnabled(true);


            //Enche a dropdown com as marcas;
            ArrayList<Marca> opcoesMarca = (ArrayList<Marca>) service.MarcaService.carregar("descricao", "%%");
            for(Marca marca : opcoesMarca){
                this.telaCadastroVeiculo.getjComboBoxMarca().addItem(marca.getDescricao());
            }
            this.telaCadastroVeiculo.getjComboBoxMarca().setSelectedIndex(-1);







        }

        if (evento.getSource() == this.telaCadastroVeiculo.getjComboBoxMarca()) {
            if(this.telaCadastroVeiculo.getjComboBoxMarca().getSelectedIndex() != -1){

                this.telaCadastroVeiculo.getjComboBoxModelo().removeAllItems();
                this.telaCadastroVeiculo.getjComboBoxModelo().setEnabled(true);

                //Enche a dropdown com os modelos;
                Marca marca = service.MarcaService.carregar("descricao",this.telaCadastroVeiculo.getjComboBoxMarca().getSelectedItem().toString()).getFirst();
                ArrayList<Modelo> opcoesModelo = (ArrayList<Modelo>) service.ModeloService.carregar("marca_id", String.valueOf(marca.getId()));
                for(Modelo modelo : opcoesModelo){
                    this.telaCadastroVeiculo.getjComboBoxModelo().addItem(modelo.getDescricao());
                }
                this.telaCadastroVeiculo.getjComboBoxModelo().setSelectedIndex(-1);
            }
        }

        // ---------------------------------- COMBO BOX DONO ----------------------------------------

        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonBuscaDono()) {
            codigo = 0;


            if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedIndex() == 0){

                TelaBuscaHospede busca = new TelaBuscaHospede(null, true);
                ControllerBuscaHospede contr = new ControllerBuscaHospede(busca);
                busca.setVisible(true);
                if(codigo != 0){
                    this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText("");
                    Hospede hospede = service.HospedeService.carregar(codigo);
                    this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(hospede.getCpf());
                }
            }

            if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedIndex() == 1){

                TelaBuscaFornecedor busca = new TelaBuscaFornecedor(null, true);
                ControllerBuscaFornecedor contr = new ControllerBuscaFornecedor(busca);
                busca.setVisible(true);
                if(codigo != 0){
                    this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText("");
                    Fornecedor fornecedor = service.FornecedorService.carregar(codigo);
                    if(!fornecedor.getCnpj().equalsIgnoreCase("")){
                        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(fornecedor.getCnpj());
                    } else if (!fornecedor.getCpf().equalsIgnoreCase("")) {
                        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(fornecedor.getCpf());
                    }

                }
            }

            if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedIndex() == 2){

                TelaBuscaFuncionario busca = new TelaBuscaFuncionario(null, true);
                ControllerBuscaFuncionario contr = new ControllerBuscaFuncionario(busca);
                busca.setVisible(true);
                if(codigo != 0){
                    this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText("");
                    Funcionario funcionario = service.FuncionarioService.carregar(codigo);
                    this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(funcionario.getCpf());
                }
            }


        }

        if(evento.getSource() == this.telaCadastroVeiculo.getjComboBoxDono()){
            this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText("");
        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            this.telaCadastroVeiculo.getjButtonBuscaDono().setEnabled(false);
            this.telaCadastroVeiculo.getjComboBoxMarca().removeAllItems();

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonGravar()) {

            if (this.telaCadastroVeiculo.getjComboBoxMarca().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "O Atributo Marca é obrigatório...");
                this.telaCadastroVeiculo.getjComboBoxMarca().requestFocus();
                return;
            }

            if (this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "O Atributo Modelo é obrigatório...");
                this.telaCadastroVeiculo.getjComboBoxModelo().requestFocus();
                return;
            }





            int itemSelect = this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex();

            Veiculo veiculo = new Veiculo();
            veiculo.setModelo(
                    ModeloService.carregar(
                            "modelo.descricao",
                            this.telaCadastroVeiculo.getjComboBoxModelo().getItemAt(itemSelect)
                    ).getFirst()
            );

            veiculo.setPlaca(this.telaCadastroVeiculo.getjTextFieldPlaca().getText());
            veiculo.setCor(this.telaCadastroVeiculo.getjComboBoxCor().getSelectedItem().toString());

            if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedItem().toString().equalsIgnoreCase("hospede")){

                Hospede hospede = service.HospedeService.carregar(
                        "cpf",
                        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().getText()
                ).getFirst();

                veiculo.setHospede(hospede);
            }

            if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedItem().toString().equalsIgnoreCase("funcionario")){

                Funcionario funcionario = service.FuncionarioService.carregar(
                     codigo
                );

                veiculo.setFuncionario(funcionario);
            }
            else if(this.telaCadastroVeiculo.getjComboBoxDono().getSelectedItem().toString().equalsIgnoreCase("fornecedor")){
                List<Fornecedor> fornecedoresFiltrados = new ArrayList<>();

                fornecedoresFiltrados = service.FornecedorService.carregar("CPF", this.telaCadastroVeiculo.getjTextFieldCpfCnpj().getText());
                fornecedoresFiltrados.addAll(fornecedoresFiltrados = service.FornecedorService.carregar("CNPJ", this.telaCadastroVeiculo.getjTextFieldCpfCnpj().getText()));


                veiculo.setFornecedor(fornecedoresFiltrados.getFirst());
            }




            if (this.telaCadastroVeiculo.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                veiculo.setStatus('A');
                service.VeiculoService.criar(veiculo);
            } else {
                veiculo.setId(Integer.parseInt(this.telaCadastroVeiculo.getjTextFieldID().getText()));
                veiculo.setStatus(this.telaCadastroVeiculo.getjTextFieldStatus().getText().charAt(0));
                service.VeiculoService.atualizar(veiculo);


            }

            this.telaCadastroVeiculo.getjComboBoxMarca().removeAllItems();
            this.telaCadastroVeiculo.getjComboBoxModelo().removeAllItems();

            utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);



        }

        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonBuscar()) {


            codigo = 0;

            TelaBuscaVeiculo busca = new TelaBuscaVeiculo(null, true);
            ControllerBuscaVeiculo contr = new ControllerBuscaVeiculo(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroVeiculo.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);

                this.telaCadastroVeiculo.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroVeiculo.getjTextFieldID().setEnabled(false);
                this.telaCadastroVeiculo.getjTextFieldStatus().setEnabled(false);

                Veiculo veiculo = service.VeiculoService.carregar(codigo);


                this.telaCadastroVeiculo.getjTextFieldStatus().setText(String.valueOf(veiculo.getStatus()));
                this.telaCadastroVeiculo.getjTextFieldPlaca().setText(veiculo.getPlaca());

                JComboBox selectMarca = this.telaCadastroVeiculo.getjComboBoxMarca();
                //Enche a dropdown com marcas;
                ArrayList<Marca> opcoesMarca = (ArrayList<Marca>) service.MarcaService.carregar("descricao", "%%");
                for(Marca marca : opcoesMarca){
                    selectMarca.addItem(marca.getDescricao());
                }

                for(int i = 0; i < selectMarca.getItemCount(); i++){
                    if(veiculo.getModelo().getMarca().getDescricao().equalsIgnoreCase(
                            this.telaCadastroVeiculo.getjComboBoxMarca().getItemAt(i))){
                        selectMarca.setSelectedIndex(i);

                    }
                }




                for (int i = 0; i < this.telaCadastroVeiculo.getjComboBoxModelo().getItemCount(); i++) {
                    if (veiculo.getModelo().getDescricao().equalsIgnoreCase(String.valueOf(this.telaCadastroVeiculo.getjComboBoxModelo().getItemAt(i)))) {
                        this.telaCadastroVeiculo.getjComboBoxModelo().setSelectedIndex(i);
                    }
                }


                for (int i = 0; i < this.telaCadastroVeiculo.getjComboBoxCor().getItemCount(); i++) {
                    if (veiculo.getCor().equalsIgnoreCase(this.telaCadastroVeiculo.getjComboBoxCor().getItemAt(i))) {
                        this.telaCadastroVeiculo.getjComboBoxCor().setSelectedIndex(i);
                    }
                }


                if(veiculo.getHospede() != null){
                        this.telaCadastroVeiculo.getjComboBoxDono().setSelectedIndex(0);
                        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(veiculo.getHospede().getCpf());

                }
                if(veiculo.getFuncionario() != null){
                        this.telaCadastroVeiculo.getjComboBoxDono().setSelectedIndex(2);
                        this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(veiculo.getFuncionario().getCpf());
                }
                if(veiculo.getFornecedor() != null){
                        this.telaCadastroVeiculo.getjComboBoxDono().setSelectedIndex(1);
                    System.out.println(veiculo);

                        if(!veiculo.getFornecedor().getCnpj().equalsIgnoreCase("")){
                            this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(veiculo.getFornecedor().getCnpj());
                        }
                        else{
                            this.telaCadastroVeiculo.getjTextFieldCpfCnpj().setText(veiculo.getFornecedor().getCpf());
                        }


                }


            }
        }

        if (evento.getSource() == this.telaCadastroVeiculo.getjButtonSair()) {
            this.telaCadastroVeiculo.dispose();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if(itemEvent.getSource() == this.telaCadastroVeiculo.getjComboBoxMarca()){
            if(this.telaCadastroVeiculo.getjComboBoxMarca().getSelectedIndex() != -1){
                this.telaCadastroVeiculo.getjComboBoxModelo().setEnabled(true);
            }
        }

    }
}
