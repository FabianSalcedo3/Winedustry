package repository.datasource;


import entities.Indirizzo;
import repository.DataSourceJPA;

public class IndirizzoJPA extends DataSourceJPA<Indirizzo, String> {

    public IndirizzoJPA() {
        super(Indirizzo.class);
    }
}
