/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaBuscaModelo;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaModelo implements ActionListener{
    private TelaBuscaModelo telaBuscaModelo;

    public ControllerBuscaModelo(TelaBuscaModelo telaBuscaModelo) {
        this.telaBuscaModelo = telaBuscaModelo;
        
        this.telaBuscaModelo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaModelo.getjButtonBuscar().addActionListener(this);
        this.telaBuscaModelo.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaModelo.getjButtonCarregar()){
            JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado...");
            if(this.telaBuscaModelo.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Carregando dados para edição");
            }
        }
        else if(evento.getSource() == this.telaBuscaModelo.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "Botão filtrar pressionado...");
            if(this.telaBuscaModelo.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando por ID");
                }
                if(this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 1){
                    JOptionPane.showMessageDialog(null, "Filtrando por Nome");
                }
                if(this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 2){
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                }
                if(this.telaBuscaModelo.getjComboBoxBusca().getSelectedIndex() == 3){
                    JOptionPane.showMessageDialog(null, "Filtrando por Status");
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaModelo.getjButtonSair()){
            this.telaBuscaModelo.dispose();
        }
    }
    
    
    
    
    
    
}
