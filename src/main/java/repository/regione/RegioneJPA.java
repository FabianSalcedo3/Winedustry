package repository.regione;

import entities.Regione;
import repository.DataSourceJPA;

public class RegioneJPA extends DataSourceJPA<Regione, String> implements InterfaceRegioneJPA {

    public RegioneJPA() {
        super(Regione.class);
    }

}
