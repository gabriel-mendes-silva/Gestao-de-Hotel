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

import model.bo.Marca;
import view.TelaBuscaMarca;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaMarca implements ActionListener{
    private TelaBuscaMarca telaBuscaMarca;

    public ControllerBuscaMarca(TelaBuscaMarca telaBuscaMarca) {
        this.telaBuscaMarca = telaBuscaMarca;
        
        this.telaBuscaMarca.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMarca.getjButtonBuscar().addActionListener(this);
        this.telaBuscaMarca.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaMarca.getjButtonCarregar()){
            if(this.telaBuscaMarca.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadMarca.codigo = (int) this.telaBuscaMarca.getjTableDados()
                        .getValueAt(this.telaBuscaMarca.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaMarca.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaMarca.getjButtonBuscar()){
            if (this.telaBuscaMarca.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaMarca.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Marca marca = new Marca();

                    marca = service.MarcaService.carregar(Integer.parseInt(this.telaBuscaMarca.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{marca.getId(), marca.getDescricao(), marca.getStatus()});
                }
                if (this.telaBuscaMarca.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Marca> marcasFiltrados = new ArrayList<>();
                    marcasFiltrados = service.MarcaService.carregar("descricao", this.telaBuscaMarca.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Marca marca : marcasFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        marca.getId(),
                                        marca.getDescricao(),
                                        marca.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaMarca.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Marca> marcasFiltrados = new ArrayList<>();
                    marcasFiltrados = service.MarcaService.carregar("status", this.telaBuscaMarca.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Marca marca : marcasFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        marca.getId(),
                                        marca.getDescricao(),
                                        marca.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaMarca.getjButtonSair()){
            this.telaBuscaMarca.dispose();
        }
    }
    
    
    
    
    
    
}
