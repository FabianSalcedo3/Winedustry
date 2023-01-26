package repository.datasource.ordine;


import entities.ordine.Ordine;
import repository.DataSourceJPA;

public class OrdineJPA extends DataSourceJPA<Ordine, String> {

    public OrdineJPA() {
        super(Ordine.class);
    }

    public Ordine findByCodice(String codice) {
        return super.findBySomething("where codcie=?1", codice);
    }
}
