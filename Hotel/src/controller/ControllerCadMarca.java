/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bo.Marca;
import view.TelaBuscaMarca;
import view.TelaBuscaMarca;
import view.TelaCadastroMarca;

import javax.swing.*;

public class ControllerCadMarca implements ActionListener {

    TelaCadastroMarca telaCadastroMarca;
    public static int codigo;

    public ControllerCadMarca(TelaCadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;
        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //--------------------------------- NOVO -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroMarca.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
            this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
            this.telaCadastroMarca.getjTextFieldStatus().setEnabled(false);

            this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();

        }
        //--------------------------------- CANCELAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroMarca.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);

        }

        //--------------------------------- GRAVAR -------------------------------------------------------------


        if (evento.getSource() == this.telaCadastroMarca.getjButtonGravar()) {

            if (this.telaCadastroMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O Atributo Descrição é obrigatório...");
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();
            } else {

                Marca marca = new Marca();
                marca.setDescricao(this.telaCadastroMarca.getjTextFieldDescricao().getText());


                if (this.telaCadastroMarca.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    marca.setStatus('A');
                    service.MarcaService.criar(marca);
                } else {
                    marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldID().getText()));
                    marca.setStatus(this.telaCadastroMarca.getjTextFieldStatus().getText().charAt(0));
                    service.MarcaService.atualizar(marca);


                }

                utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            }

        }


        //--------------------------------- BUSCAR -------------------------------------------------------------

        if (evento.getSource() == this.telaCadastroMarca.getjButtonBuscar()) {

            codigo = 0;

            TelaBuscaMarca busca = new TelaBuscaMarca(null, true);
            ControllerBuscaMarca contr = new ControllerBuscaMarca(busca);
            busca.setVisible(true);
            if (codigo != 0) {
                utilities.Utilities.ativaDesativa(this.telaCadastroMarca.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);

                this.telaCadastroMarca.getjTextFieldID().setText(String.valueOf(codigo));
                this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
                this.telaCadastroMarca.getjTextFieldStatus().setEnabled(false);

                Marca marca = service.MarcaService.carregar(codigo);

                this.telaCadastroMarca.getjTextFieldDescricao().setText(marca.getDescricao());
                this.telaCadastroMarca.getjTextFieldStatus().setText(String.valueOf(marca.getStatus()));


            }

        }

        //--------------------------------- SAIR -------------------------------------------------------------


        if (evento.getSource() == this.telaCadastroMarca.getjButtonSair()) {
            this.telaCadastroMarca.dispose();
        }

    }

}
