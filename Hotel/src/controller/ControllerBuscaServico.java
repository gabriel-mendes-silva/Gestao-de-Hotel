/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaBuscaServico;

/**
 *
 * @author GABRIEL
 */
public class ControllerBuscaServico implements ActionListener{
    private TelaBuscaServico telaBuscaServico;

    public ControllerBuscaServico(TelaBuscaServico telaBuscaServico) {
        this.telaBuscaServico = telaBuscaServico;
        
        this.telaBuscaServico.getjButtonCarregar().addActionListener(this);
        this.telaBuscaServico.getjButtonBuscar().addActionListener(this);
        this.telaBuscaServico.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaServico.getjButtonCarregar()){
            JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado...");
            if(this.telaBuscaServico.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null,"Errrrrrouuuu. \nNão existem dados selecionados!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Carregando dados para edição");
            }
        }
        else if(evento.getSource() == this.telaBuscaServico.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "Botão filtrar pressionado...");
            if(this.telaBuscaServico.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Sem dados para a seleção");
            }
            else{
                JOptionPane.showMessageDialog(null,"Filtrando informações");
                if(this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando por ID");
                }
                if(this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 1){
                    JOptionPane.showMessageDialog(null, "Filtrando por Nome");
                }
                if(this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 2){
                    JOptionPane.showMessageDialog(null, "Filtrando por CPF");
                }
                if(this.telaBuscaServico.getjComboBoxBusca().getSelectedIndex() == 3){
                    JOptionPane.showMessageDialog(null, "Filtrando por Status");
                }
                
            }
        }
        else if(evento.getSource() == this.telaBuscaServico.getjButtonSair()){
            this.telaBuscaServico.dispose();
        }
    }
    
    
    
    
    
    
}
