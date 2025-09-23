/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bo;

/**
 *
 * @author GABRIEL
 */
public class SexoNullable implements Sexo{
    private Sexo sexo;
    
    public SexoNullable(Sexo sexo){
        this.sexo = sexo;
    }
    
    @Override
    public String getSexo() {
        if(this.sexo.getSexo()!= null){
            return String.valueOf(this.sexo.getSexo());
        }
        else{
            return null;
        }
    }
    
}
