
import controller.ControllerCadModelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.DAO.*;
import model.bo.*;
import utilities.HospedeBuilder;
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

        Data data = new DataPadrao("32/11/2025");

        Data dataNF = new DataNaoFutura(data);

        Data dataNP = new DataNaoPassada(dataNF);

        System.out.println(dataNP.emString());


    }
}
