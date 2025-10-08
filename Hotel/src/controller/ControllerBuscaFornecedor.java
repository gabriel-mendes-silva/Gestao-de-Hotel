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

import model.bo.Fornecedor;
import view.TelaBuscaFornecedor;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaFornecedor implements ActionListener{
    private TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        
        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()){
            if(this.telaBuscaFornecedor.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadFornecedor.codigo = (int) this.telaBuscaFornecedor.getjTableDados()
                        .getValueAt(this.telaBuscaFornecedor.getjTableDados().getSelectedRow(), 0);

                System.out.println(ControllerCadFornecedor.codigo);
                this.telaBuscaFornecedor.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaFornecedor.getjButtonBuscar()){
            if (this.telaBuscaFornecedor.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaFornecedor.getjComboBoxBusca().getSelectedIndex() == 0) {
                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor = service.FornecedorService.carregar(Integer.parseInt(this.telaBuscaFornecedor.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(new Object[]{fornecedor.getId(), fornecedor.getNome(), fornecedor.getCpf(), fornecedor.getStatus()});
                }
                if (this.telaBuscaFornecedor.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Fornecedor> fornecedorsFiltrados = new ArrayList<>();
                    fornecedorsFiltrados = service.FornecedorService.carregar("NOME", this.telaBuscaFornecedor.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Fornecedor fornecedor : fornecedorsFiltrados) {
                        if(!fornecedor.getCpf().trim().equalsIgnoreCase(".   .   -")){
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCpf(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }
                        else{
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCnpj(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }

                    }

                }
                if (this.telaBuscaFornecedor.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Fornecedor> fornecedorsFiltrados = new ArrayList<>();

                    fornecedorsFiltrados = service.FornecedorService.carregar("CPF", this.telaBuscaFornecedor.getjTextFieldValor().getText());
                    fornecedorsFiltrados.addAll(fornecedorsFiltrados = service.FornecedorService.carregar("CNPJ", this.telaBuscaFornecedor.getjTextFieldValor().getText()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Fornecedor fornecedor : fornecedorsFiltrados) {
                        if(!fornecedor.getCpf().trim().equalsIgnoreCase(".   .   -")){
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCpf(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }
                        else{
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCnpj(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }

                    }
                }
                if (this.telaBuscaFornecedor.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Fornecedor> fornecedorsFiltrados = new ArrayList<>();
                    fornecedorsFiltrados = service.FornecedorService.carregar("STATUS", this.telaBuscaFornecedor.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Fornecedor fornecedor : fornecedorsFiltrados) {
                        if(!fornecedor.getCpf().trim().equalsIgnoreCase(".   .   -")){
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCpf(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }
                        else{
                            tabela.addRow(
                                    new Object[]{
                                            fornecedor.getId(),
                                            fornecedor.getNome(),
                                            fornecedor.getCnpj(),
                                            fornecedor.getStatus()
                                    }
                            );
                        }

                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaFornecedor.getjButtonSair()){
            this.telaBuscaFornecedor.dispose();
        }
    }
    
    
    
    
    
    
}
