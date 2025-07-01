
import controller.ControllerCadHospede;
import view.TelaCadastroHospede;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GABRIEL
 */
public class Main {
    public static void main(String[] args) {
        TelaCadastroHospede tela = new TelaCadastroHospede(new javax.swing.JFrame(), true);
        ControllerCadHospede c = new ControllerCadHospede(tela);
        
        
    }
}
