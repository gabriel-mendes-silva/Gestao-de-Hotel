/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bo.Marca;
import model.bo.Modelo;
import service.MarcaService;
import view.TelaBuscaHospede;
import view.TelaBuscaModelo;
import view.TelaCadastroModelo;

import javax.swing.*;

public class ControllerCadModelo implements ActionListener {

    TelaCadastroModelo telaCadastroModelo;
    public static int codigo;

    public ControllerCadModelo(TelaCadastroModelo telaCadastroModelo) {
        this.telaCadastroModelo = telaCadastroModelo;
        this.telaCadastroModelo.getjButtonNovo().addActionListener(this);
        this.telaCadastroModelo.getjButtonSair().addActionListener(this);
        this.telaCadastroModelo.getjButtonGravar().addActionListener(this);
        this.telaCadastroModelo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroModelo.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroModelo.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), true);
            this.telaCadastroModelo.getjTextFieldID().setEnabled(false);
            this.telaCadastroModelo.getjTextFieldStatus().setEnabled(false);


            ArrayList<Marca> opcoesMarca = (ArrayList<Marca>) service.MarcaService.carregar("descricao", "%%");
            for(Marca marca : opcoesMarca){
                this.telaCadastroModelo.getjComboBoxMarca().addItem(marca.getDescricao());
            }
            this.telaCadastroModelo.getjComboBoxMarca().setSelectedIndex(-1);


            this.telaCadastroModelo.getjTextFieldDescricao().requestFocus();



        }

        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroModelo.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroModelo.getjButtonGravar()) {

            if (this.telaCadastroModelo.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Descrição é obrigatório...");
                this.telaCadastroModelo.getjTextFieldDescricao().requestFocus();
                return;
            }

            if (this.telaCadastroModelo.getjComboBoxMarca().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "O Atributo Marca é obrigatório...");
                this.telaCadastroModelo.getjComboBoxMarca().requestFocus();
                return;
            }

                int itemSelect = this.telaCadastroModelo.getjComboBoxMarca().getSelectedIndex();

                Modelo modelo = new Modelo();
                modelo.setDescricao(this.telaCadastroModelo.getjTextFieldDescricao().getText());
                modelo.setMarca(
                        MarcaService.carregar(
                                "descricao",
                                this.telaCadastroModelo.getjComboBoxMarca().getItemAt(itemSelect)
                        ).getFirst()
                );


                if (this.telaCadastroModelo.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    modelo.setStatus('A');
                    service.ModeloService.criar(modelo);
                } else {
                    modelo.setId(Integer.parseInt(this.telaCadastroModelo.getjTextFieldID().getText()));
                    modelo.setStatus(this.telaCadastroModelo.getjTextFieldStatus().getText().charAt(0));
                    service.ModeloService.atualizar(modelo);


                }

            this.telaCadastroModelo.getjComboBoxMarca().removeAllItems();

                utilities.Utilities.ativaDesativa(this.telaCadastroModelo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);


        }

        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroModelo.getjButtonBuscar()) {
            TelaBuscaModelo busca = new TelaBuscaModelo(null,true);
            ControllerBuscaModelo contr = new ControllerBuscaModelo(busca);
            busca.setVisible(true);

        }
        if (evento.getSource() == this.telaCadastroModelo.getjButtonSair()) {
            this.telaCadastroModelo.dispose();
        }

    }

}
