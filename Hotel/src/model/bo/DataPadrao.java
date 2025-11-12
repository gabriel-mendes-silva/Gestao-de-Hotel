package model.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataPadrao implements Data{
    private LocalDate data;
    DateTimeFormatter formato;

    public DataPadrao(String data){
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            this.data = LocalDate.parse(data,formato);
        }
        catch (DateTimeParseException e){
            throw e;
        }

    }


    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public String emString() {
        return data.format(formato);
    }

}
