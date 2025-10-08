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

import model.bo.Servico;
import view.TelaBuscaServico;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaServico implements ActionListener{
    private TelaBuscaServico telaBuscaServico;


    public ControllerBuscaServico(TelaBuscaServico telaBuscaServico) {
        this.telaBuscaServico = telaBuscaServico;
        
        this.telaBuscaServico.getjButtonCarregar().addActionListener(this);
        this.telaBuscaServico.getjButtonBuscar().addActionListener(this);
        this.telaBuscaServico.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaServico.getjButtonCarregar()) {

            //Verifica se não tem dados na tabela;
            if (this.telaBuscaServico.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            //Se houver, joga o id para a tela de cadastro;
            else {
                ControllerCadServico.codigo = (int) this.telaBuscaServico.getjTableDados()
                        .getValueAt(this.telaBuscaServico.getjTableDados().getSelectedRow(), 0);

                System.out.println(ControllerCadServico.codigo);
                this.telaBuscaServico.dispose();
            }


        }
        else if(evento.getSource() == this.telaBuscaServico.getjButtonBuscar()){
            if (this.telaBuscaServico.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Servico servico = new Servico();

                    servico = service.ServicoService.carregar(Integer.parseInt(this.telaBuscaServico.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{servico.getId(), servico.getDescricao(), servico.getStatus()});
                }
                if (this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Servico> servicosFiltrados = new ArrayList<>();
                    servicosFiltrados = service.ServicoService.carregar("descricao", this.telaBuscaServico.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Servico servico : servicosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        servico.getId(),
                                        servico.getDescricao(),
                                        servico.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Servico> servicosFiltrados = new ArrayList<>();
                    servicosFiltrados = service.ServicoService.carregar("status", this.telaBuscaServico.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Servico servico : servicosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        servico.getId(),
                                        servico.getDescricao(),
                                        servico.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaServico.getjButtonSair()){
            this.telaBuscaServico.dispose();
        }
    }
    
    
    
    
    
    
}
