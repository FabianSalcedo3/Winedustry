package repository.datasource;

import entities.Utente;
import repository.DataSourceJPA;

public class UtenteJPA extends DataSourceJPA<Utente, String> {

    public UtenteJPA() {
        super(Utente.class);
    }

}
