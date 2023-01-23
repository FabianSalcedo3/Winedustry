package repository.indirizzo;


import entities.Indirizzo;
import repository.DataSourceJPA;

public class IndirizzoJPA extends DataSourceJPA<Indirizzo, String> implements InterfaceIndirizzoJPA {

    public IndirizzoJPA() {
        super(Indirizzo.class);
    }
}
