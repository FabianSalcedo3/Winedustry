package repository.regione;


import entities.Regione;
import repository.DataSourceJPA;

public class RegioneJPA extends DataSourceJPA<Regione, Integer> implements InterfaceRegioneJPA {

    public RegioneJPA(Class<Regione> entityClass) {
        super(entityClass);
    }

}