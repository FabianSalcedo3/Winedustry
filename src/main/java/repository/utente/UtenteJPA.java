package repository.utente;


import entities.Utente;
import repository.DataSourceJPA;

public class UtenteJPA extends DataSourceJPA<Utente, Integer> implements InterfaceUtenteJPA {

    public UtenteJPA() {
        super(Utente.class);
    }
}
