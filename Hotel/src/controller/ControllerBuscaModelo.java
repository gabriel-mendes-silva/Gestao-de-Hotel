/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.bo.Modelo;
import view.TelaBuscaModelo;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaModelo implements ActionListener{
    private TelaBuscaModelo telaBuscaModelo;

    public ControllerBuscaModelo(TelaBuscaModelo telaBuscaModelo) {
        this.telaBuscaModelo = telaBuscaModelo;
        
        this.telaBuscaModelo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaModelo.getjButtonBuscar().addActionListener(this);
        this.telaBuscaModelo.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaModelo.getjButtonCarregar()){
            if(this.telaBuscaModelo.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadModelo.codigo = (int) this.telaBuscaModelo.getjTableDados()
                        .getValueAt(this.telaBuscaModelo.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaModelo.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaModelo.getjButtonBuscar()){
            if (this.telaBuscaModelo.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Modelo modelo = new Modelo();

                    modelo = service.ModeloService.carregar(Integer.parseInt(this.telaBuscaModelo.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{
                            modelo.getId(),
                            modelo.getDescricao(),
                            modelo.getMarca().getDescricao(),
                            modelo.getStatus()});
                }
                if (this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Modelo> modelosFiltrados = new ArrayList<>();
                    modelosFiltrados = service.ModeloService.carregar("modelo.descricao", this.telaBuscaModelo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Modelo modelo : modelosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        modelo.getId(),
                                        modelo.getDescricao(),
                                        modelo.getMarca().getDescricao(),
                                        modelo.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Modelo> modelosFiltrados = new ArrayList<>();
                    modelosFiltrados = service.ModeloService.carregar("marca.descricao", this.telaBuscaModelo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Modelo modelo : modelosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        modelo.getId(),
                                        modelo.getDescricao(),
                                        modelo.getMarca().getDescricao(),
                                        modelo.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Modelo> modelosFiltrados = new ArrayList<>();
                    modelosFiltrados = service.ModeloService.carregar("modelo.status", this.telaBuscaModelo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Modelo modelo : modelosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        modelo.getId(),
                                        modelo.getDescricao(),
                                        modelo.getMarca().getDescricao(),
                                        modelo.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaModelo.getjButtonSair()){
            this.telaBuscaModelo.dispose();
        }
    }
    
    
    
    
    
    
}
