package model.bo;

import java.time.LocalDate;

public class DataNaoFutura implements Data{
    private Data data;

    public DataNaoFutura(Data data){
        if(!data.data().isAfter(LocalDate.now())){
            this.data = data;
        }
        else{
            throw new RuntimeException("Data é posterior à data atual");
        }

    }

    @Override
    public LocalDate data() {
        return this.data.data();
    }

    @Override
    public String emString() {
        return data.emString();
    }
}
