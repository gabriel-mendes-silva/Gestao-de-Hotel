/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        if(evento.getSource() == this.telaBuscaVaga.getjButtonCarregar()){
            JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado...");
            if(this.telaBuscaVaga.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Carregando dados para edição");
            }
        }
        else if(evento.getSource() == this.telaBuscaVaga.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "Botão filtrar pressionado...");
            if(this.telaBuscaVaga.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando por ID");
                }
                if(this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 1){
                    JOptionPane.showMessageDialog(null, "Filtrando por Nome");
                }
                if(this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 2){
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                }
                if(this.telaBuscaVaga.getjComboBoxBusca().getSelectedIndex() == 3){
                    JOptionPane.showMessageDialog(null, "Filtrando por Status");
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaVaga.getjButtonSair()){
            this.telaBuscaVaga.dispose();
        }
    }
    
    
    
    
    
    
}
