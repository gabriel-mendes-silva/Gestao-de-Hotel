package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ValidadorCPF implements Validador{
    @Override
    public boolean validar(String string) {
        string.replaceAll(".","");
        string.replaceAll("-","");

        char[] cpf = string.toCharArray();

        List<Integer> listaCpfNum = new ArrayList<>();

        for(char caracter : cpf){
            Integer cpfUnit = Integer.parseInt(String.valueOf(caracter));
            listaCpfNum.add(cpfUnit);
        }



    }
}
