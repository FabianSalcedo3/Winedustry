package repository.regione;


import entities.Regione;
import repository.DataSourceJPA;

public class RegioneJPA extends DataSourceJPA<Regione, Integer> implements InterfaceRegioneJPA {

    public RegioneJPA() {
        super(Regione.class);
    }

}
