package datasource.indirizzo;

import datasource.DataSourceJPA;
import entity.Indirizzo;

public class IndirizzoJPA extends DataSourceJPA<Indirizzo, Integer> implements InterfaceIndirizzoJPA {

    public IndirizzoJPA(Class<Indirizzo> entityClass) {
        super(entityClass);
    }
}
