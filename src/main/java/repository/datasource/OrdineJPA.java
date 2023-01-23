package repository.datasource;


import entities.ordine.Ordine;
import repository.DataSourceJPA;

public class OrdineJPA extends DataSourceJPA<Ordine, String> {

    public OrdineJPA() {
        super(Ordine.class);
    }

}
