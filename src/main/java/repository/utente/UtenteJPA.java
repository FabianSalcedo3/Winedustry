package repository.utente;


import entities.Utente;
import repository.DataSourceJPA;

public class UtenteJPA extends DataSourceJPA<Utente, Integer> implements InterfaceUtenteJPA {

    public UtenteJPA(Class<Utente> entityClass) {
        super(entityClass);
    }

}
