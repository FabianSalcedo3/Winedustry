package repository.datasource;

import entities.Regione;
import repository.DataSourceJPA;

public class RegioneJPA extends DataSourceJPA<Regione, String>{

    public RegioneJPA() {
        super(Regione.class);
    }

	public Regione findByNome(String nome) {
		return super.findBySomething("where nome=?1",nome);
	}

}