package repository.ordine;


import entities.Ordine;
import repository.DataSourceJPA;

public class OrdineJPA extends DataSourceJPA<Ordine, String> implements InterfaceOrdineJPA {

    public OrdineJPA() {
        super(Ordine.class);
    }

}
