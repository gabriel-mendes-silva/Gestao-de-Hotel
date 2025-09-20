/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Hospede;
import view.TelaBuscaHospede;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaHospede implements ActionListener{
    private TelaBuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede(TelaBuscaHospede telaBuscaHospede) {
        this.telaBuscaHospede = telaBuscaHospede;
        
        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonBuscar().addActionListener(this);
        this.telaBuscaHospede.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()){
            if(this.telaBuscaHospede.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                ControllerCadHospede.codigo = (int) this.telaBuscaHospede.getjTableDados()
                        .getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaHospede.dispose();
            }
        }
        else if(evento.getSource() == this.telaBuscaHospede.getjButtonBuscar()){
            
            if(this.telaBuscaHospede.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 0){
                    Hospede hospede = new Hospede();
                    
                    hospede = service.HospedeService.carregar(Integer.parseInt(this.telaBuscaHospede.getjTextFieldValor().getText()));
                    
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    
                    tabela.addRow(new Object[]{hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                }
                if(this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 1){
                    JOptionPane.showMessageDialog(null, "Filtrando por Nome");
                }
                if(this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 2){
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                }
                if(this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 3){
                    JOptionPane.showMessageDialog(null, "Filtrando por Status");
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaHospede.getjButtonSair()){
            this.telaBuscaHospede.dispose();
        }
    }
    
    
    
    
    
    
}
