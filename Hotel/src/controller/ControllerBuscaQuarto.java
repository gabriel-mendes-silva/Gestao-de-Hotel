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

import model.bo.Quarto;
import view.TelaBuscaQuarto;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaQuarto implements ActionListener{
    private TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;
        
        this.telaBuscaQuarto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonBuscar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaQuarto.getjButtonCarregar()){
            if(this.telaBuscaQuarto.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadQuarto.codigo = (int) this.telaBuscaQuarto.getjTableDados()
                        .getValueAt(this.telaBuscaQuarto.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaQuarto.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaQuarto.getjButtonBuscar()){
            if (this.telaBuscaQuarto.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Quarto quarto = new Quarto();

                    quarto = service.QuartoService.carregar(Integer.parseInt(this.telaBuscaQuarto.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{
                            quarto.getId(),
                            quarto.getAndar(),
                            quarto.getCapacidadeHospedes(),
                            quarto.isFlagAnimais()});
                }
                if (this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Quarto> quartosFiltrados = new ArrayList<>();
                    quartosFiltrados = service.QuartoService.carregar("andar", this.telaBuscaQuarto.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto quarto : quartosFiltrados) {
                        tabela.addRow(new Object[]{
                                quarto.getId(),
                                quarto.getAndar(),
                                quarto.getCapacidadeHospedes(),
                                quarto.isFlagAnimais()});
                    }

                }
                if (this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Quarto> quartosFiltrados = new ArrayList<>();
                    quartosFiltrados = service.QuartoService.carregar("capacidade_hospedes", this.telaBuscaQuarto.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto quarto : quartosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        quarto.getId(),
                                        quarto.getAndar(),
                                        quarto.getCapacidadeHospedes(),
                                        quarto.isFlagAnimais()
                                }
                        );
                    }

                }
                if (this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Quarto> quartosFiltrados = new ArrayList<>();

                    int podeOUnao = 0;
                    if(this.telaBuscaQuarto.getjTextFieldValor().getText().equalsIgnoreCase("sim")){
                        podeOUnao = 1;
                    }
                    else if(this.telaBuscaQuarto.getjTextFieldValor().getText().equalsIgnoreCase("não")){
                        podeOUnao = 0;
                    }

                    quartosFiltrados = service.QuartoService.carregar("flag_animais", String.valueOf(podeOUnao));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto quarto : quartosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        quarto.getId(),
                                        quarto.getAndar(),
                                        quarto.getCapacidadeHospedes(),
                                        quarto.isFlagAnimais()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaQuarto.getjButtonSair()){
            this.telaBuscaQuarto.dispose();
        }
    }
    
    
    
    
    
    
}
