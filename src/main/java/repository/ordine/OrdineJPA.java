package repository.ordine;


import entities.Ordine;
import repository.DataSourceJPA;

public class OrdineJPA extends DataSourceJPA<Ordine, Integer> implements InterfaceOrdineJPA {

    public OrdineJPA() {
        super(Ordine.class);
    }

}
