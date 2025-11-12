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
import model.bo.VagaEstacionamento;
import model.bo.Veiculo;
import service.MarcaService;
import view.TelaBuscaVeiculo;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaVeiculo implements ActionListener{
    private TelaBuscaVeiculo telaBuscaVeiculo;

    public ControllerBuscaVeiculo(TelaBuscaVeiculo telaBuscaVeiculo) {
        this.telaBuscaVeiculo = telaBuscaVeiculo;
        
        this.telaBuscaVeiculo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonBuscar().addActionListener(this);
        this.telaBuscaVeiculo.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaVeiculo.getjButtonCarregar()) {

            //Verifica se não tem dados na tabela;
            if (this.telaBuscaVeiculo.getjTableDados().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            //Se houver, joga o id para a tela de cadastro;
            else {
                ControllerCadVeiculo.codigo = (int) this.telaBuscaVeiculo.getjTableDados()
                        .getValueAt(this.telaBuscaVeiculo.getjTableDados().getSelectedRow(), 0);

                System.out.println(ControllerCadVeiculo.codigo);
                this.telaBuscaVeiculo.dispose();
            }


        }
        else if(evento.getSource() == this.telaBuscaVeiculo.getjButtonBuscar()){
            if(this.telaBuscaVeiculo.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 0) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();
                    veiculosFiltrados = service.VeiculoService.carregar("v.Id", this.telaBuscaVeiculo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 1) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();
                    veiculosFiltrados = service.VeiculoService.carregar("v.Placa", this.telaBuscaVeiculo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }

                }
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 2) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();

                    Marca marca = MarcaService.carregar("descricao",this.telaBuscaVeiculo.getjTextFieldValor().getText()).getFirst();


                    veiculosFiltrados = service.VeiculoService.carregar("marca_id", String.valueOf(marca.getId()));

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 3) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();


                    veiculosFiltrados = service.VeiculoService.carregar("m.descricao", this.telaBuscaVeiculo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 4) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();
                    veiculosFiltrados = service.VeiculoService.carregar("v.Cor", this.telaBuscaVeiculo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }
                }
                if (this.telaBuscaVeiculo.getjComboBoxBusca().getSelectedIndex() == 5) {
                    List<Veiculo> veiculosFiltrados = new ArrayList<>();
                    veiculosFiltrados = service.VeiculoService.carregar("v.Status", this.telaBuscaVeiculo.getjTextFieldValor().getText());

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaVeiculo.getjTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Veiculo veiculo : veiculosFiltrados) {
                        tabela.addRow(
                                new Object[]{
                                        veiculo.getId(),
                                        veiculo.getPlaca(),
                                        veiculo.getModelo().getMarca().getDescricao(),
                                        veiculo.getModelo().getDescricao(),
                                        veiculo.getCor(),
                                        veiculo.getStatus()
                                }
                        );
                    }
                }

            }
        }
        else if(evento.getSource() == this.telaBuscaVeiculo.getjButtonSair()){
            this.telaBuscaVeiculo.dispose();
        }
    }
    
    
    
    
    
    
}
