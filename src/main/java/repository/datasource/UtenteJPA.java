package repository.datasource;

import entities.Utente;
import repository.DataSourceJPA;

public class UtenteJPA extends DataSourceJPA<Utente, Integer> {

    public UtenteJPA() {
        super(Utente.class);
    }

	public Utente findByUsername(String username) {
		return super.findBySomething("where username=?1", username);
	}

}