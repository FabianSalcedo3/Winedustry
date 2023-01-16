package datasource.regione;


import datasource.DataSourceJPA;
import entity.Regione;

public class RegioneJPA extends DataSourceJPA<Regione, Integer> implements InterfaceRegioneJPA {

    public RegioneJPA(Class<Regione> entityClass) {
        super(entityClass);
    }

}
