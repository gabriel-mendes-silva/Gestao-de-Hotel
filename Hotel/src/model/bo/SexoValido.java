/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

import java.util.InputMismatchException;

/**
 *
 * @author GABRIEL
 */
public class SexoValido implements Sexo{
    private char sexo;
    
    public SexoValido(char sexo){
        this.sexo = sexo;
    }
    
    public SexoValido(String string){
        if(string != null){
            this.sexo = string.charAt(0);
        }
    }
    
    @Override
    public String getSexo() {
        Character character = sexo;
        if(sexo == 'F' || sexo == 'M' || sexo == 'O'){
           return String.valueOf(sexo);
        }
        else if(sexo == 'f' || sexo == 'm' || sexo == 'o'){
            return String.valueOf(sexo);
        }
        else if(sexo == '\u0000'){
            return null;
        }
        else{
            throw new InputMismatchException("Valor para sexo é inválido!!");
        }
    }
    
   
    
}
