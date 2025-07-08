/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaBuscaHospede;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaFornecedor implements ActionListener{
    private TelaBuscaHospede telaBuscaHospede;

    public ControllerBuscaFornecedor(TelaBuscaHospede telaBuscaHospede) {
        this.telaBuscaHospede = telaBuscaHospede;
        
        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonBuscar().addActionListener(this);
        this.telaBuscaHospede.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()){
            JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado...");
            if(this.telaBuscaHospede.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Carregando dados para edição");
            }
        }
        else if(evento.getSource() == this.telaBuscaHospede.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "Botão filtrar pressionado...");
            if(this.telaBuscaHospede.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaHospede.getjComboBoxBusca().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando por ID");
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
