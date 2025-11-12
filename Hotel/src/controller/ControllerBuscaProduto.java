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

import model.bo.ProdutoCopa;
import view.TelaBuscaProduto;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaProduto implements ActionListener{
    private TelaBuscaProduto telaBuscaProduto;


    public ControllerBuscaProduto(TelaBuscaProduto telaBuscaProduto) {
        this.telaBuscaProduto = telaBuscaProduto;
        
        this.telaBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaProduto.getjButtonBuscar().addActionListener(this);
        this.telaBuscaProduto.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaProduto.getjButtonCarregar()){
            if(this.telaBuscaProduto.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadProduto.codigo = (int) this.telaBuscaProduto.getjTableDados()
                        .getValueAt(this.telaBuscaProduto.getjTableDados().getSelectedRow(), 0);

                this.telaBuscaProduto.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaProduto.getjButtonBuscar()){
            if (this.telaBuscaProduto.getjTextFieldValor().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Sem dados para a seleção");
            } else {

                if (this.telaBuscaProduto.getjComboBoxBusca().getSelectedIndex() == 0) {
                    ProdutoCopa produto = new ProdutoCopa();

                    produto = service.ProdutoService.carregar(Integer.parseInt(this.telaBuscaProduto.getjTextFieldValor().getText()));
                    System.out.println(produto);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    tabela.addRow(
                            new Object[]{
                                    produto.getId(),
                                    produto.getDescricao(),
                                    produto.getValor(),
                                    produto.getStatus()
                            }
                    );
                }
                if (this.telaBuscaProduto.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<ProdutoCopa> produtosFiltrados = new ArrayList<>();
                    produtosFiltrados = service.ProdutoService.carregar("descricao", this.telaBuscaProduto.getjTextFieldValor().getText());
                    System.out.println(produtosFiltrados);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (ProdutoCopa produto : produtosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        produto.getId(),
                                        produto.getDescricao(),
                                        produto.getValor(),
                                        produto.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaProduto.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<ProdutoCopa> produtosFiltrados = new ArrayList<>();
                    produtosFiltrados = service.ProdutoService.carregar("valor", this.telaBuscaProduto.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (ProdutoCopa produto : produtosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        produto.getId(),
                                        produto.getDescricao(),
                                        produto.getValor(),
                                        produto.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaProduto.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<ProdutoCopa> produtosFiltrados = new ArrayList<>();
                    produtosFiltrados = service.ProdutoService.carregar("status", this.telaBuscaProduto.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (ProdutoCopa produto : produtosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        produto.getId(),
                                        produto.getDescricao(),
                                        produto.getValor(),
                                        produto.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaProduto.getjButtonSair()){
            this.telaBuscaProduto.dispose();
        }
    }
    
    
    
    
    
    
}
