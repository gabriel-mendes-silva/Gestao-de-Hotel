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

import model.bo.Funcionario;
import view.TelaBuscaFuncionario;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaFuncionario implements ActionListener{
    private TelaBuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscaFuncionario(TelaBuscaFuncionario telaBuscaFuncionario) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        
        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonBuscar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()){

            if(this.telaBuscaFuncionario.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadFuncionario.codigo = (int) this.telaBuscaFuncionario.getjTableDados()
                        .getValueAt(this.telaBuscaFuncionario.getjTableDados().getSelectedRow(), 0);

                System.out.println(ControllerCadFuncionario.codigo);
                this.telaBuscaFuncionario.dispose();



            }
        }
        else if(evento.getSource() == this.telaBuscaFuncionario.getjButtonBuscar()){
            if (this.telaBuscaFuncionario.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaFuncionario.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Funcionario funcionario = new Funcionario();

                    funcionario = service.FuncionarioService.carregar(Integer.parseInt(this.telaBuscaFuncionario.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getStatus()});
                }
                if (this.telaBuscaFuncionario.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Funcionario> funcionariosFiltrados = new ArrayList<>();
                    funcionariosFiltrados = service.FuncionarioService.carregar("NOME", this.telaBuscaFuncionario.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Funcionario funcionario : funcionariosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        funcionario.getId(),
                                        funcionario.getNome(),
                                        funcionario.getCpf(),
                                        funcionario.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaFuncionario.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Funcionario> funcionariosFiltrados = new ArrayList<>();
                    funcionariosFiltrados = service.FuncionarioService.carregar("CPF", this.telaBuscaFuncionario.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Funcionario funcionario : funcionariosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        funcionario.getId(),
                                        funcionario.getNome(),
                                        funcionario.getCpf(),
                                        funcionario.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaFuncionario.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Funcionario> funcionariosFiltrados = new ArrayList<>();
                    funcionariosFiltrados = service.FuncionarioService.carregar("STATUS", this.telaBuscaFuncionario.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Funcionario funcionario : funcionariosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        funcionario.getId(),
                                        funcionario.getNome(),
                                        funcionario.getCpf(),
                                        funcionario.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaFuncionario.getjButtonSair()){
            this.telaBuscaFuncionario.dispose();
        }
    }
    
    
    
    
    
    
}
