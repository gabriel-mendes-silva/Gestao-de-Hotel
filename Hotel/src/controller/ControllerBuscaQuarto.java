/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaBuscaQuarto;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaQuarto implements ActionListener{
    private TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;
        
        this.telaBuscaQuarto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonBuscar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaQuarto.getjButtonCarregar()){
            JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado...");
            if(this.telaBuscaQuarto.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Carregando dados para edição");
            }
        }
        else if(evento.getSource() == this.telaBuscaQuarto.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "Botão filtrar pressionado...");
            if(this.telaBuscaQuarto.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando por ID");
                }
                if(this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 1){
                    JOptionPane.showMessageDialog(null, "Filtrando por Nome");
                }
                if(this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 2){
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                }
                if(this.telaBuscaQuarto.getjComboBoxBusca().getSelectedIndex() == 3){
                    JOptionPane.showMessageDialog(null, "Filtrando por Status");
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaQuarto.getjButtonSair()){
            this.telaBuscaQuarto.dispose();
        }
    }
    
    
    
    
    
    
}
