package model.bo;

import java.time.LocalDate;

public class DataNaoPassada implements Data{
    private Data data;

    public DataNaoPassada(Data data){
        if(!data.data().isBefore(LocalDate.now())){
            this.data = data;
        }
        else{
            throw new RuntimeException("Data é anterior à data atual");
        }
    }

    @Override
    public LocalDate data() {
        return data.data();
    }

    @Override
    public String emString() {
        return data.emString();
    }
}
