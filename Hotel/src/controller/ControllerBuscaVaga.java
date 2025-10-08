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
import model.bo.VagaEstacionamento;
import view.TelaBuscaVaga;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaVaga implements ActionListener{
    private TelaBuscaVaga telaBuscaVaga;

    public ControllerBuscaVaga(TelaBuscaVaga telaBuscaVaga) {
        this.telaBuscaVaga = telaBuscaVaga;
        
        this.telaBuscaVaga.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVaga.getjButtonBuscar().addActionListener(this);
        this.telaBuscaVaga.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaVaga.getjButtonCarregar()) {

            //Verifica se não tem dados na tabela;
            if (this.telaBuscaVaga.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            //Se houver, joga o id para a tela de cadastro;
            else {
                ControllerCadVaga.codigo = (int) this.telaBuscaVaga.getjTableDados()
                        .getValueAt(this.telaBuscaVaga.getjTableDados().getSelectedRow(), 0);

                System.out.println(ControllerCadVaga.codigo);
                this.telaBuscaVaga.dispose();
            }


        }
        else if(evento.getSource() == this.telaBuscaVaga.getjButtonBuscar()){
            if(this.telaBuscaVaga.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                if (this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 0) {
                    VagaEstacionamento vaga = new VagaEstacionamento();

                    vaga = service.VagaEstacionamentoService.carregar(Integer.parseInt(this.telaBuscaVaga.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVaga.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{
                            vaga.getId(),
                            vaga.getDescricao(),
                            vaga.getMetragemVaga(),
                            vaga.getStatus()});
                }
                if (this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<VagaEstacionamento> vagasFiltradas = new ArrayList<>();
                    vagasFiltradas = service.VagaEstacionamentoService.carregar("descricao", this.telaBuscaVaga.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVaga.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (VagaEstacionamento vaga : vagasFiltradas) {
                        tabela.addRow(
                                new Object[]{
                                        vaga.getId(),
                                        vaga.getDescricao(),
                                        vaga.getMetragemVaga(),
                                        vaga.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<VagaEstacionamento> vagasFiltradas = new ArrayList<>();
                    vagasFiltradas = service.VagaEstacionamentoService.carregar("metragem_vaga", this.telaBuscaVaga.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVaga.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (VagaEstacionamento vaga : vagasFiltradas) {
                        tabela.addRow(
                                new Object[]{
                                        vaga.getId(),
                                        vaga.getDescricao(),
                                        vaga.getMetragemVaga(),
                                        vaga.getStatus()
                                }
                        );
                    }
                }
                if(this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 3){
                    List<VagaEstacionamento> vagasFiltradas = new ArrayList<>();
                    vagasFiltradas = service.VagaEstacionamentoService.carregar("status", this.telaBuscaVaga.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVaga.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (VagaEstacionamento vaga : vagasFiltradas) {
                        tabela.addRow(
                                new Object[]{
                                        vaga.getId(),
                                        vaga.getDescricao(),
                                        vaga.getMetragemVaga(),
                                        vaga.getStatus()
                                }
                        );
                    }
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaVaga.getjButtonSair()){
            this.telaBuscaVaga.dispose();
        }
    }
    
    
    
    
    
    
}
