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
import model.bo.Hospede;
import view.TelaBuscaHospede;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaHospede implements ActionListener {

    private TelaBuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede(TelaBuscaHospede telaBuscaHospede) {
        this.telaBuscaHospede = telaBuscaHospede;

        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonBuscar().addActionListener(this);
        this.telaBuscaHospede.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()) {
            if (this.telaBuscaHospede.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Errrrrrouuuu. \nNão existem dados selecionados!");
            } else {
                ControllerCadHospede.codigo = (int) this.telaBuscaHospede.getjTableDados()
                        .getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                
                System.out.println(ControllerCadHospede.codigo);
                this.telaBuscaHospede.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonBuscar()) {

            if (this.telaBuscaHospede.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Hospede hospede = new Hospede();

                    hospede = service.HospedeService.carregar(Integer.parseInt(this.telaBuscaHospede.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                }
                if (this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Hospede> hospedesFiltrados = new ArrayList<>();
                    hospedesFiltrados = service.HospedeService.carregar("NOME", this.telaBuscaHospede.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Hospede hospede : hospedesFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                    hospede.getId(),
                                    hospede.getNome(),
                                    hospede.getCpf(),
                                    hospede.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Hospede> hospedesFiltrados = new ArrayList<>();
                    hospedesFiltrados = service.HospedeService.carregar("CPF", this.telaBuscaHospede.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Hospede hospede : hospedesFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                    hospede.getId(),
                                    hospede.getNome(),
                                    hospede.getCpf(),
                                    hospede.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Hospede> hospedesFiltrados = new ArrayList<>();
                    hospedesFiltrados = service.HospedeService.carregar("STATUS", this.telaBuscaHospede.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Hospede hospede : hospedesFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                    hospede.getId(),
                                    hospede.getNome(),
                                    hospede.getCpf(),
                                    hospede.getStatus()
                                }
                        );
                    }
                }

            }
        } else if (evento.getSource() == this.telaBuscaHospede.getjButtonSair()) {
            this.telaBuscaHospede.dispose();
        }
    }

}
