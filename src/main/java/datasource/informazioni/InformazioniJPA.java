package datasource.informazioni;

import datasource.DataSourceJPA;
import entity.Informazioni;

public class InformazioniJPA extends DataSourceJPA<Informazioni, Integer> implements InterfaceInformazioniJPA {

    public InformazioniJPA(Class<Informazioni> entityClass) {
        super(entityClass);
    }
}
