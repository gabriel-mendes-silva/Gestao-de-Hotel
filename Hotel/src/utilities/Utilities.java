/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class Utilities {
    public static void ativaDesativa(JPanel painel, boolean ativa){
        Component [] vetComponentes = painel.getComponents();
        for(Component componenteAtual : vetComponentes){
            if(componenteAtual instanceof JButton){
                if("0".equals(((JButton)componenteAtual).getActionCommand())){
                    componenteAtual.setEnabled(ativa);
                }
                else{
                    componenteAtual.setEnabled(!ativa);
                }
            }
        }
    }
    
    public static void limpaComponentes(JPanel painel, boolean ativa){
         Component [] vetComponentes = painel.getComponents();
         
        for(Component componenteAtual : vetComponentes){
            if(componenteAtual instanceof JTextField){
                ((JTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(ativa);
            }
            else if(componenteAtual instanceof JFormattedTextField){
                ((JFormattedTextField) componenteAtual).setText("");
                 componenteAtual.setEnabled(ativa);
            }
            else if(componenteAtual instanceof JComboBox){
                ((JComboBox) componenteAtual).setSelectedIndex(-1);
                 componenteAtual.setEnabled(ativa);
            }
            else if (componenteAtual instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) componenteAtual;
                Component view = scroll.getViewport().getView(); // Aqui está a JTextArea!
    
                if (view instanceof JTextArea) {
                    ((JTextArea) view).setText("");
                    ((JTextArea) view).setEnabled(ativa);
                }
            }
            else if(componenteAtual instanceof JRadioButton){
                ((JRadioButton)componenteAtual).setSelected(false);
                componenteAtual.setEnabled(ativa);
            }
            else if(componenteAtual instanceof JCheckBox){
                ((JCheckBox)componenteAtual).setSelected(false);
                componenteAtual.setEnabled(ativa);
            }
            else if(componenteAtual instanceof JPasswordField){
                ((JPasswordField) componenteAtual).setText("");
                 componenteAtual.setEnabled(ativa);
            }
        }
    }

}
